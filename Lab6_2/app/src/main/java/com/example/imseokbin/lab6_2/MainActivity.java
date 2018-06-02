package com.example.imseokbin.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText idText;
    EditText nameText;
    Button saveBtn;
    Button getBtn;
    Button clearBtn;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = (EditText)findViewById(R.id.sn);
        nameText = (EditText)findViewById(R.id.name);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        getBtn = (Button)findViewById(R.id.resultBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sharedPreference();
            }
        });
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applySharedPreference();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
                idText.setText("");
            }
        });

    }
    public void sharedPreference(){
        sh_Pref = getSharedPreferences("Student_Information",MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("studentName", nameText.getText().toString());
        toEdit.putInt("studentId", Integer.parseInt(idText.getText().toString()));
        toEdit.commit();
    }

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Student_Information",MODE_PRIVATE);
        if(sh_Pref !=null && sh_Pref.contains("studentName")){
            String name = sh_Pref.getString("studentName","noname");
            nameText.setText(name);
        }
        if(sh_Pref != null && sh_Pref.contains("studentId")){
            int id = sh_Pref.getInt("studentId",1);
            idText.setText(String.valueOf(id));
        }

    }
}
