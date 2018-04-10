package com.example.imseokbin.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * main activity gets url address and send the data
 * to next activity
 */
public class MainActivity extends AppCompatActivity {
    Button button0; // button for next activity
    EditText Url;   // data to store url address

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button0 = (Button) findViewById(R.id.btn);
         Url = (EditText) findViewById(R.id.editText);

        /**
         * button handler for Next button if user clicks the next button
         * it changes to next activity
         */
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("Url",Url.getText().toString());
                startActivity(intent);
            }


        });
    }
}
