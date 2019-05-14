package com.example.chrysler_munoz.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Carta extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        Button btnEnsalada= findViewById(R.id.btnEnsalada);
        btnEnsalada.setOnClickListener(this);

        Button btnPasta= findViewById(R.id.btnPasta);
        btnPasta.setOnClickListener(this);

        Button btnHamburguesa= findViewById(R.id.btnHamburguesa);
        btnHamburguesa.setOnClickListener(this);

        Button btnPostre= findViewById(R.id.btnPostre);
        btnPostre.setOnClickListener(this);

        Button btnBebida= findViewById(R.id.btnBebidas);
        btnBebida.setOnClickListener(this);

        Button btnEntrante= findViewById(R.id.btnEntrante);
        btnEntrante.setOnClickListener(this);

        Button btnAlaPlancha = findViewById(R.id.btnAlaPlancha);
        btnAlaPlancha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent  intent = new Intent(this,ListarPlatos.class);
        switch (v.getId()) {
            case R.id.btnEnsalada:
                intent.putExtra("tipo",2);
                startActivity(intent);
                break;
            case R.id.btnHamburguesa:
                intent.putExtra("tipo",3);
                startActivity(intent);
                break;
            case R.id.btnPasta:
                intent.putExtra("tipo",1);
                startActivity(intent);
                break;

            case R.id.btnBebidas:
                intent.putExtra("tipo",4);
                startActivity(intent);
                break;

            case R.id.btnAlaPlancha:
                intent.putExtra("tipo",5 );
                startActivity(intent);
                break;
            case R.id.btnPostre:
                intent.putExtra("tipo",6);
                startActivity(intent);
                break;
            case R.id.btnEntrante:
                intent.putExtra("tipo",7);
                startActivity(intent);
                break;
        }
    }
}
