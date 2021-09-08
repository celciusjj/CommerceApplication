package com.celcius.tiendapatrones;

public class ProductoPeso implements ICalculador {
    public double realProductPrice(double price, int quantity) {
        return quantity * price * 1000;
    }
}
