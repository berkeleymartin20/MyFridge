package com.example.myFridge.ui.shoppinglist;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import static java.util.Map.entry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RequiresApi(api = Build.VERSION_CODES.R)
public class ShoppingList {

    static ArrayList<String> items;
    static HashMap<String,Integer> itemsAndQty;

    public ShoppingList(){
        items = new ArrayList<>();
        itemsAndQty = new HashMap<>();
        /*items = new ArrayList<>(Arrays.asList("potato","pasta","tomato"));
        itemsAndQty = new HashMap<>(Map.ofEntries(Map.entry("potato",3),Map.entry("pasta",5),Map.entry("tomato",2)));*/
    }

    public static void add(String item, int num) {
        items.add(item);
        itemsAndQty.put(item,num);
    }
    public static void removeItem(String item) {
        items.remove(item);
        itemsAndQty.remove(item);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void replaceQuantity(String item, int newNum) {
        itemsAndQty.replace(item,newNum);
    }

    public static String getNameAndQtyInOrder(int i) {
        return items.get(i) + "   Qty: " + itemsAndQty.get(items.get(i));
    }
}
