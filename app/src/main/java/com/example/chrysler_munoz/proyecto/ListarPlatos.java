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

import static com.example.chrysler_munoz.proyecto.MainActivity.alaplancha;
import static com.example.chrysler_munoz.proyecto.MainActivity.bebida;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.entrante;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
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
         tv.setText("Productos:"+pedidos.size());
        Toast.makeText(this,"añadido",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(pedidos.size()>0)
        {
            Intent intent = new Intent(this,Ordenar.class);
            startActivity(intent);

        }
    }
}
