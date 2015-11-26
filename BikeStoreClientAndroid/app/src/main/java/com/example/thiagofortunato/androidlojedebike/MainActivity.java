package com.example.thiagofortunato.androidlojedebike;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnAdd = (Button) findViewById(R.id.btnAddBike);
        final Button btnConsulta = (Button) findViewById(R.id.btnConsultarBikes);
        final Button btnAltera = (Button) findViewById(R.id.btnAlterar);
        final Button btnDeleta = (Button) findViewById(R.id.btnDelete);
    }

    public void showAddBike(View view) {
        Intent addBike = new Intent(this, AdicionarBike.class);
        startActivity(addBike);
    }

    public void showConsultarBike(View view) {
        Intent consultaBike= new Intent(this, ConsultarBike.class);
        startActivity(consultaBike);
    }

    public void showDeletarBike(View view) {
        Intent deleteBike = new Intent(this, DeletarBike.class);
        startActivity(deleteBike);
    }

    public void showAlterarBike(View view) {
        Intent alteraBike = new Intent(this, AlterarBike.class);
        startActivity(alteraBike);
    }
}
