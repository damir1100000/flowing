package org.example.flowing.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OrderDTO {
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private List<ProductDTO> products;

    public OrderDTO (OrderEntity entity) {
        this.customerName = entity.getCustomerName();
        this.customerAddress = entity.getCustomerAddress();
        this.customerEmail = entity.getCustomerEmail();
        this.products = entity.getProducts();
    }
}
