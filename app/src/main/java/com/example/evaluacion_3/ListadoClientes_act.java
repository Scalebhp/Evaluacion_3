package com.example.evaluacion_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clientes.Clientes;

public class ListadoClientes_act extends AppCompatActivity {
    private ListView lista;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ArrayList<Clientes>listaClientes=new ArrayList<Clientes>();
    Clientes clientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);

        lista=(ListView)findViewById(R.id.lv);
        iniciarBase();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clientesSelected=(Clientes)parent.getItemAtPosition(position);
            }
        });

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot:snapshot.getChildren())
                {
                    Clientes clientes=objSnapshot.getValue(Clientes.class);
                    listaClientes.add(clientes);

                    ArrayAdapter adapter=new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,listaClientes);
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    public void iniciarBase()
    {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }
    public void Eliminar(View view)
    {
        Clientes clientes =new Clientes();
        clientes.setId(clientesSelected.getId());
        databaseReference.child("Clientes").child(clientes.getId()).removeValue();
        Toast.makeText(getBaseContext(),"Cliente Elimina en nuestro sistema",Toast.LENGTH_LONG).show();
    }

}