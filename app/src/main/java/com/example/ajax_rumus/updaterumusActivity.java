package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updaterumusActivity extends AppCompatActivity {

    protected Cursor cursor;
    DbConfig dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updaterumus);
        getSupportActionBar().setTitle("UPDATE RUMUS");
        dbHelper = new DbConfig(this);
        text1 = (EditText) findViewById(R.id.et_updatebangundatar);
        text2 = (EditText) findViewById(R.id.et_updaterumus);
        text3 = (EditText) findViewById(R.id.et_updatecatatan);
        text4 = (EditText) findViewById(R.id.et_updatehitung);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM rumusbangundatar WHERE bangundatar ='"+
                getIntent().getStringExtra("bangundatar") +"'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text4.setText(cursor.getString(2).toString());
            text2.setText(cursor.getString(3).toString());
            text3.setText(cursor.getString(4).toString());
        }
        ton1 = (Button) findViewById(R.id.buttoupdaterumus);
        ton2 = (Button) findViewById(R.id.buttonkembalirumus1);



        //Daftarkan Event OnCLick pada btnSimpan

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update rumusbangundatar set bangundatar='"+
                        text1.getText().toString() +"', hitung='" +
                        text4.getText().toString()+"', rumus='"+
                        text2.getText().toString() +"', catatan='" +
                        text3.getText().toString() + "' where bangundatar='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil,", Toast.LENGTH_LONG).show();
                daftarrumusActivity.dr.RefreshList();
                finish();
            }
        });

        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(updaterumusActivity.this, daftarrumusActivity.class);
                startActivity(intent);
            }
        });

    }
}
