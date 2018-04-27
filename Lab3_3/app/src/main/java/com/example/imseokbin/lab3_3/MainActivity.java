package com.example.imseokbin.lab3_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tab1;
    Button tab2;

    Fragment1 fragment1;
    Fragment2 fragment2;
    /*
    onCreate method gets button ids from main Activity and inflates
    appropriate fragments
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
    }
    public void init(){
        tab1=findViewById(R.id.tab1);
        tab2=findViewById(R.id.tab2);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
    }

    public void setListener(){
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); // visible fragment1
            }
        });

        tab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit(); // visible fragment2
            }
        });
    }
}