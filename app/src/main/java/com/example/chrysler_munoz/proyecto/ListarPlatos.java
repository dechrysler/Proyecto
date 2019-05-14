package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.chrysler_munoz.proyecto.MainActivity.alaplancha;
import static com.example.chrysler_munoz.proyecto.MainActivity.bebida;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.entrante;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
import static com.example.chrysler_munoz.proyecto.MainActivity.pasta;
import static com.example.chrysler_munoz.proyecto.MainActivity.postre;

public class ListarPlatos extends Activity implements ListView.OnItemClickListener{

    private int ident;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ident=getIntent().getIntExtra("tipo",0);
        setContentView(R.layout.activity_listar_platos);
        ListView lvPlatos = findViewById(R.id.lvPlatos);
        lvPlatos.setOnItemClickListener(this);

        switch (ident){
            case 1:
                adapter= new Adapter(this,R.layout.elemento,pasta);

                break;
            case 2:
                adapter= new Adapter(this,R.layout.elemento,ensaladas);

                break;
            case 3:
                adapter= new Adapter(this,R.layout.elemento,hamburguesa); lvPlatos.setAdapter(adapter);

                break;
            case 4:
                adapter= new Adapter(this,R.layout.elemento,bebida);
                break;
            case 5:
                adapter= new Adapter(this,R.layout.elemento,alaplancha);
                break;
            case 6:
                adapter= new Adapter(this,R.layout.elemento,postre);
                break;
            case 7:
                adapter= new Adapter(this,R.layout.elemento,entrante);

                break;
        }
        lvPlatos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        registerForContextMenu(lvPlatos);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,adapter.getItem(position).toString(),Toast.LENGTH_SHORT).show();
    }
}
