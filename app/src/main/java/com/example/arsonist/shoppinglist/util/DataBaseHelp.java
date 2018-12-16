package com.example.arsonist.shoppinglist.util;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Arsonist on 2018/12/16.
 */


public class DataBaseHelp extends SQLiteOpenHelper {
    public DataBaseHelp( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tab_shopping (id integer primary key autoincrement, product_id int(10), title varchar(50),price varchar(20), image varchar(10), num int(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
