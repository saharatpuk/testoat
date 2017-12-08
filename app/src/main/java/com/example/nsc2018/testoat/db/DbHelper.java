package com.example.nsc2018.testoat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NSC2018 on 12/8/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "data";
    public static final String COL_ID = "_id";
    public static final String COL_USER = "username";
    public static final String COL_PASS = "password";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_USER + " TEXT, "
            + COL_PASS + " TEXT)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_USER, "saharat");
        cv.put(COL_PASS, "12345");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_USER, "admin2");
        cv.put(COL_PASS, "12345");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_USER, "admin");
        cv.put(COL_PASS, "1234");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_USER, "suarezoat");
        cv.put(COL_PASS, "1234");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean check(String user,String pass){

        String[] column = {COL_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        insertInitialData(db);
        String selection = COL_USER  + " = ?" + " AND " + COL_PASS + " = ?";
        String[] selectionArgs = {user,pass};

        Cursor cursor = db.query(TABLE_NAME,
                column,
                selection,
                selectionArgs,
                null,
                null,
                null
        );



        int cur = cursor.getCount();
        cursor.close();
        db.close();
        if(cur>0){
            return  true;
        }

        return false;

    }

}
