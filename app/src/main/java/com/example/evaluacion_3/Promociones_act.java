package com.example.evaluacion_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clientes.Clientes;

public class Promociones_act extends AppCompatActivity {
    private EditText promocion;
    private EditText valor;
    private Spinner spin;
    private TextView text,text1;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        promocion=(EditText) findViewById(R.id.et_promo);
        valor=(EditText)findViewById(R.id.et_valor);
        spin=(Spinner)findViewById(R.id.sp);
        button=(Button)findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String opcion=spin.getSelectedItem().toString();
                String promo=promocion.getText().toString();
                if (promo.equals("Pizzas promo"))
                {
                    int precio=5990;
                    int pago=Integer.parseInt(valor.getText().toString());
                    int operacion=precio+pago;
                    String resultado=String.valueOf(operacion);
                    if (opcion.equals("Ramiro"))
                    {
                        text1.setText("Estimado Ramiro al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Rosa"))
                    {
                        text1.setText("Estimado Rosa al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Robert"))
                    {
                        text1.setText("Estimado Robert al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }

                }else if (promo.equals("Master pizza"))
                {

                    int precio=12990;
                    int pago=Integer.parseInt(valor.getText().toString());
                    int operacion=precio+pago;
                    String resultado=String.valueOf(operacion);
                    if (opcion.equals("Ramiro"))
                    {
                        text1.setText("Estimado Ramiro al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Rosa"))
                    {
                        text1.setText("Estimado Rosa al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Robert"))
                    {
                        text1.setText("Estimado Robert al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }

                }else if (promo.equals("Pizza max"))
                {

                    int precio=18500;
                    int pago=Integer.parseInt(valor.getText().toString());
                    int operacion=precio+pago;
                    String resultado=String.valueOf(operacion);
                    if (opcion.equals("Ramiro"))
                    {
                        text1.setText("Estimado Ramiro al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Rosa"))
                    {
                        text1.setText("Estimado Rosa al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }else  if (opcion.equals("Robert"))
                    {
                        text1.setText("Estimado Robert al final segun promocion y envio es:");
                        text.setText(""+resultado);
                    }

                }




            }
        });

        String listaCliente[]={"Ramiro","Rosa","Robert"};
        ArrayAdapter<String> adapt=new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,listaCliente);
        spin.setAdapter(adapt);

        text=(TextView)findViewById(R.id.tv);
        text1=(TextView)findViewById(R.id.tv2);
    }


}