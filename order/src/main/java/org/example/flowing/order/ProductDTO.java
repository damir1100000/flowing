package org.example.flowing.order;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductDTO(String id, String name, double price, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity () {
        return this.quantity;
    }
}
