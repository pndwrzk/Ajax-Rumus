package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detailbangundatarActivity extends AppCompatActivity {
    protected Cursor cursor;
    DbConfig dbHelper;
    Button ton2;
    TextView text1, text2, text3 ,text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbangundatar);
        getSupportActionBar().setTitle("DETAIL RUMUS");

        dbHelper = new DbConfig(this);
        text1 = (TextView) findViewById(R.id.tv_detailbangundatar);
        text2 = (TextView) findViewById(R.id.tv_detailrumus);
        text3 = (TextView) findViewById(R.id.tv_detailcatatan);
        text4 = (TextView) findViewById(R.id.tv_detailMenghitung);
        ton2 = (Button) findViewById(R.id.buttonkembali1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM rumusbangundatar WHERE bangundatar = '"+
                getIntent().getStringExtra("bangundatar") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()> 0 ) {
            cursor.moveToPosition( 0);
            text1.setText(cursor.getString(1).toString());
            text4.setText(cursor.getString(2).toString());
            text2.setText(cursor.getString(3).toString());
            text3.setText(cursor.getString(4).toString());

        }

        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(detailbangundatarActivity.this, daftarrumusActivity.class);
                startActivity(a);
            }
        });

    }
}
