package com.example.imseokbin.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout first_layout = (LinearLayout)findViewById(R.id.first_layout); // First Linear layout
        final LinearLayout second_layout=(LinearLayout)findViewById(R.id.second_layout); // Second Linear layout

        Button button =(Button)findViewById(R.id.button); // button handler for first layout's button
        Button close_btn =(Button)findViewById(R.id.close_button); // button handler for second layout's button

        button.setOnClickListener(new View.OnClickListener(){ // first layout button listener
            @Override
            public void onClick(View v){
                Animation anim = AnimationUtils.loadAnimation( // animation object to start animation
                        getApplicationContext(),R.anim.left_slide);
                second_layout.setVisibility(View.VISIBLE);
                second_layout.startAnimation(anim);

            }
        });

        close_btn.setOnClickListener(new View.OnClickListener(){ // second layout button listener
            @Override
            public void onClick(View v){
                Animation anim = AnimationUtils.loadAnimation( // animation object to start animation
                        getApplicationContext(),R.anim.right_slide);
                second_layout.startAnimation(anim);
                second_layout.setVisibility(View.GONE);
                first_layout.setVisibility(View.VISIBLE);

            }
        });
    }
}
