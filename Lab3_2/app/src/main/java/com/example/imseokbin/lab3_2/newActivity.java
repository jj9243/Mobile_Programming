package com.example.imseokbin.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.imseokbin.lab3_2.R;

public class newActivity extends AppCompatActivity {

    TextView name; // name information
    TextView gender; // gender information
    TextView check; // email or sms information
    Button backButton; // move to previous activity
    /*
    onCreate function gets user input information
    and show the information on the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        name=(TextView)findViewById(R.id.nameText);
        gender=(TextView)findViewById(R.id.genderText);
        check=(TextView)findViewById(R.id.checkText);
        backButton=(Button)findViewById(R.id.btnBack);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();


        name.setText(bundle.getString("name")); // information for name
        gender.setText(bundle.getString("gender"));  // information for gender
        check.setText(bundle.getString("check")); // information for sms or email

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish(); // move to previous activity
            }
        });
    }
}