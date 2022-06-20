package com.example.viajeseguro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity{

    DrawerLayout mdrawerLayout;
    NavigationView navigationView;
    Toolbar tol;
    ActionBarDrawerToggle toggle;
    public int tam = 10;
    public reporte[] arreglo = new reporte[tam];
    public int contador = 0;

    public ArrayList<reporte> reporteslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mdrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        tol = findViewById(R.id.toolbar);

        toggle = new ActionBarDrawerToggle(this, mdrawerLayout, tol, R.string.drawer_open, R.string.drawer_close);
        mdrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        /*
        getSupportFragmentManager().beginTransaction().add(R.id.content, new HomeFragment()).commit();
        setTitle("Inicio");
        setSupportActionBar(tol);

        navigationView.setNavigationItemSelectedListener(this);
         */

        tol.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdrawerLayout.open();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (item.getItemId()){
                    case R.id.nav_inicio:
                        ft.replace(R.id.content, new HomeFragment()).commit();

                        break;
                    case R.id.nav_foro:
                        ft.replace(R.id.content, new ForoFragment()).commit();

                        break;
                    case R.id.nav_ayuda:
                        ft.replace(R.id.content, new AyudaFragment()).commit();

                        break;
                    case R.id.nav_cerrarSesión:
                        cerrarSesion();
                        break;
                    case R.id.nav_registro:
                        ft.replace(R.id.content, new RegistarReporteFragment()).commit();

                        break;
                }
                item.setChecked(true);
                setTitle(item.getTitle());
                mdrawerLayout.closeDrawers();
                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.content, new HomeFragment()).commit();
        setTitle("Inicio");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrarSesion(){
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear(); //borra los datos almacenados
        editor.apply(); //se guardan los cambios

        //regresar activity login
        Intent intent = new Intent(this, InicioActivity.class);
        //Inicializar las banderas como si se iniciara el activity por primera vez
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectorItem(item);
        return true;
    }

    private void selectorItem(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_inicio:
                ft.replace(R.id.content, new HomeFragment()).commit();
                break;
            case R.id.nav_foro:
                ft.replace(R.id.content, new ForoFragment()).commit();
                break;
            case R.id.nav_ayuda:
                ft.replace(R.id.content, new AyudaFragment()).commit();
                break;
            case R.id.nav_cerrarSesión:

                break;
        }
        setTitle(item.getTitle());
        mdrawerLayout.closeDrawers();
    }

     */
}