package org.example.flowing.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="items")
@Getter @Setter @AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String productName;
    @Column
    private String productId;
    @Column
    private int quantity;

    public ItemEntity () {

    }
    public ItemEntity (ItemDTO itemDTO) {
        this.productId = itemDTO.getProductId();
        this.productName = itemDTO.getProductName();
        this.quantity = itemDTO.getQuantity();
    }
}
