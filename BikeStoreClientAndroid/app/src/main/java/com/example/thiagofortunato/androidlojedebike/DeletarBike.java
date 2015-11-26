package com.example.thiagofortunato.androidlojedebike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class DeletarBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_bike);

        final Button btnDel = (Button) (findViewById(R.id.btnDelete));
        final Spinner spnDelete  = (Spinner) (findViewById(R.id.spnDelete));

        final LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid(); //minha loja

        lojaDeBike.getBikes(); //lista com todas as bikes

        List<String> numSeries = lojaDeBike.getAllNumSerie();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, numSeries);
        spnDelete.setAdapter(adapter);


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numSerie = String.valueOf(spnDelete.getSelectedItem());
                deleteBike(numSerie);
            }
        });

        /*
        spnDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String numSerie = String.valueOf(spnDelete.getSelectedItem());
                deleteBike(numSerie);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }

    public void deleteBike(String numSerie){
        Toast aviso;
        LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid();
        boolean delete = lojaDeBike.deleteBike(numSerie);
        if (delete) {
            aviso = Toast.makeText(this, "Bike deletada com Sucesso", Toast.LENGTH_LONG);
            aviso.show();
        } else {
            aviso = Toast.makeText(this, "Desculpe, falha ao Deletar ", Toast.LENGTH_LONG);
            aviso.show();
        }
    }
}
