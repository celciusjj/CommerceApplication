package com.celcius.tiendapatrones;

public class ProductoEspecial implements ICalculador{
    public double realProductPrice(double price, int quantity) {
        int totalOffers = quantity/3;
        if (totalOffers >= 3) {
            return price - (price * 0.5);
        } else {
            return price - (price * 0.2 * totalOffers);
        }
    }
}
