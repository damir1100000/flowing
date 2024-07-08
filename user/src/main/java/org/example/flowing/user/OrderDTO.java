package org.example.flowing.user;

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

    public OrderDTO (UserEntity entity) {
        this.customerName = entity.getFirstName() + " " + entity.getLastName();
        this.customerAddress = entity.getAddress();
        this.customerEmail = entity.getEmail();
    }
}
