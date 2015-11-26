package com.example.thiagofortunato.androidlojedebike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class ConsultarBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_bike);

        final TextView txtPreco = (TextView) (findViewById(R.id.txtPreco));
        final TextView txtCor = (TextView) (findViewById(R.id.txtCor));
        final TextView txtNumSerie = (TextView) (findViewById(R.id.txtNumSerie));
        final TextView txtTamanho = (TextView) (findViewById(R.id.txtTamanho));
        final TextView txtMarca = (TextView) (findViewById(R.id.txtMarca));
        final TextView txtAno = (TextView) (findViewById(R.id.txtAno));
        final TextView txtRelacao = (TextView) (findViewById(R.id.txtRelacao));
        final TextView txtSuspensao = (TextView) (findViewById(R.id.txtSuspensao));
        final Spinner spnConsultar = (Spinner) findViewById(R.id.spnNumSerie);

        final LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid(); //minha loja

        lojaDeBike.getBikes(); //lista com todas as bikes

        List<String> numSeries = lojaDeBike.getAllNumSerie();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, numSeries);
        spnConsultar.setAdapter(adapter);


        spnConsultar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectItemView, int postion, long id) {

                String numSerieSelecionado = String.valueOf(spnConsultar.getSelectedItem());
                LinkedList<Bike> bikes = lojaDeBike.getNumSerie(numSerieSelecionado);

                txtPreco.setText(String.valueOf(bikes.get(0).getPreco()));
                txtCor.setText(String.valueOf(bikes.get(0).getCor()));
                txtNumSerie.setText(String.valueOf(bikes.get(0).getNumSerie()));
                txtTamanho.setText(String.valueOf(bikes.get(0).getSpec().getTamanho()));
                txtMarca.setText(String.valueOf(bikes.get(0).getSpec().getMarca()));
                txtAno.setText(String.valueOf(bikes.get(0).getSpec().getAno()));
                txtRelacao.setText(String.valueOf(bikes.get(0).getSpec().getRelacao()));;
                txtSuspensao.setText(String.valueOf(bikes.get(0).getSpec().getSuspensao()));
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
 }

