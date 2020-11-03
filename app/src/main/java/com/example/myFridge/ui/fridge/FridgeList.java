package com.example.myFridge.ui.fridge;

import java.util.ArrayList;
import java.util.List;

public class FridgeList {

    public static List<Section> sectionList;

    public FridgeList(){
        String produce = "Produce";
        ArrayList<String> produceItems = ProduceList.items;
        String meat = "Meat";
        ArrayList<String> meatItems = MeatList.items;
        String seafood = "Seafood";
        ArrayList<String> seafoodItems = SeafoodList.items;
        String freezer = "Freezer";
        ArrayList<String> freezerItems = FreezerList.items;
        sectionList = new ArrayList<>();
        sectionList.add(new Section(produce,produceItems));
        sectionList.add(new Section(meat,meatItems));
        sectionList.add(new Section(seafood,seafoodItems));
        sectionList.add(new Section(freezer,freezerItems));
    }
    public static List<Section> getSectionList(){
        return sectionList;
    }
}
