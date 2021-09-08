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
