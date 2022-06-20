package com.example.viajeseguro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                if (nuevoUsuario()){
                    intent = new Intent(MainActivity.this, MenuActivity.class);
                }else{
                    intent = new Intent(MainActivity.this, InicioActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 500);
    }

    //SharedPreferences
    private boolean nuevoUsuario(){
        SharedPreferences preferencias = getSharedPreferences("user.dat", Context.MODE_PRIVATE);
        return preferencias.getBoolean("registrado", false);
    }

}