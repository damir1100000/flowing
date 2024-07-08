package org.example.flowing.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO {
    private String productId;
    private String productName;
    private int quantity;

    public ItemDTO (ItemEntity itemEntity) {
        this.productId = itemEntity.getProductId();
        this.productName = itemEntity.getProductName();
        this.quantity = itemEntity.getQuantity();
    }
}
