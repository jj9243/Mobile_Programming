package com.example.imseokbin.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button readBtn;
    Button writeBtn;
    Button clearBtn;
    Button finishBtn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn = (Button)findViewById(R.id.readBtn);
        writeBtn = (Button)findViewById(R.id.writeBtn);
        clearBtn =(Button)findViewById(R.id.clearBtn);
        finishBtn = (Button)findViewById(R.id.finishBtn);
        editText = (EditText)findViewById(R.id.txtData);

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");

                directory.mkdirs();
                File file = new File(directory,"textfile.txt");
                try{
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    if(fIn != null){
                        BufferedReader reader = new BufferedReader(isr);
                        String str = "";
                        StringBuffer buf = new StringBuffer();

                        while((str = reader.readLine()) != null){
                            buf.append(str + "\n");
                        }
                        fIn.close();
                        editText.setText(buf.toString());
                    }
                }catch(java.io.FileNotFoundException e){

                }catch(Throwable t){
                    Toast.makeText(getApplicationContext(),"Exception: "+t.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        writeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");

                directory.mkdirs();
                File file = new File(directory,"textfile.txt");
                try{
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    osw.write(editText.getText().toString());
                    osw.close();
                }catch(Throwable t){
                    Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
