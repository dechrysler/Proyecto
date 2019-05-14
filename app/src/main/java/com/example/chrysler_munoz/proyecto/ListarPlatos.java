package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import static com.example.chrysler_munoz.proyecto.MainActivity.alaplancha;
import static com.example.chrysler_munoz.proyecto.MainActivity.bebida;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.entrante;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
import static com.example.chrysler_munoz.proyecto.MainActivity.pasta;
import static com.example.chrysler_munoz.proyecto.MainActivity.postre;

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
            case 4:
                adapter= new Adapter(this,R.layout.elemento,bebida);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
            case 5:
                adapter= new Adapter(this,R.layout.elemento,alaplancha);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
            case 6:
                adapter= new Adapter(this,R.layout.elemento,postre);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;
            case 7:
                adapter= new Adapter(this,R.layout.elemento,entrante);
                lvPlatos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                registerForContextMenu(lvPlatos);
                break;

        }



    }
}
