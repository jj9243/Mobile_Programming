package com.example.imseokbin.lab5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button calButton;
    TextView processText;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        calButton = findViewById(R.id.button);
        processText = findViewById(R.id.processTextView);
        resultText = findViewById(R.id.resultTextView);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processText.setText("");
                resultText.setText("");
                int temp = Integer.parseInt(editText.getText().toString()); // get integer value from editText
                new Facto(temp).execute(); // execute Facto object
            }
        });
    }

    private class Facto extends AsyncTask<Void, Integer, Void> {
        int num = 0;
        int result = 1;

        Facto(int temp) {
            num = temp;
        } // constructor for receive integer value

        @Override
        protected Void doInBackground(Void... params) { // it runs continuously in the background
            for (int i = num; i > 0; i--) {
                try {
                    Thread.sleep(500); // get time from 500
                    publishProgress(i); //Invokes onProgressUpdate();
                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            result *= values[0].intValue(); //
            if (values[0].intValue() == num)
                processText.setText(String.valueOf(values[0].intValue()));
            else
                processText.append("   " + String.valueOf(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void aVoid) { // when the thread is finished
            resultText.setText("= " + String.valueOf(result));
        }

    }
}
