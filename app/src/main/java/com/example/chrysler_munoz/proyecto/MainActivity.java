package com.example.chrysler_munoz.proyecto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chrysler_munoz.proyecto.Base.Plato;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.chrysler_munoz.proyecto.MainActivity.alaplancha;
import static com.example.chrysler_munoz.proyecto.MainActivity.bebida;
import static com.example.chrysler_munoz.proyecto.MainActivity.ensaladas;
import static com.example.chrysler_munoz.proyecto.MainActivity.entrante;
import static com.example.chrysler_munoz.proyecto.MainActivity.hamburguesa;
import static com.example.chrysler_munoz.proyecto.MainActivity.pasta;
import static com.example.chrysler_munoz.proyecto.MainActivity.postre;

public class MainActivity extends Activity implements View.OnClickListener {
    public static List<Plato>ensaladas= new ArrayList<>();
    public static List<Plato>pasta= new ArrayList<>();
    public static List<Plato>hamburguesa= new ArrayList<>();
    public static List<Plato>entrante= new ArrayList<>();
    public static List<Plato>alaplancha= new ArrayList<>();
    public static List<Plato>bebida= new ArrayList<>();
    public static List<Plato>postre= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargarDatos carga = new CargarDatos();
        carga.execute();
        Button btnCarta = findViewById(R.id.btnArticulos);
        btnCarta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btnMenus:
                intent = new Intent(this,Menus.class);
                startActivity(intent);
                break;
            case R.id.btnArticulos:
                intent = new Intent(this,Carta.class);
                startActivity(intent);
                break;
            default:
                return;

        }
    }
}
class CargarDatos extends AsyncTask<String, Integer, Void> {


    List<Plato> evnts= new ArrayList<>();
    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(String... strings) {
        Ensaladas();
        Pasta();
        Hamburguesa();
        AlaPlancha();
       // Bebida();
//        Postre();
        Entrante();
        return null;
    }
    public void Ensaladas(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://192.168.34.34:8082" + "/platos_ensalada", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        ensaladas.clear();
        ensaladas.addAll(evnts);

    }
    public void Pasta(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://192.168.34.34:8082" + "/platos_pasta", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        pasta.clear();
        pasta.addAll(evnts);
    }
    public void Hamburguesa(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://192.168.34.34:8082" + "/platos_hamburguesa", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        hamburguesa.clear();
        hamburguesa.addAll(evnts);
    }
    public void Entrante(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://192.168.34.34:8082" + "/platos_entrante", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        entrante.clear();
        entrante.addAll(evnts);

    }
    public void AlaPlancha(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("http://192.168.34.34:8082" + "/platos_alaplancha", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        alaplancha.clear();
        alaplancha.addAll(evnts);
    }
    public void Postre(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("192.168.34.34:8082" + "/platos_postre", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        postre.clear();
        postre.addAll(evnts);
    }
    public void Bebida(){
        evnts.clear();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Plato[] opinionesArray = restTemplate.getForObject("192.168.34.34:8082" + "/platos_bebida", Plato[].class);
        evnts.addAll(Arrays.asList(opinionesArray));
        bebida.clear();
        bebida.addAll(evnts);
    }
}
