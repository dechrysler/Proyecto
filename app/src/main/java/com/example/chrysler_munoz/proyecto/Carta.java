package com.example.chrysler_munoz.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chrysler_munoz.proyecto.Base.Plato;

import java.util.List;

import static com.example.chrysler_munoz.proyecto.MainActivity.listado;
import static com.example.chrysler_munoz.proyecto.MainActivity.pedidos;

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

        Button btnCom = findViewById(R.id.btnComprar);
        btnCom.setOnClickListener(this);

        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView elementos  = findViewById(R.id.tvProductos);
        elementos.setText("Productos:"+pedidos.size());

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
            case R.id.btnComprar:
                if(pedidos.size()>0)
                {
                    Intent intent2 = new Intent(this,Ordenar.class);
                    listado.clear();
                    intent2.putExtra("lista", buscarRepetidos(pedidos));
                    startActivity(intent2);

                }
                break;
            case R.id.btnBorrar:
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
