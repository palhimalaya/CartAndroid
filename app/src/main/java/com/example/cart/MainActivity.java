package com.example.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cart.Fragments.HomeFragment;
import com.example.cart.Helper.helper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends helper implements View.OnClickListener {
    TextView decrement;
    TextView increment;
    TextView counter;
    Button nextActivity;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    @Override
    public void initView() {
         decrement = findViewById(R.id.decrement);
         increment = findViewById(R.id.increment);
         counter = findViewById(R.id.counterValue);
         nextActivity =findViewById(R.id.goNextActivity);
         }

    @Override
    public void initListener() {
      decrement.setOnClickListener(this);
      increment.setOnClickListener(this);
      nextActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.increment){
            doIncrement();
        }
        if (v.getId()==R.id.decrement){
            doDecrement();
        }
        if (v.getId()==R.id.goNextActivity){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);


            startActivity(intent);
        }

    }

    private void doDecrement() {
        if (count>0){
        count--;
        counter.setText(String.valueOf(count));
        }
    }

    private void doIncrement() {
        count++;
        counter.setText(String.valueOf(count));
    }
}