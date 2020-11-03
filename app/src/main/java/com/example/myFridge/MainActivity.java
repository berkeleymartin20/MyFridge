package com.example.myFridge;

import android.os.Bundle;

import com.example.myFridge.ui.fridge.FreezerList;
import com.example.myFridge.ui.fridge.FridgeList;
import com.example.myFridge.ui.fridge.FridgeListAdapter;
import com.example.myFridge.ui.fridge.MeatList;
import com.example.myFridge.ui.fridge.ProduceList;
import com.example.myFridge.ui.fridge.SeafoodList;
import com.example.myFridge.ui.fridge.Section;
import com.example.myFridge.ui.shoppinglist.ShoppingList;
import com.example.myFridge.ui.shoppinglist.ShoppingListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


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