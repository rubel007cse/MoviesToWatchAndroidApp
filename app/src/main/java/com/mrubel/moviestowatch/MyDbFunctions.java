package com.mrubel.moviestowatch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mosharrofrubel on 11/7/16.
 */
public class MyDbFunctions extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MyMovies";
    private static final String TABLE_MAIN = "hellofmovies";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLT = "title";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_DATE = "date";





    // CONSTRUCTOR
    public MyDbFunctions(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        // query to create table
        String query1 = "CREATE TABLE " + TABLE_MAIN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_TITLT + " TEXT," +
                KEY_DETAILS + " TEXT," +
                KEY_DATE + " TEXT" + ")";

        db.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // to insert data

    public void addNewDATA (DataTemp td) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLT, td.get_title());
        values.put(KEY_DETAILS, td.get_detials());
        values.put(KEY_DATE, td.get_date());

        db.insert(TABLE_MAIN, null, values);
        db.close();

    }

    // to get data from database
    public String[] fetch_ALL_data() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from " + TABLE_MAIN + ";", null);
        res.moveToFirst();
        String[] p = new String[res.getCount()];

        if (res != null && res.moveToFirst()) {
            int i = 0;
            do {

                p[i] = res.getString(res.getColumnIndex(KEY_TITLT))+" ["+res.getString(res.getColumnIndex(KEY_DATE))+"]\n"
                + res.getString(res.getColumnIndex(KEY_DETAILS));

                i = i + 1;
            } while (res.moveToNext());
        }
        return p;
    }

}
