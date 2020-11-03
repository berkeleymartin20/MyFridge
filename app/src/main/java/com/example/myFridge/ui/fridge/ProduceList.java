package com.example.myFridge.ui.fridge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ProduceList {
    public static ArrayList<String> items;
    public static HashMap<String,LocalDate> itemsAndDates;
    public static HashMap<String,Integer> itemsAndQty;

    public ProduceList() {
        items = new ArrayList<>();
        itemsAndDates = new HashMap<>();
        itemsAndQty = new HashMap<>();

        ProduceList.addItem("Carrot",3, LocalDate.of(2020,1,8));
        ProduceList.addItem("Broccoli",3, LocalDate.of(2020,3,8));
        ProduceList.addItem("Cilantro",3, LocalDate.of(2020,2,8));
        ProduceList.addItem("Mushrooms",3, LocalDate.of(2020,2,8));
        ProduceList.addItem("Green Onion",3, LocalDate.of(2020,2,8));
        ProduceList.addItem("Avocado",3, LocalDate.of(2020,2,8));
        ProduceList.addItem("Banana",3, LocalDate.of(2020,2,8));

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
