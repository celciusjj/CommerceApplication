package com.celcius.tiendapatrones;

import java.util.Iterator;
import java.util.Map;

public class Venta {
    double totalPrice;
    double individualPrice;

    public void calculateTotalPrice(){
        Iterator products = Tienda.getShoppingCart().entrySet().iterator();
        while (products.hasNext()) {
            Map.Entry mapElement = (Map.Entry) products.next();
            Producto producto = (Producto) mapElement.getKey();
            if(producto.getSKU() == TipoProducto.EA){
                ProductoNormal productoNormal = new ProductoNormal();
                individualPrice = productoNormal.realProductPrice(producto.getPrice(), Integer.parseInt(String.valueOf(mapElement.getValue())));
                System.out.println(producto.getName() + " ------------------->" + individualPrice + "$");
                totalPrice += individualPrice;
            }else if(producto.getSKU() == TipoProducto.SP){
                ProductoEspecial productoEspecial = new ProductoEspecial();
                individualPrice = productoEspecial.realProductPrice(producto.getPrice(), Integer.parseInt(String.valueOf(mapElement.getValue())));
                System.out.println(producto.getName() + " ------------------->" + individualPrice + "$");
                totalPrice += individualPrice;
            }else if(producto.getSKU() == TipoProducto.WE){
                ProductoPeso productoPeso = new ProductoPeso();
                individualPrice = productoPeso.realProductPrice(producto.getPrice(), Integer.parseInt(String.valueOf(mapElement.getValue())));
                System.out.println(producto.getName() + " ------------------->" + individualPrice + "$");
                totalPrice += individualPrice;
            }
        }
        System.out.println("Precio total: " + totalPrice);
    }

}
