package org.example.flowing.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;

    public ProductDTO (ProductEntity product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.quantity = product.getQuantity();
    }
}
