package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;

public class ListarPlatos extends Activity {

    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_platos);

        ListView lvPlatos = findViewById(R.id.lvPlatos);
        adapter= new Adapter(this,R.layout.elemento,ensaladas);
        lvPlatos.setAdapter(adapter);
        registerForContextMenu(lvPlatos);
    }
}
