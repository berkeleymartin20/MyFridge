package com.example.myFridge.ui.fridge.fridgeCategories;

import java.time.LocalDate;
import java.util.Objects;

public class Node {
    private String itemName;
    private LocalDate expDate;

    public Node(String itemName, LocalDate expDate) {
        this.itemName = itemName;
        this.expDate = expDate;
    }


    public LocalDate getDate(){
        return expDate;
    }
    public String getName(){
        return itemName;
    }
}
