package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LingkarangActivity extends AppCompatActivity {
    protected Cursor cursor;
    DbConfig dbHelper;
    private EditText editjarijari;
    private TextView txt_jarijari , txtluas_lingkaran , txtkeliling_lingkaran;
    private Button btnkeliling_lingkaran , btnluas_lingkaran ,resetlingkaran,btnsimpanlingkaran ,btnhistorylingkaran;
    private Double phi = 3.14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkarang);
        getSupportActionBar().setTitle("LINGKARAN");

        dbHelper = new DbConfig(this);
        editjarijari = (EditText) findViewById(R.id.inputjarijari);
        txt_jarijari= (TextView) findViewById(R.id.inputjarijari);
        txtkeliling_lingkaran = (TextView) findViewById(R.id.teks_keliling_lingkaran);
        txtluas_lingkaran = (TextView) findViewById(R.id.teks_luas_lingkaran);
        btnkeliling_lingkaran = (Button) findViewById(R.id.btnKelilinglingkaran);
        btnluas_lingkaran = (Button) findViewById(R.id.btnluaslingkaran);
        resetlingkaran = (Button) findViewById(R.id.btnresetlingkaran);
        btnkeliling_lingkaran = (Button) findViewById(R.id.btnKelilinglingkaran);



        btnkeliling_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputjarijari = editjarijari.getText().toString().trim();
                if(outputjarijari.equals("")){
                    txt_jarijari.setText("");
                    Toast.makeText(getApplicationContext(),"Input jari-jari tidak boleh kosong" , Toast.LENGTH_LONG).show();
                }else{
                    int r = Integer.parseInt(outputjarijari);

                    double kelilinglingkaran = (2 * phi * r);

                    txtkeliling_lingkaran.setText("Keliling :"+kelilinglingkaran+" cm");

                }



            }
        });
        btnluas_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputjarijari = editjarijari.getText().toString().trim();
                if(outputjarijari.equals("")){
                    txt_jarijari.setText("");
                    Toast.makeText(getApplicationContext(),"Input jari-jari tidak boleh kosong" , Toast.LENGTH_LONG).show();
                }else{
                    int r = Integer.parseInt(outputjarijari);
                    Double Luaslingkaran = (phi * r * r);
                    txtluas_lingkaran.setText("Luas :"+Luaslingkaran+" cm");

                }



            }
        });

        resetlingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtluas_lingkaran.setText("Luas :");
                txtkeliling_lingkaran.setText("Keliling :");
                txt_jarijari.setText("");
                Toast.makeText(getApplicationContext(),"Reset berhasil" , Toast.LENGTH_LONG).show();
            }
        });



    }
}
