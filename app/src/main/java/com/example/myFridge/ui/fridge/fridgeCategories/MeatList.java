package com.example.myFridge.ui.fridge.fridgeCategories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MeatList {
    public static ArrayList<String> items;
    public static HashMap<String,LocalDate> itemsAndDates;
    public static HashMap<String,Integer> itemsAndQty;
    public static ArrayList<Node> itemsAndDatesAL;

    public MeatList() {
        items = new ArrayList<>();
        itemsAndDates = new HashMap<>();
        itemsAndQty = new HashMap<>();
        itemsAndDatesAL = new ArrayList<>();

        MeatList.addItem("Pork (lb)",2, LocalDate.of(2020,11,7));
        MeatList.addItem("Beef (lb)",5, LocalDate.of(2020,11,10));
        MeatList.addItem("Chicken",1, LocalDate.of(2020,11,8));

        //TODO: initialize these items based on the file saved

    }

    public static void addItem(String item, int quantity, LocalDate date) {
        items.add(item);
        itemsAndQty.put(item,quantity);
        itemsAndDates.put(item,date);
        itemsAndDatesAL.add(new Node(item,date));
        itemsAndDatesAL.sort(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.getDate().compareTo(node2.getDate());
            }
        });
    }

    public static void replaceItemQuantity(String item, int quantity) {
        itemsAndQty.replace(item,quantity);
    }

    public static void replaceItemDate(String item, LocalDate date) {
        itemsAndDates.replace(item,date);
        itemsAndDatesAL.remove(new Node(item,itemsAndDates.get(item)));
        itemsAndDatesAL.add(new Node(item,date));
        itemsAndDatesAL.sort(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.getDate().compareTo(node2.getDate());
            }
        });
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
        int idx = -1;
        for(Node s : itemsAndDatesAL) {
            idx++;
            if(s.getName().equals(item)) {
                break;
            }
        }
        itemsAndDatesAL.remove(idx);
        itemsAndDates.remove(item);
    }


}
