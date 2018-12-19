package com.mano.materialdesign;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student_database.db";
    public static final String TABLE_NAME = "student_data";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "ROLL_NO";
    public static final String col_4 = "FATHER_NAME";
    public static final String col_5 = "MARK";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID  INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ROLL_NO INTEGER, FATHER_NAME TEXT, MARK INTEGER )");
        Log.i("Notification", TABLE_NAME + "Table Created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String roll_no, String father_name, String mark) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);
        contentValues.put(col_3, roll_no);
        contentValues.put(col_4, father_name);
        contentValues.put(col_5, mark);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
