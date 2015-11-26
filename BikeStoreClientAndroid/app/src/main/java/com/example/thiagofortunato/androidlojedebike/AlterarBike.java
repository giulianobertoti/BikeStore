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

import java.util.LinkedList;
import java.util.List;

public class AlterarBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_bike);

        final EditText txtPreco = (EditText) (findViewById(R.id.txtUpdPreco));
        final EditText txtCor = (EditText) (findViewById(R.id.txtUpdCor));
        final EditText txtNumSerie = (EditText) (findViewById(R.id.txtUpdNumSerie));
        final EditText txtTamanho = (EditText) (findViewById(R.id.txtUpdTamanho));
        final EditText txtMarca = (EditText) (findViewById(R.id.txtUpdMarca));
        final EditText txtAno = (EditText) (findViewById(R.id.txtUpdAno));
        final EditText txtRelacao = (EditText) (findViewById(R.id.txtUpdRelacao));
        final EditText txtSuspensao = (EditText) (findViewById(R.id.txtUpdSuspensao));
        final Button btnAlterBike = (Button) (findViewById(R.id.btnAlterar));
        final Spinner spnAlterar = (Spinner) (findViewById(R.id.spnDelete));

        final LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid(); //minha loja

        lojaDeBike.getBikes(); //lista com todas as bikes

        List<String> listaDel= lojaDeBike.getAllNumSerie();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaDel);
        spnAlterar.setAdapter(adapter);


        spnAlterar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectItemView, int postion, long id) {
                String numSerieSelecionado = String.valueOf(spnAlterar.getSelectedItem());
                LinkedList<Bike> bikes = lojaDeBike.getNumSerie(numSerieSelecionado);

                txtPreco.setText(String.valueOf(bikes.get(0).getPreco()));
                txtCor.setText(String.valueOf(bikes.get(0).getCor()));
                txtNumSerie.setText(String.valueOf(bikes.get(0).getNumSerie()));
                txtTamanho.setText(String.valueOf(bikes.get(0).getSpec().getTamanho()));
                txtMarca.setText(String.valueOf(bikes.get(0).getSpec().getMarca()));
                txtAno.setText(String.valueOf(bikes.get(0).getSpec().getAno()));
                txtRelacao.setText(String.valueOf(bikes.get(0).getSpec().getRelacao()));
                txtSuspensao.setText(String.valueOf(bikes.get(0).getSpec().getSuspensao()));
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        btnAlterBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int preco = Integer.parseInt(String.valueOf(txtPreco.getText()));
                String cor = String.valueOf(txtCor.getText());
                String numSerie = String.valueOf(txtNumSerie.getText());
                int tamanho = Integer.parseInt(String.valueOf(txtTamanho.getText()));
                String marca = String.valueOf(txtMarca.getText());
                int ano = Integer.parseInt(String.valueOf(txtAno.getText()));
                String relacao = String.valueOf(txtRelacao.getText());
                String suspensao = String.valueOf(txtSuspensao.getText());

                Bike bike = new Bike(preco, cor, numSerie, new EspecBike(tamanho, marca, ano, relacao, suspensao));

                String numSerieSelecionado = String.valueOf(spnAlterar.getSelectedItem());

                alterarBike(numSerieSelecionado,bike);
            }
        });
    }

    public void alterarBike(String numSerie, Bike bike) {
        Toast aviso;
        LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid();
        boolean updateBike = lojaDeBike.updateBike(numSerie,bike);
        if (updateBike) {
            aviso = Toast.makeText(this, " Bike alterada com Sucesso ", Toast.LENGTH_LONG);
            aviso.show();
        } else {
            aviso = Toast.makeText(this, "Desculpe, falha ao Alterar ", Toast.LENGTH_LONG);
            aviso.show();
        }
    }


}
