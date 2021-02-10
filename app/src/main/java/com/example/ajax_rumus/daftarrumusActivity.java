package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class daftarrumusActivity extends AppCompatActivity {

    String[] daftar;
    ListView listView01;
    Menu menu;
    protected Cursor cursor;
    DbConfig dbcenter;
    public static daftarrumusActivity dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarrumus);
        getSupportActionBar().setTitle("DAFTAR RUMUS");
        Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent(daftarrumusActivity.this, buatrumusActivity.class);
                startActivity(inte);
            }
        });
        dr = this;
        dbcenter = new DbConfig(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM rumusbangundatar", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        listView01 = (ListView) findViewById(R.id.listView1);
        listView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];

                final CharSequence[] dialogitem = {"Lihat Rumus", "Update Rumus", "Hapus Rumus"};
                AlertDialog.Builder builder = new AlertDialog.Builder(daftarrumusActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), detailbangundatarActivity.class);
                                i.putExtra("bangundatar", selection);
                                startActivity(i);
                                break;

                            case 1:
                                Intent in = new Intent(getApplicationContext(), updaterumusActivity.class);
                                in.putExtra("bangundatar", selection);
                                startActivity(in);
                                break;

                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from rumusbangundatar where bangundatar ='" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView01.getAdapter()).notifyDataSetInvalidated();
    }
}
