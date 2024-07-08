package org.example.flowing.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Table(name="products")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private int quantity;

    public ProductEntity () {

    }

    public ProductEntity (ProductDTO product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.quantity = product.getQuantity();
    }
}
