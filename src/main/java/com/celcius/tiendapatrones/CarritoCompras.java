package com.celcius.tiendapatrones;

public class CarritoCompras {

    public void añadirProducto(Producto producto, int quantity){
        Tienda.getShoppingCart().put(producto, quantity);
    }

    public void removeProducto(Producto producto, int quantity){
        Tienda.getShoppingCart().remove(producto);
    }
}
