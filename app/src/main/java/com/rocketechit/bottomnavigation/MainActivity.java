package com.rocketechit.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    AHBottomNavigation ahBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment=new FirstFragment();
        FragmentTransaction  fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.screen_area,fragment);
        fragmentTransaction.commit();

        //initialize
        ahBottomNavigation = findViewById(R.id.bottom_navigation);
//create  item
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("First", R.drawable.whatsapp_0);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Second", R.drawable.whatsapp_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("third", R.drawable.whatsapp_2);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Fourth", R.drawable.whatsapp_3);

// Add items
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

//set inactive icon color
        ahBottomNavigation.setInactiveColor(Color.BLACK);
        //set Active icon color
        ahBottomNavigation.setAccentColor(Color.GREEN);
//show the text below bottom icon
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


/*// Change colors
        ahBottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));*/

// Set background color
        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));

     /*   // Use colored navigation with circle reveal effect
        ahBottomNavigation.setColored(true);*/

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                Fragment fragment = null;
                if (position == 0) {

                    fragment = new FirstFragment();
                    ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                if (position == 1) {
                    fragment = new Second_Fragment();
                    ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#18606d"));
                }
                if (position == 2) {
                    fragment = new Third_fragment();
                }
                if (position == 3) {
                    fragment = new Fourth_Fragment();
                }
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                if (fragment!=null){
                    fragmentTransaction.replace(R.id.screen_area,fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
        /*
     ahBottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
         @Override public void onPositionChange(int y) {
             // Manage the new y position
             Toast.makeText(MainActivity.this, ""+y, Toast.LENGTH_SHORT).show();
         }
     });*/

    }
}
