package com.example.viajeseguro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {

    private Spinner usuario;
    private EditText contrasena;
    private CheckBox guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Relacionamos componentes
        usuario = findViewById(R.id.spnUsuarios);
        contrasena = findViewById(R.id.edtContrasenia);
        guardar = findViewById(R.id.chbxRecordar);

        //Arreglo para spinner de usuarios
        String listaUsua[] = {"Admin", "Jovana", "Luis"};

        //Adapter para spinner
        ArrayAdapter<String> UAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaUsua);
        usuario.setAdapter(UAdapter);
    }

    public void ingresar(View view) {
        String usr, pass;
        if (!contrasena.getText().toString().equals("")) {
            usr = usuario.getSelectedItem().toString().trim();
            pass = contrasena.getText().toString().trim();
            if (usr.equals("Admin") && pass.equals("1234")) {
                accion("Admin", "1234");
            } else if (usr.equals("Jovana") && pass.equals("Jovana1234")) {
                accion("Jovana", "Jovana1234");
            } else if (usr.equals("Luis") && pass.equals("Luis1234")) {
                accion("Luis", "Luis1234");
            } else {
                Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Ingrese contraseña Por favor", Toast.LENGTH_SHORT).show();
        }
    }

    private void accion(String email, String con){
        Usuario usu = new Usuario(email, con, true);
        if(guardar.isChecked()){
            guardarpreferencias(usu);
        }
            Intent intent = new Intent(InicioActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();

    }

    public void salir(View view){
        Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void guardarpreferencias(Usuario u){
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("correo", u.getCorreo());
        editor.putString("contrasena", u.getContrasena());
        editor.putBoolean("registrado", u.isRegistrado());
        editor.apply();
        finish();
    }
}