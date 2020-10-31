package com.example.myFridge.ui.shoppinglist;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;


@RequiresApi(api = Build.VERSION_CODES.M)
public class ShoppingList {

    static ArrayList<String> items = new ArrayList<>();
    static HashMap<String,Integer> itemsAndQty = new HashMap<>();

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
        return items.get(i) + "  " + itemsAndQty.get(items.get(i));
    }
}
