package com.celcius.tiendapatrones;

public class Producto {
    private TipoProducto SKU;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private int id;

    Producto(TipoProducto SKU, String name, String description, int quantity, double price, int id){
        this.setSKU(SKU);
        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setPrice(price);
        this.setId(id);
    }

    public TipoProducto getSKU() {
        return SKU;
    }

    public void setSKU(TipoProducto SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
