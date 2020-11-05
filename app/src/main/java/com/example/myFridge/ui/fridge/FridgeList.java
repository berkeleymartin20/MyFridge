package com.example.myFridge.ui.fridge;

import com.example.myFridge.ui.fridge.fridgeCategories.FreezerList;
import com.example.myFridge.ui.fridge.fridgeCategories.MeatList;
import com.example.myFridge.ui.fridge.fridgeCategories.ProduceList;
import com.example.myFridge.ui.fridge.fridgeCategories.SeafoodList;

import java.time.LocalDate;
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

    //Returns list of Section objects, which have a String for the section title and List<String> for objects for that section
    public static List<Section> getSectionList(){
        return sectionList;
    }

    //Returns a boolean depending if FridgeList contains the item, when String of item name is given. This method searches through all lists
    public static boolean contains(String item) {
        List<String> allItems = new ArrayList<>();
        for(Section s : sectionList) {
            allItems.addAll(s.getSectionItems());
        }
        return allItems.contains(item);
    }

    //Removes an item, given its section number. O(S) S = number of sections
    public static void removeItem(String item, int position) {
        switch (position) {
            case 0:
                //produce
                ProduceList.removeItem(item);
                FridgeList fl = new FridgeList();
            case 1:
                //meat
                MeatList.removeItem(item);
                FridgeList f2 = new FridgeList();
            case 2:
                //seafood
                SeafoodList.removeItem(item);
                FridgeList f3 = new FridgeList();
            case 3:
                //freezer
                FreezerList.removeItem(item);
                FridgeList f4 = new FridgeList();
        }
    }

    //Removes an item, given its item name. O(S*L) S= number of sections, L = avg. number of items per list
    public static void removeItem(String item) {
        int pos = 0;
        for (Section s: sectionList) {
            if(s.getSectionItems().contains(item)) {
                switch (pos) {
                    case 0:
                        //produce
                        ProduceList.removeItem(item);
                        System.out.println(item + " removed from ProduceList");
                    case 1:
                        //meat
                        MeatList.removeItem(item);
                        System.out.println(item + " removed from MeatList");
                    case 2:
                        //seafood
                        SeafoodList.removeItem(item);
                        System.out.println(item + " removed from SeafoodList");
                    case 3:
                        //freezer
                        FreezerList.removeItem(item);
                        System.out.println(item + " removed from FreezerList");
                }
            } else {
                pos++;
            }
        }
    }

    public static void changeItemQty(String item, int qty) {
        int pos = 0;
        for (Section s: sectionList) {
            if(s.getSectionItems().contains(item)) {
                switch (pos) {
                    case 0:
                        //produce
                        ProduceList.itemsAndQty.replace(item,qty);
                        System.out.println(item + " changed from ProduceList");
                    case 1:
                        //meat
                        MeatList.itemsAndQty.replace(item,qty);
                        System.out.println(item + " changed from MeatList");
                    case 2:
                        //seafood
                        SeafoodList.itemsAndQty.replace(item,qty);
                        System.out.println(item + " changed from SeafoodList");
                    case 3:
                        //freezer
                        FreezerList.itemsAndQty.replace(item,qty);
                        System.out.println(item + " changed from FreezerList");
                }
            } else {
                pos++;
            }
        }
    }

    //Returns the quantity of an item, given its item name and its section number
    public static int getQuantity(String item, int position) {
        switch (position) {
            case 0:
                //produce
                return ProduceList.itemsAndQty.get(item);
            case 1:
                //meat
                return MeatList.itemsAndQty.get(item);
            case 2:
                //seafood
                return SeafoodList.itemsAndQty.get(item);
            case 3:
                //freezer
                return FreezerList.itemsAndQty.get(item);
            default:
                //For debugging
                return 0;
        }
    }

    public static int getQuantity(String item) {
        int position = 0;
        for (Section s : sectionList) {
            if(s.getSectionItems().contains(item)) {
                switch (position) {
                    case 0:
                        //produce
                        return ProduceList.itemsAndQty.get(item);
                    case 1:
                        //meat
                        return MeatList.itemsAndQty.get(item);
                    case 2:
                        //seafood
                        return SeafoodList.itemsAndQty.get(item);
                    case 3:
                        //freezer
                        return FreezerList.itemsAndQty.get(item);
                    default:
                        //For debugging
                        return 0;
                }
            } else {
                position++;
            }
        }
        return 999;
    }
    //Adds an item to a specified category, then re-initializes the FridgeList data structure
    public static void add(String category, String item, int num, LocalDate date) {
        switch (category) {
            case "Produce":
                ProduceList.addItem(item, num, date);
                break;
            case "Meat":
                MeatList.addItem(item, num, date);
                break;
            case "Seafood":
                SeafoodList.addItem(item, num, date);
                break;
            default:
                FreezerList.addItem(item, num, date);
                break;
        }
    }
}
