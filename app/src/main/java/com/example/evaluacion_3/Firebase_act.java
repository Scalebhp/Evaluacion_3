package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clientes.Clientes;

public class Firebase_act extends AppCompatActivity {
    private EditText nombre,destino,promocion;
    private Button button;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        nombre=(EditText)findViewById(R.id.et_nombre);
        destino=(EditText)findViewById(R.id.et_destino);
        promocion=(EditText)findViewById(R.id.et_promocion);
        button=(Button)findViewById(R.id.btn_guardar);
        iniciarBase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!nombre.getText().toString().equals("")){
                   Clientes c=new Clientes();
                   c.setId(UUID.randomUUID().toString());
                   c.setNombre(nombre.getText().toString());
                   c.setDestino(destino.getText().toString());
                   c.setPromocion(promocion.getText().toString());
                   databaseReference.child("Clientes").child(c.getId()).setValue(c);
                   Toast.makeText(getBaseContext(),"Datos Ingresado en la base con exito",Toast.LENGTH_LONG).show();
               }else{
                   Toast.makeText(getBaseContext(),"Datos no Ingresado en la base",Toast.LENGTH_LONG).show();
               }

            }
        });


    }

    public void iniciarBase()
    {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }

    public void ListaFirebase(View view)
    {
        Intent i=new Intent(this,ListadoClientes_act.class);
        startActivity(i);
    }
}