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

public class buatrumusActivity extends AppCompatActivity {

    protected Cursor cursor;
    DbConfig dbHelper;
    Button btn_simpan, btn_keluar;
    EditText textrumus, textnote, textnamabangundatar , texthitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buatrumus);

        dbHelper = new DbConfig(this);
        textrumus = (EditText) findViewById(R.id.et_rumus);
        textnamabangundatar = (EditText) findViewById(R.id.et_bangundatar);
        textnote = (EditText) findViewById(R.id.et_catatan);
        texthitung = (EditText) findViewById(R.id.et_hitung);
        btn_simpan = (Button) findViewById(R.id.buttonsimpanrumus);
        btn_keluar = (Button) findViewById(R.id.buttonkembalirumus);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into rumusbangundatar( bangundatar,hitung, rumus, catatan) values('" +
                        textnamabangundatar.getText().toString() + "','" +
                        texthitung.getText().toString() + "','" +
                        textrumus.getText().toString() + "','" +
                        textnote.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                daftarrumusActivity.dr.RefreshList();
                finish();
            }
        });

        btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buatrumusActivity.this, daftarrumusActivity.class);
                startActivity(intent);
            }
        });


    }
}
