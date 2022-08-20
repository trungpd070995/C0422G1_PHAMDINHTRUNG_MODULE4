package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String productDescription;
    private String producer;

    public Product() {
    }

    public Product(String name, double price, String productDescription, String producer) {
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public Product(int id, String name, double price, String productDescription, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public Product clone() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setProducer(producer);
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}