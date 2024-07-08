package org.example.flowing.inventory;

import org.example.flowing.inventory.dtos.OrderDTO;
import org.example.flowing.inventory.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private KafkaTemplate<String, ItemDTO> kafkaTemplate;

    public ItemDTO createItem (ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity(itemDTO);
        this.inventoryRepository.save(itemEntity);
        this.kafkaTemplate.send("inventory_topic", itemDTO);
        return new ItemDTO(itemEntity);
    }

    public List<ItemDTO> getAllItems () {
        List<ItemEntity> itemEntities = this.inventoryRepository.findAll();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        for(ItemEntity itemEntity : itemEntities) {
            itemDTOS.add(new ItemDTO(itemEntity));
        }
        return itemDTOS;
    }

    public ItemDTO updateQuantity (String productId, int quantity) {
        ItemEntity itemEntity = this.inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in the inventory"));
        itemEntity.setQuantity(quantity);
        this.inventoryRepository.save(itemEntity);
        return new ItemDTO(itemEntity);
    }

    @KafkaListener(topics = "product_topic", groupId = "inventory_group")
    public void consumeProductUpdate (ProductDTO productDTO) {
        ItemEntity itemEntity = this.inventoryRepository.findByProductId(productDTO.getId())
                .orElseThrow(() -> new RuntimeException("Product not found in the inventory"));
        itemEntity.setQuantity(productDTO.getQuantity());
        this.inventoryRepository.save(itemEntity);
    }

    @KafkaListener(topics = "order_topic", groupId = "inventory_group")
    public void consumerOrder (OrderDTO orderDTO) {
        for(ProductDTO productDTO : orderDTO.getProducts()) {
            ItemEntity itemEntity = this.inventoryRepository.findByProductId(productDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Inventory item not found for product ID: " + productDTO.getId()));
            itemEntity.setQuantity(itemEntity.getQuantity() - 1);
            this.inventoryRepository.save(itemEntity);
        }
    }
}
