package com.example.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.MenuItem;
import android.view.View;

import com.example.cart.Fragments.HomeFragment;
import com.example.cart.Helper.helper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends helper implements View.OnClickListener {
    BottomNavigationView bottomNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initListener();
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment home = null;
                if (item.getItemId()==R.id.action_home){
                    home = new HomeFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,home).commit();
                return true;
            }
        });

    }

    @Override
    public void initView() {
        bottomNavBar = findViewById(R.id.bottomNavigationView);

    }

    @Override
    public void initListener() {

        }

    @Override
    public void onClick(View v) {

    }
}