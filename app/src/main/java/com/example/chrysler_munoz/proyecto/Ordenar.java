package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.chrysler_munoz.proyecto.Adapter.Adapter;
import com.example.chrysler_munoz.proyecto.Adapter.AdapterCompra;

import static com.example.chrysler_munoz.proyecto.MainActivity.pedidos;

public class Ordenar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar);
        ListView lvOrden = findViewById(R.id.lvOrden);
       AdapterCompra adapter= new AdapterCompra(this,R.layout.producto_pago,pedidos);
       lvOrden.setAdapter(adapter);
    }
}
