package com.example.imseokbin.lab6_3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imseokbin on 2018. 6. 2..
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Student (name TEXT, id int PRIMARY KEY);");


    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Student";
        db.execSQL(sql);
        //db.execSQL("CREATE TABLE ITEM (_id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT, year INT, month INT, day INT);");
        onCreate(db);
    }
    public void insert(String name, int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Student VALUES ('" + name +"' , "+ id +");");
        db.close();
    }

    public void delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Student WHERE name='"+name + "';");
        db.close();
    }

    public String[] select(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("student",null,null,null,null,null,null);
        String[] s = new String[c.getCount()];
        int count = 0;
        while(c.moveToNext()){
            s[count] = c.getString(c.getColumnIndex("name"))
                    + " " + c.getString(c.getColumnIndex("id"));
            count++;
        }

        c.close();
        return s;

    }
}