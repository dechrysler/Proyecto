package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
import static com.example.chrysler_munoz.proyecto.MainActivity.pasta;

public class ListarPlatos extends Activity {

    private int ident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ident=getIntent().getIntExtra("tipo",0);
        setContentView(R.layout.activity_listar_platos);
        ListView lvPlatos = findViewById(R.id.lvPlatos);
        Adapter adapter;
        switch (ident){
            case 1:
                adapter= new Adapter(this,R.layout.elemento,pasta);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
            case 2:
                adapter= new Adapter(this,R.layout.elemento,ensaladas);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
            case 3:
                adapter= new Adapter(this,R.layout.elemento,hamburguesa); lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
        }



    }
}
