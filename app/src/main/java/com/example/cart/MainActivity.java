package com.example.cart;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cart.Helper.helper;


public class MainActivity extends helper implements View.OnClickListener {
    TextView decrement;
    TextView increment;
    TextView counter;
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
         }

    @Override
    public void initListener() {
      decrement.setOnClickListener(this);
      increment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.increment){
            doIncrement();
        }
        if (v.getId()==R.id.decrement){
            doDecrement();
        }

    }

    private void doDecrement() {
        String countString;
        countString = counter.getText().toString();
        count = Integer.parseInt(countString);
        if (count>0){
        count--;
        counter.setText(String.valueOf(count));
        }
    }

    private void doIncrement() {
        TextView counter = findViewById(R.id.counterValue);
        String countString;
        countString = counter.getText().toString();
        count = Integer.parseInt(countString);
        count++;
        counter.setText(String.valueOf(count));
    }
}