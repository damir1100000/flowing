package org.example.flowing.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private KafkaTemplate<String, ProductDTO> kafkaTemplate;

    public ProductDTO createProduct (ProductDTO productDTO) {
        ProductEntity product = this.productRepository.save(new ProductEntity(productDTO));
        kafkaTemplate.send("product_topic", productDTO);
        return new ProductDTO(product);
    }

    public List<ProductDTO> getAllProducts () {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductEntity> products = this.productRepository.findAll();
        for(ProductEntity product : products) {
            productDTOS.add(new ProductDTO(product));
        }
        return productDTOS;
    }

    public void deleteProduct(String id) {
        this.productRepository.deleteById(id);
    }
}
