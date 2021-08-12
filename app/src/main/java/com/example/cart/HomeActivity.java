package com.example.cart;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.cart.Fragments.AudioFragment;
import com.example.cart.Fragments.CameraFragment;
import com.example.cart.Fragments.HomeFragment;
import com.example.cart.Fragments.VideoFragment;
import com.example.cart.Helper.helper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends helper implements View.OnClickListener {
    BottomNavigationView bottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpFragment(new HomeFragment(),"Home");
        initView();
        initListener();


    }

    @Override
    public void initView() {
        bottomNavBar = findViewById(R.id.bottomNavigationView);

    }

    @Override
    public void initListener() {
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.action_home){
                    setUpFragment(new HomeFragment(),"Home");
                }
                if (item.getItemId()==R.id.camera){
                    setUpFragment(new CameraFragment(),"Camera");
                }
                if (item.getItemId()==R.id.audio){
                    setUpFragment(new AudioFragment(),"Audio");
                }
                if (item.getItemId()==R.id.action_videos){
                    setUpFragment(new VideoFragment(),"Video");
                }
                return true;
            }
        });

        }

    @Override
    public void onClick(View v) {

    }
    /**
     * @param fragment fragment to load
     */
    private void setUpFragment(Fragment fragment, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.container_fragment, fragment, tag);
        fragmentTransaction.commit();


    }
}