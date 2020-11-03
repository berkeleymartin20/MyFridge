package com.example.myFridge.ui.fridge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SeafoodList {
    public static ArrayList<String> items;
    public static HashMap<String,LocalDate> itemsAndDates;
    public static HashMap<String,Integer> itemsAndQty;

    public SeafoodList() {
        items = new ArrayList<>();
        itemsAndDates = new HashMap<>();
        itemsAndQty = new HashMap<>();

        SeafoodList.addItem("Salmon",3, LocalDate.of(2020,1,8));
        SeafoodList.addItem("Tuna",3, LocalDate.of(2020,3,8));

        //TODO: initialize these items based on the file saved

    }

    public static void addItem(String item, int quantity, LocalDate date) {
        items.add(item);
        itemsAndQty.put(item,quantity);
        itemsAndDates.put(item,date);
    }

    public static void replaceItemQuantity(String item, int quantity) {
        itemsAndQty.replace(item,quantity);
    }

    public static void replaceItemDate(String item, LocalDate date) {
        itemsAndDates.replace(item,date);
    }

    public static String getItem(int pos){
        return items.get(pos);
    }

    public static int getSize(){
        return items.size();
    }
    public static void removeItem(String item) {
        items.remove(item);
        itemsAndQty.remove(item);
        itemsAndDates.remove(item);
    }


}
