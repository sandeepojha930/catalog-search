package com.test.productCatalogue.event;

public class SupplierEvent {
    private String name;
    private String brand;
    private String category;
    private double price;
    private String color;
    private String size;
    private String sku;
    private int avlQty;

    public SupplierEvent(String name, String brand, String category,
                         double price, String color, String size, String sku, int avlQty) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.color = color;
        this.size = size;
        this.sku = sku;
        this.avlQty = avlQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getAvlQty() {
        return avlQty;
    }

    public void setAvlQty(int avlQty) {
        this.avlQty = avlQty;
    }
}
