package com.example.imseokbin.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView leftImage;
    ImageView rightImage;
    Button button;
    EditText editText;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftImage = findViewById(R.id.leftImage);
        rightImage = findViewById(R.id.rightImage);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.changeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread dog1 = new DogThread(0); //create RyanThread object
                dog1.start(); // ryan1 thread execute
                DogThread dog2 = new DogThread(1); //create RyanThread object
                dog2.start(); // ryan2 thread execute
            }
        });
    }

    class DogThread extends Thread {
        int index;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index) {
            this.index = index;
            images.add(R.drawable.dog_eating); // input drawable object in ArrayList named images
            images.add(R.drawable.dog_standing); // input drawable object in ArrayList named images
            images.add(R.drawable.dog_study); // input drawable object in ArrayList named images
        }

        /*
         * this function execute when RyanThread execute.
         */
        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "Ryan #" + index + " state: " + stateIndex;

                handler.post(new Runnable() { //request the execution of runnable objects
                    @Override
                    public void run() {
                        editText.append(msg + "\n");
                        if (index == 0) { // the case of leftImage
                            leftImage.setImageResource(images.get(stateIndex)); // change image in leftImage
                        } else if (index == 1) { // the case of rightImage
                            rightImage.setImageResource(images.get(stateIndex)); // change image in rightImage
                        }
                    }
                });
                try {
                    int sleepTime = getRandomTime(500, 3000); // get time from 500 to 3000
                    Thread.sleep(sleepTime); // pause thread during sleeptime
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                if (stateIndex >= images.size()) { //if stateIndex exceed 3
                    stateIndex = 0; //initialize stateIndex
                }
            }
        }

        public int getRandomTime(int min, int max) {
            return min + (int) (Math.random() * (max - min));
        }
    }
}