package org.example.flowing.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUpdateService {
    @Autowired
    private OrderRepository orderRepository;

    public void updateProductInOrders(ProductDTO updatedProduct) {
        List<OrderEntity> orders = orderRepository.findAll();
        for (OrderEntity order : orders) {
            boolean updated = false;
            for (ProductDTO product : order.getProducts()) {
                if (product.getId().equals(updatedProduct.getId())) {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPrice(updatedProduct.getPrice());
                    product.setCategory(updatedProduct.getCategory());
                    updated = true;
                }
            }
            if (updated) {
                orderRepository.save(order);
            }
        }
    }
}
