package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chrysler_munoz.proyecto.Adapter.Adapter;
import com.example.chrysler_munoz.proyecto.Base.Plato;

import java.util.List;

import static com.example.chrysler_munoz.proyecto.MainActivity.alaplancha;
import static com.example.chrysler_munoz.proyecto.MainActivity.bebida;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.entrante;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
import static com.example.chrysler_munoz.proyecto.MainActivity.listado;
import static com.example.chrysler_munoz.proyecto.MainActivity.pasta;
import static com.example.chrysler_munoz.proyecto.MainActivity.pedidos;
import static com.example.chrysler_munoz.proyecto.MainActivity.postre;

public class ListarPlatos extends Activity implements ListView.OnItemClickListener, View.OnClickListener{

    private int ident;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ident=getIntent().getIntExtra("tipo",0);
        setContentView(R.layout.activity_listar_platos);
        ListView lvPlatos = findViewById(R.id.lvPlatos);
        lvPlatos.setOnItemClickListener(this);
        Button btnOrdenar = findViewById(R.id.btnOrdenar);
        btnOrdenar.setOnClickListener(this);
        Button btnEliminar = findViewById(R.id.btnBorrarAll);
        btnEliminar.setOnClickListener(this);
        switch (ident){
            case 1:
                adapter= new Adapter(this,R.layout.elemento,pasta);
                break;
            case 2:
                adapter= new Adapter(this,R.layout.elemento,ensaladas);
                break;
            case 3:
                adapter= new Adapter(this,R.layout.elemento,hamburguesa);
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
    protected void onResume() {
        super.onResume();
        TextView elementos  = findViewById(R.id.tvProductos);
        elementos.setText("Productos:"+pedidos.size());

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pedidos.add((Plato) adapter.getItem(position));
         TextView tv = findViewById(R.id.tvProductos);
        Toast.makeText(this,"prducto añadido",Toast.LENGTH_SHORT).show();
         tv.setText("Productos:"+pedidos.size());
    }

    @Override
    public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnOrdenar:
                    if(pedidos.size()>0)
                    {
                    Intent intent = new Intent(this, Ordenar.class);
                    listado.clear();
                    intent.putExtra("lista", buscarRepetidos(pedidos));
                    startActivity(intent);
                     break;
                    }
                case R.id.btnBorrarAll:
                    if(pedidos.size()>0)
                    {
                        pedidos.clear();
                        TextView elementos  = findViewById(R.id.tvProductos);
                        elementos.setText("Productos:"+pedidos.size());
                    }
                    break;

        }
    }
    public int[] buscarRepetidos(List<Plato> plats) {
        int pos = 0;
        int x = pos+1;
        int[] list = new int[plats.size()];
        for (Plato plat: plats)
            listado.add(plat);
        for (int i = 0; i <= listado.size(); i++) {
            x=0;
            x=pos+1;
            boolean hay = true;
            while (x< listado.size() && hay == true) {
                if (listado.get(pos).getId() == listado.get(x).getId()) {
                    list[pos]++;
                    listado.remove(x);
                    hay = false;
                }
                x++;
            }
            if (hay == true)
                pos=pos+1;


        }
        pos=0;
        for (int i = 0; i <= listado.size(); i++) {
            x=0;
            x=pos+1;
            boolean hay = true;
            while (x< listado.size() && hay == true) {
                if (listado.get(pos).getId() == listado.get(x).getId()) {
                    list[pos]++;
                    listado.remove(x);
                    hay = false;
                }
                x++;
            }
            if (hay == true)
                pos=pos+1;


        }

        return list;
    }
}

