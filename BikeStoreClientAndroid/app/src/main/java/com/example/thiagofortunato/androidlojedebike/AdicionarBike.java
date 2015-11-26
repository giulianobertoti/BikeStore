package com.example.thiagofortunato.androidlojedebike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_bike);

        final EditText txtPreco = (EditText) (findViewById(R.id.txtPreco));
        final EditText txtCor = (EditText) (findViewById(R.id.txtCor));
        final EditText txtNumSerie = (EditText) (findViewById(R.id.txtNumSerieDel));
        final EditText txtTamanho = (EditText) (findViewById(R.id.txtTamanho));
        final EditText txtMarca = (EditText) (findViewById(R.id.txtMarca));
        final EditText txtAno = (EditText) (findViewById(R.id.txtAno));
        final EditText txtRelacao = (EditText) (findViewById(R.id.txtRelacao));
        final EditText txtSuspensao = (EditText) (findViewById(R.id.txtSuspensao));
        final Button btnAddBike = (Button) (findViewById(R.id.btnAddBike));
        btnAddBike.setOnClickListener(new View.OnClickListener() {
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

                Bike bike = new Bike(preco,cor,numSerie,new EspecBike(tamanho,marca,ano,relacao,suspensao));
                addBike(bike);
            }
        });
    }

    public void addBike(Bike bike) {
        Toast aviso;
        LojaDeBikeAndroid lojaDeBike = new LojaDeBikeAndroid();
        boolean add = lojaDeBike.addBike(bike);
        if (add) {
            aviso = Toast.makeText(this, " Bike adicionada com Sucesso ", Toast.LENGTH_LONG);
            aviso.show();
        } else {
            aviso = Toast.makeText(this, "Desculpe, falha ao Adicionar ", Toast.LENGTH_LONG);
            aviso.show();
        }
    }
}
