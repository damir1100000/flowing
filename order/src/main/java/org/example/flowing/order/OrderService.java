package org.example.flowing.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductUpdateService productUpdateService;
    @Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;
    public OrderDTO createOrder (OrderDTO order) {
        OrderEntity orderEntity = new OrderEntity(order);
        this.orderRepository.save(orderEntity);
        this.kafkaTemplate.send("order_topic", order);
        return new OrderDTO(orderEntity);
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        List<OrderEntity> orderEntities = this.orderRepository.findAll();
        for(OrderEntity orderEntity : orderEntities) {
            orderDTOS.add(new OrderDTO(orderEntity));
        }
        return orderDTOS;
    }

    @KafkaListener(topics = "product_topic", groupId = "order_group")
    public void consumeProduct(ProductDTO product) {
        System.out.println("Received product update: " + product.getName());
        this.productUpdateService.updateProductInOrders(product);
    }
}