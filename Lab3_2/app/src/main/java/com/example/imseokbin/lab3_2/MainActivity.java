package com.example.imseokbin.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.imseokbin.lab3_2.R;

public class MainActivity extends AppCompatActivity {

    EditText editText; // variable to store person's name
    RadioGroup radioGroup; // variable for radio group
    RadioButton man; // gender button for man
    RadioButton woman; // gender button for woman
    CheckBox smsButton; // sms
    CheckBox emailButton; // email
    Button registerButton; // register

    /*
    onCreate function gets users name information
    and gender information and sms or email information
    and register to next activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.nameEditText);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        man=(RadioButton)findViewById(R.id.man);
        woman=(RadioButton)findViewById(R.id.woman);
        smsButton=(CheckBox)findViewById(R.id.SMS);
        emailButton=(CheckBox)findViewById(R.id.email);
        registerButton=(Button)findViewById(R.id.btnRegister);
        /*
        on click listener for register button
         */
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                String gender="";
                String check="";
                int radioId=radioGroup.getCheckedRadioButtonId();

                if(smsButton.isChecked()) {
                    check = smsButton.getText().toString();
                    smsButton.setChecked(false);
                }

                if(emailButton.isChecked()) {
                    check = emailButton.getText().toString();
                    emailButton.setChecked(false);
                }

                if(man.getId()==radioId) { //
                    gender = man.getText().toString();
                    man.setChecked(false);
                }
                if(woman.getId()==radioId) {
                    gender = woman.getText().toString();
                    woman.setChecked(false);
                }
                Intent intent=new Intent(MainActivity.this,newActivity.class);
                Bundle info=new Bundle();
                info.putString("name",name);
                info.putString("gender",gender);
                info.putString("check",check);

                editText.setText("");

                intent.putExtras(info); // intent to go foward to next activity
                startActivity(intent); // start intent
            }
        });

    }
}