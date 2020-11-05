package com.example.myFridge;

import android.os.Bundle;

import com.example.myFridge.ui.fridge.FridgeFragment;
import com.example.myFridge.ui.fridge.FridgeListAdapter;
import com.example.myFridge.ui.fridge.FridgeSectionAdapter;
import com.example.myFridge.ui.fridge.fridgeCategories.FreezerList;
import com.example.myFridge.ui.fridge.FridgeList;
import com.example.myFridge.ui.fridge.fridgeCategories.MeatList;
import com.example.myFridge.ui.fridge.fridgeCategories.ProduceList;
import com.example.myFridge.ui.fridge.fridgeCategories.SeafoodList;
import com.example.myFridge.ui.shoppinglist.ShoppingList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView fridgeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_fridge, R.id.navigation_alert, R.id.navigation_shoppinglist)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        try {
            ShoppingList sl = new ShoppingList();
            FreezerList f1 = new FreezerList();
            MeatList m1 = new MeatList();
            SeafoodList sea1 = new SeafoodList();
            ProduceList p1 = new ProduceList();
            FridgeList fl1 = new FridgeList();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}