package com.example.ajax_rumus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbConfig extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ajax.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;


    private static final String TABLE_CREATE_USERS = "create table contacts(id integer primary key not null, " + "name text not null, email text not null, uname text not null,pass text not null)";
    private static final String TABLE_CREATE_RUMUS ="create table rumusbangundatar(id integer primary key autoincrement , bangundatar text ,hitung text, rumus text , catatan text )";
    private static final String TABLE_INSERT_RUMUS ="INSERT INTO rumusbangundatar(bangundatar,hitung , rumus, catatan) VALUES ('Lingkaran','Luas', 'L = π x r2', 'K = keliling lingkaran  r = jari-jariπ= phi (22/7 atau 3,14)')";
    public DbConfig(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE_RUMUS);
        db.execSQL(TABLE_CREATE_USERS);
        db.execSQL(TABLE_INSERT_RUMUS);
        this.db = db;





    }



    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        String query = "select * from contacts ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "select uname, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}
