package com.example.imseokbin.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

/**
 * NewActivity gets the url from main Activity
 * and set text to url address
 * if user clicks go button it pop up internet
 * if user clicks back button it changes to main Activity
 */
public class NewActivity extends AppCompatActivity {
    TextView textView; // variable for textview
    Button goBtn;      // variable for go button
    Button backBtn;    // variable for back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView =(TextView) findViewById(R.id.txt);
        goBtn =(Button)findViewById(R.id.btn1);
        backBtn =(Button)findViewById(R.id.btn2);

        final Intent passedIntent = getIntent();
        final String passedUrl =passedIntent.getStringExtra("Url");
        textView.setText(passedUrl.toString());
        /**
         * button handler for go button
         */
        goBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                 if(textView.getText().toString().length() == 0)
                    Toast.makeText(getApplicationContext(),"주소를 다시 입력하세요",Toast.LENGTH_LONG).show();
                else if (textView.getText().toString() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + textView.getText().toString()));
                    startActivity(intent);
                }

            }
        });
        /**
         * button handler for back button
         *
         */
        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"뒤로가기를 눌렀습니다",Toast.LENGTH_LONG).show();
                finish();
            }

        });

    }
}
