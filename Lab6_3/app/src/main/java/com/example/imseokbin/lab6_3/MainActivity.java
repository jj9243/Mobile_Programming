package com.example.imseokbin.lab6_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button addBtn,deleteBtn;
    EditText nameText,idText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBHelper db = new DBHelper(getApplicationContext(),"Student.db",null,2);


        addBtn = (Button)findViewById(R.id.addBtn);
        deleteBtn =(Button)findViewById(R.id.deleteBtn);
        nameText = (EditText)findViewById(R.id.nameText);
        idText = (EditText)findViewById(R.id.idText);
        listView = (ListView)findViewById(R.id.listview);



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameText.getText().toString().equals("") || idText.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "이름과 학번을 모두 입력해 주세요", Toast.LENGTH_SHORT).show();
                else {
                    db.insert(nameText.getText().toString(), Integer.parseInt(idText.getText().toString()));
                    invalidate();
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameText.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
                else {
                    db.delete(nameText.getText().toString());
                    invalidate();
                }
            }
        });
    }
    public void invalidate(){
        final DBHelper db = new DBHelper(getApplicationContext(),"Student.db",null,2);
        String[] students = new String[50];
        students = db.select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,students);
        listView.setAdapter(adapter);
    }
}
