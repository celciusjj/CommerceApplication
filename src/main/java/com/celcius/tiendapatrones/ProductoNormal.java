package com.celcius.tiendapatrones;

public class ProductoNormal implements ICalculador{
    public double realProductPrice(double price, int quantity) {
        return quantity * price;
    }
}
