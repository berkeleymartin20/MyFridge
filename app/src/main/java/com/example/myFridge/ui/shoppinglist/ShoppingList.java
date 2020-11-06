package com.example.myFridge.ui.shoppinglist;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import static java.util.Map.entry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



@RequiresApi(api = Build.VERSION_CODES.R)
public class ShoppingList {

    public static ArrayList<Boolean> itemsChecked;
    public static ArrayList<String> items; //coded with 01 in file. This is saved to preserve order
    public static HashMap<String,Integer> itemsAndQty; //coded with 02 in file. This is saved to preserve name and qty pairs.

    public ShoppingList() throws FileNotFoundException {
        items = new ArrayList<>();
        itemsAndQty = new HashMap<>();
        itemsChecked = new ArrayList<>();

        ShoppingList.add("Turkey",1);
        ShoppingList.add("Eggs",12);
        ShoppingList.add("Pancake Mix",1);
        ShoppingList.add("Cooking Oil",1);
        ShoppingList.add("Flour",2);
        ShoppingList.add("Hot Cheetos",3);

    }

    public static void add(String item, int num) {
        items.add(item);
        itemsChecked.add(false);
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

    public static int getSize(){
        return items.size();
    }

    public static int getQty(String name) {
        return itemsAndQty.get(name);
    }
    public static Boolean getChecked(int index) {
        return itemsChecked.get(index);
    }
    public static String[] getNameAndQtyInOrder(int i) {
        String item = items.get(i);
        String[] returnThis = new String[]{item, "" +itemsAndQty.get(item)};
        return returnThis;
    }
}
