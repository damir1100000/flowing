package org.example.flowing.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="orders")
@Entity
@Getter @Setter @AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    @ElementCollection
    private List<ProductDTO> products;

    public OrderEntity () {

    }

    public OrderEntity (OrderDTO orderDTO) {
        this.customerName = orderDTO.getCustomerName();
        this.customerAddress = orderDTO.getCustomerAddress();
        this.customerEmail = orderDTO.getCustomerEmail();
        this.products = orderDTO.getProducts();
    }
}
