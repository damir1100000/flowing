package org.example.flowing.inventory.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;
}
