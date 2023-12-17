package com.example.studentmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFrag(new RegFragment(), false);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_lay); // get the reference of TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    loadFrag(new RegFragment(), true);
                }
                else if(tab.getPosition() == 1) {
                    loadFrag(new RemFragment(), true);
                }
                else if(tab.getPosition() == 2) {
                    loadFrag(new SearchFragment(), true);
                }
                else if(tab.getPosition() == 3) {
                    loadFrag(new UpdFragment(), true);
                }
                else {
                    loadFrag(new AllFragment(), true);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
// called when tab unselected
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
// called when a tab is reselected
            }
        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.nav);
//        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                if(item == findViewById(R.id.reg)) {
//                    loadFrag(new RegFragment(), true);
//                }
//                else if(item == findViewById(R.id.rem)) {
//                    loadFrag(new RemFragment(), true);
//                }
//                else if(item == findViewById(R.id.search)) {
//                    loadFrag(new SearchFragment(), true);
//                }
//                else if(item == findViewById(R.id.upd)) {
//                    loadFrag(new UpdFragment(), true);
//                }
//                else {
//                    loadFrag(new AllFragment(), true);
//                }
//            }
//        });
    }



    public void loadFrag(Fragment frag, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag) {
            ft.replace(R.id.frag, frag);
        }
        else {
            ft.add(R.id.frag, frag);
        }
        ft.commit();
    }
}