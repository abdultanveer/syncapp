package com.abdul.syncapp.database;


import android.content.ContentValues;
import android.content.Context;
import com.abdul.syncapp.database.FeedReaderContract.FeedEntry;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccessObject {
    DbHelper dbHelper;
    SQLiteDatabase database;
    public DatabaseAccessObject(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }

    public void createRow(String title, String subTitle){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subTitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    public String readRow(){
       Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,
               null,null,null,null);
       cursor.moveToLast();

       int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subTitle = cursor.getString(subtitleIndex);


        return title +"\n"+ subTitle;
    }
    public void updatingRow(){}
    public void deleteRow(){}

}
