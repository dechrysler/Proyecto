package com.example.chrysler_munoz.proyecto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.chrysler_munoz.proyecto.Base.Plato;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.chrysler_munoz.proyecto.ListarPlatos.platos;

public class ListarPlatos extends Activity {
    public static List<Plato>platos= new ArrayList<>();
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_platos);
        CargarDatos carga = new CargarDatos();
        carga.execute();
        ListView lvPlatos = findViewById(R.id.lvPlatos);
        adapter= new Adapter(this,R.layout.elemento,platos);
        lvPlatos.setAdapter(adapter);
        registerForContextMenu(lvPlatos);
    }
}
class CargarDatos extends AsyncTask<String, Integer, Void> {

    public List<Plato> evnet= new ArrayList<>();
    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(String... strings) {
        List<Plato> evnts= new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://10.0.2.2:8082" + "/platos", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        platos.clear();
        platos.addAll(evnts);
        return null;
    }
    public List<Plato> getEvnet(){
        return evnet;
    }
}
