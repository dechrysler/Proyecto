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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEnsalada:
                Intent intent = new Intent(this,ListarPlatos.class);
                startActivity(intent);

        }
    }
}
