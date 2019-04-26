package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClienteActivity extends AppCompatActivity {
    private TextView Nombre, Telefono, Sexo, Cedula, Direccion, Apellido, Ocupacion;
    public static int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Nombre =  findViewById(R.id.twNombreD);
        Apellido = findViewById(R.id.twApellidoD);
        Sexo = findViewById(R.id.twSexoD);
        Telefono = findViewById(R.id.twTelefonoD);
        Cedula = findViewById(R.id.twCedulaD);
        Ocupacion = findViewById(R.id.twOcupacionD);
        Direccion = findViewById(R.id.twDireccionD);
        n = 0;
        Clientes(n);
        Button siguiente = findViewById(R.id.btSiguiente1);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n == (PrincipalActivity.listaClientes.size()-1)){
                    Toast.makeText(ClienteActivity.this, "Llego al final", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    n++;
                    Clientes(n);
                }
            }
        });
        Button anterior = findViewById(R.id.btAnterior1);
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n==0){
                    Toast.makeText(ClienteActivity.this, "Llego al inicio", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    n--;
                    Clientes(n);
                }
            }
        });
        Button nuevo = findViewById(R.id.btNuevoPrestamo);
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(ClienteActivity.this, SecondActivity.class);
                startActivity(intent);*/
            }
        });
    }
    public void Clientes(int n){
        Cliente item = PrincipalActivity.listaClientes.get(n);
        Nombre.setText(item.nombre);
        Apellido.setText(item.apellido);
        Sexo.setText(item.sexo);
        Telefono.setText(item.telefono);
        Cedula.setText(item.cedula);
        Ocupacion.setText(item.ocupacion);
        Direccion.setText(item.direccion);
    }

}
