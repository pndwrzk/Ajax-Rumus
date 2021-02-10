package com.example.ajax_rumus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SegitigaActivity extends AppCompatActivity {

    private EditText editalas ,edittinggi , editsisi;
   private TextView txt_editalas , txt_edittinggi , txt_editsisi ,txt_kelilingsegita ,txt_luassegitiga;
  private Button btn_kelilingsegitiga , btn_luassegitiga , resetsegitiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        getSupportActionBar().setTitle("SEGITIGA SAMA SISI");

        editalas = (EditText) findViewById(R.id.inputalassegitiga);
        edittinggi = (EditText) findViewById(R.id.inputtinggisegitiga);
        editsisi = (EditText) findViewById(R.id.inputsisisegitiga);
        txt_edittinggi = (TextView) findViewById(R.id.inputtinggisegitiga);
        txt_editalas = (TextView) findViewById(R.id.inputalassegitiga);
        txt_editsisi = (TextView) findViewById(R.id.inputsisisegitiga);
        resetsegitiga = (Button) findViewById(R.id.btnresetsegitiga);
        txt_kelilingsegita = (TextView)findViewById(R.id.teks_Kelilingsegitiga);
        txt_luassegitiga = (TextView)findViewById(R.id.teks_Luassegitiga);
        btn_kelilingsegitiga = (Button) findViewById(R.id.btnKelilingsegitiga);
        btn_luassegitiga = (Button) findViewById(R.id.btnluassegitiga);

        btn_kelilingsegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputsisisegitiga = editsisi.getText().toString().trim();

                if(outputsisisegitiga.equals("")){
                    txt_editsisi.setText("");
                    Toast.makeText(getApplicationContext(),"input sisi tidak boleh kosong untuk menghitung keliling" , Toast.LENGTH_LONG).show();
                }else {


                    int sisisegitiga = Integer.parseInt(outputsisisegitiga);
                    int kelilingsegitiga = (sisisegitiga * 3);

                    txt_kelilingsegita.setText("Keliling :" + kelilingsegitiga +" cm");
                }
            }
        });

        btn_luassegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputsisisegitiga = editsisi.getText().toString().trim();
                String outputalassegitiga = editalas.getText().toString().trim();
                String outputtinggisegitiga = edittinggi.getText().toString().trim();


                 if(outputalassegitiga.equals("")){
                    txt_editalas.setText("");
                    Toast.makeText(getApplicationContext(),"input alas tidak boleh kosong untuk menghitung luas" , Toast.LENGTH_LONG).show();
                }else if(outputtinggisegitiga.equals("")){
                    txt_edittinggi.setText("");
                    Toast.makeText(getApplicationContext(),"input tinggi tidak boleh kosong untuk menghitung luas" , Toast.LENGTH_LONG).show();
                } else {



                    int tinggisegitiga = Integer.parseInt(outputtinggisegitiga);
                    int alassegitiga = Integer.parseInt(outputalassegitiga);
                    Double luassegitiga = (0.5 * tinggisegitiga * alassegitiga);

                    txt_luassegitiga.setText("Luas :" + luassegitiga +" cm");
                }
            }
        });

        resetsegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_luassegitiga.setText("Luas :");
                txt_kelilingsegita.setText("Keliling :");
                txt_edittinggi.setText("");
                txt_editsisi.setText("");
                txt_editalas.setText("");
                Toast.makeText(getApplicationContext(),"Reset Berhasil" , Toast.LENGTH_LONG).show();
            }
        });

    }
}
