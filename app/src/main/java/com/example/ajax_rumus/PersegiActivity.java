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

public class PersegiActivity extends AppCompatActivity {
    protected Cursor cursor;
    DbConfig dbHelper;
    private EditText edit_inputsisi;
    private TextView txt_luaspersegi , txt_kelilingpersegi , txt_edit_inputsisi;
    private Button btnkeliling_persegi , btnluas_persegi ,resetpersegi ,btnhistorypersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        getSupportActionBar().setTitle("PERSEGI");

        dbHelper = new DbConfig(this);
        edit_inputsisi = (EditText) findViewById(R.id.inputsisipersegi);
        txt_edit_inputsisi = (TextView) findViewById(R.id.inputsisipersegi);
        txt_kelilingpersegi = (TextView) findViewById(R.id.teks_keliling_persegi);
        txt_luaspersegi = (TextView)findViewById(R.id.teks_luas_persegi);
        btnkeliling_persegi = (Button) findViewById(R.id.btnKelilingpersegi);
        resetpersegi = (Button) findViewById(R.id.btnresetpersegi);
        btnluas_persegi = (Button) findViewById(R.id.btnLuaspersegi);


        btnkeliling_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Outputsisipersegi = edit_inputsisi.getText().toString().trim();

                if(Outputsisipersegi.equals("")){
                    txt_edit_inputsisi.setText("");
                    Toast.makeText(getApplicationContext(),"Input sisi tidak boleh kosong" , Toast.LENGTH_LONG).show();
                }else{
                    int hasiloutputsisipersegi = Integer.parseInt(Outputsisipersegi);
                    int kelilingpersegi = (hasiloutputsisipersegi * 4);



                    txt_kelilingpersegi.setText("Keliling :"+kelilingpersegi+" cm");

                }
            }
        });

        btnluas_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Outputsisipersegi = edit_inputsisi.getText().toString().trim();

                if(Outputsisipersegi.equals("")){
                    txt_edit_inputsisi.setText("");
                    Toast.makeText(getApplicationContext(),"Input sisi tidak boleh kosong" , Toast.LENGTH_LONG).show();
                }else{
                    int hasiloutputsisipersegi = Integer.parseInt(Outputsisipersegi);
                    int luaspersegi = (hasiloutputsisipersegi * hasiloutputsisipersegi);

                    txt_luaspersegi.setText("Luas :"+luaspersegi +" cm");


                }
            }
        });

        resetpersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_luaspersegi.setText("Luas :");
                txt_kelilingpersegi.setText("Keliling :");
                txt_edit_inputsisi.setText("");
                Toast.makeText(getApplicationContext(),"reset berhasil" , Toast.LENGTH_LONG).show();
            }
        });



    }
}
