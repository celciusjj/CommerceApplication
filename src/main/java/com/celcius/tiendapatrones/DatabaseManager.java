package com.celcius.tiendapatrones;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
     JSONObject producto1 = new JSONObject("{ \"SKU\": \"EA\", \"name\": Diego de peluche, \"description\": \"Osito gordito, que te espanta en las noches\", \"quantity\": \"4\", \"price\": 1, \"id\": 5}");
     JSONObject producto2 = new JSONObject("{ \"SKU\": \"WE\", \"name\": papas, \"description\": \"ricas francesas\", \"quantity\": \"6\", \"price\": 10, \"id\": 6}");
    private List<JSONObject> products = new ArrayList<JSONObject>();

     DatabaseManager(){
         getProducts().add(producto1);
         getProducts().add(producto2);
     }

    public List<JSONObject> getProducts() {
        return products;
    }

    Producto getTheProduct(int id){
        Producto producto = null;
        for(JSONObject data: getProducts()){
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

    boolean verifyIfStock(int id, int quantity){
        for(JSONObject data: getProducts()){
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

    public void removeQuantityFromStock(int id, int quantity){
        for(JSONObject data: getProducts()){
            if(data.getInt("id") == id){
                int oldQuantity = data.getInt("quantity");
                int newQuantity = oldQuantity - quantity;
                System.out.println("Nueva cantidad en stock: " +  newQuantity);
                data.put("quantity", newQuantity);
            }
        }
    }

    public void setProducts(List<JSONObject> products) {
        this.products = products;
    }
}
