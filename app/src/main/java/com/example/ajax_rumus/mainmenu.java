package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainmenu extends AppCompatActivity {

    Button btnpersegi , btnlingkaran , btnsegitiga , btncatatrumus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btnpersegi = (Button) findViewById(R.id.btn_persegi);
        btnlingkaran = (Button) findViewById(R.id.btn_lingkaran);
        btnsegitiga = (Button) findViewById(R.id.btn_segitiga);
        btncatatrumus = (Button) findViewById(R.id.btn_catatrumus);

        btnpersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(mainmenu.this, PersegiActivity.class);
                startActivity(a);
            }
        });

        btnlingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(mainmenu.this, LingkarangActivity.class);
                startActivity(b);

            }
        });

        btnsegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, SegitigaActivity.class);
                startActivity(intent);
            }
        });

        btncatatrumus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, daftarrumusActivity.class);
                startActivity(intent);
            }
        });

    }
}
