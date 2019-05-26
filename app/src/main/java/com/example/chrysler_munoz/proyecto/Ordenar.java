package com.example.chrysler_munoz.proyecto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chrysler_munoz.proyecto.Adapter.AdapterCompra;
import com.example.chrysler_munoz.proyecto.Base.Pedido;
import com.example.chrysler_munoz.proyecto.Base.Plato;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.chrysler_munoz.proyecto.MainActivity.listado;
import static com.example.chrysler_munoz.proyecto.MainActivity.pedidos;

public class Ordenar extends Activity implements View.OnClickListener, ListView.OnItemClickListener {

    private int numeroPedido=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar);
        ListView lvOrden = findViewById(R.id.lvOrden);
       AdapterCompra adapter= new AdapterCompra(this,R.layout.producto_pago,listado,getIntent().getIntArrayExtra("lista"));
       lvOrden.setAdapter(adapter);
       double i=0;
       for(Plato plat: pedidos)
           i=i+plat.getPrecio();
        TextView total = findViewById(R.id.tvTotal);
        total.setText(""+String.format("%.2f", i));
        ObtenerTamanio carga = new ObtenerTamanio();
        carga.execute();
        Button btnOrdenar = findViewById(R.id.btnOrdenar);
        btnOrdenar.setOnClickListener(this);

        Button button=findViewById(R.id.btnCancelar);
        button.setOnClickListener(this);
        lvOrden.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOrdenar:
                HacerPedido carga = new HacerPedido();
                carga.execute();
                Intent intent = new Intent(this, SplashCompra.class);
                startActivity(intent);
                break;
            case R.id.btnCancelar:
                pedidos.clear();
                onBackPressed();
                break;
            case R.id.btnQuitar:
                Toast.makeText(this,"click",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }



    class HacerPedido extends AsyncTask<String, Integer, Void> {


        List<Plato> evnts= new ArrayList<>();
        @SuppressLint("WrongThread")
        @Override
        protected Void doInBackground(String... strings) {
            double i=0;
            int x=0;
            String ids="";
            for(Plato plat: pedidos) {
                i = i + plat.getPrecio();
                ids=ids+plat.getId();
                if(x<pedidos.size())
                    ids=ids+",";
                x++;
            }
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getForObject("http://http://10.0.2.2:8082" + "/add_pedido?precioTotal=" +String.valueOf(i)
                    +"&fecha=" + "ni" + "&preparado=" + "no" + "&lista="
                    + ids+ "&numero=" + String.valueOf(numeroPedido),Void.class);
            return null;
        }

    }
    class ObtenerTamanio extends AsyncTask<String, Integer, Void> {


        List<Pedido>evnts= new ArrayList<>();
        @SuppressLint("WrongThread")
        @Override
        protected Void doInBackground(String... strings) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Pedido[] platosArray = restTemplate.getForObject("http://http://10.0.2.2:8082" + "/pedidos", Pedido[].class);
            evnts.addAll(Arrays.asList(platosArray));
            numeroPedido=evnts.size()+1;
            return null;
        }

    }
}

