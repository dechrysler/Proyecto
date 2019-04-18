package com.example.chrysler_munoz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMenu  = findViewById(R.id.btnMenus);
        btnMenu.setOnClickListener(this);
        Button btnSueltos  = findViewById(R.id.btnProductos);
        btnSueltos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
