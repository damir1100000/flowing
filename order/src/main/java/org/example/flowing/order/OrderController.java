package org.example.flowing.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder (@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(this.orderService.createOrder(orderDTO));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders () {
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }
}
