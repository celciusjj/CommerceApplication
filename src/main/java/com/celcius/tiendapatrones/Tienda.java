package com.celcius.tiendapatrones;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Scanner;

public class Tienda {

    private static HashMap<Producto, Integer> shoppingCart = new HashMap<Producto, Integer>();
    private static DatabaseManager database;

    public static void main(String[] args) {
        database = new DatabaseManager();
        int quantity = 0;
        int id = 0;

        for(int i = 0; i < database.getProducts().size(); i++){
            Scanner userInput = new Scanner(System.in);
            System.out.print("Ingrese el id del producto: ");
            if (userInput.hasNextInt()) {
                id = userInput.nextInt();
            }
            System.out.print("Ingrese la cantidad: ");
            userInput.nextLine();
            if (userInput.hasNextLine()) {
                quantity = userInput.nextInt();
            }

            if(database.verifyIfStock(id, quantity)){
                CarritoCompras carrito = new CarritoCompras();
                carrito.añadirProducto(database.getTheProduct(id), quantity);

                database.removeQuantityFromStock(id, quantity);
            }
        }
        Venta venta = new Venta();
        venta.calculateTotalPrice();
    }


    public static HashMap<Producto, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public static void setShoppingCart(HashMap<Producto, Integer> shoppingCart) {
        Tienda.shoppingCart = shoppingCart;
    }
}
