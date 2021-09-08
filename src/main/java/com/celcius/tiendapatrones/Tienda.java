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

            if(verifyIfStock(id, quantity)){
                CarritoCompras carrito = new CarritoCompras();
                carrito.añadirProducto(getTheProduct(id), quantity);

                database.removeQuantityFromStock(id, quantity);
            }
        }
        Venta venta = new Venta();
        venta.calculateTotalPrice();
    }

    static Producto getTheProduct(int id){
        Producto producto = null;
        for(JSONObject data: database.getProducts()){
            if(data.getInt("id") == id){
                if(data.getString("SKU").equals("EA")){
                    producto = new Producto(TipoProducto.EA, data.getString("name"), data.getString("description"), data.getInt("quantity"), data.getDouble("price"), data.getInt("id"));
                }else if(data.getString("SKU").equals("WE")){
                    producto = new Producto(TipoProducto.WE, data.getString("name"), data.getString("description"), data.getInt("quantity"), data.getDouble("price"), data.getInt("id"));
                }else if (data.getString("SKU").equals("SP")){
                    producto = new Producto(TipoProducto.SP, data.getString("name"), data.getString("description"), data.getInt("quantity"), data.getDouble("price"), data.getInt("id"));
                }
            }
        }
        return producto;
    }

    static boolean verifyIfStock(int id, int quantity){
        for(JSONObject data: database.getProducts()){
            if(data.getInt("id") == id){
                if(data.getInt("quantity") >= quantity){
                    return true;
                }else{
                    System.out.println("No hay la cantidad en stock");
                }
            }
        }
        return false;
    }

    public static void setDatabase(DatabaseManager database) {
        Tienda.database = database;
    }

    public static HashMap<Producto, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public static void setShoppingCart(HashMap<Producto, Integer> shoppingCart) {
        Tienda.shoppingCart = shoppingCart;
    }
}
