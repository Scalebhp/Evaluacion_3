package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.et_usuario);
        contrasena=(EditText)findViewById(R.id.et_contrasena);
    }

    public void Iniciar(View view){
        String nom=nombre.getText().toString();
        String pass=contrasena.getText().toString();
        if (nom.equals("Android")&&pass.equals("123")){
            Intent i=new Intent(this,Menu_act.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"Debe ingresar un nombre de usuario y una contrasena",Toast.LENGTH_LONG).show();
        }
    }
}