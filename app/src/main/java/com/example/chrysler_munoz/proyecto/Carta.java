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
        }
    }
}
