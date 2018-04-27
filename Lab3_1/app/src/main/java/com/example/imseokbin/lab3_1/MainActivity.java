package com.example.imseokbin.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.longClickBtn);
        registerForContextMenu(mBtn);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0,1,1,"Red");
        menu.add(0,2,2,"Green");
        menu.add(0,3,3,"Blue");
    }
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                mBtn.setTextColor(Color.RED);
                return true;
            case 2:
                mBtn.setTextColor(Color.GREEN);
                return true;
            case 3:
                mBtn.setTextColor(Color.BLUE);
                return true;

        }
        return true;
    }


}
