package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import Clientes.Clientes;

public class Menu_act extends AppCompatActivity {
    private VideoView video;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Clientes clientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        video=(VideoView)findViewById(R.id.vd);

        String ruta="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri=Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        video.setMediaController(mediaController);
    }

    public void Firebase(View view)
    {
        Intent i=new Intent(this,Firebase_act.class);
        startActivity(i);
    }

    public void Promocion(View view)
    {

        Intent i=new Intent(this,Promociones_act.class);
        startActivity(i);
    }

    public void iniciarBase()
    {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }
}