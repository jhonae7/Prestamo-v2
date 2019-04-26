package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Telefono, Cedula, Direccion, Apellido, Ocupacion;
    private Spinner Sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre = findViewById(R.id.edNombre);
        Apellido = findViewById(R.id.edApellido);
        Sexo = findViewById(R.id.spSexo);
        Telefono = findViewById(R.id.edTelefono);
        Cedula = findViewById(R.id.edCedula);
        Ocupacion = findViewById(R.id.edOcupacion);
        Direccion = findViewById(R.id.edDireccion);
        Button button = findViewById(R.id.btGuardarCliente);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Nombre.getText().toString().isEmpty()) {
                    Nombre.setError("Campo Obligatorio");
                    Toast.makeText(MainActivity.this,"Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Telefono.getText().toString().isEmpty()) {
                    Telefono.setError("Campo obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Cedula.getText().toString().isEmpty()) {
                    Cedula.setError("Campo Obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Direccion.getText().toString().isEmpty()) {
                    Direccion.setError("Campo obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Cliente cliente = new Cliente();
                    String nombre = Nombre.getText().toString();
                    String apellido = Apellido.getText().toString();
                    String sexo = Sexo.getSelectedItem().toString();
                    String telefono = Telefono.getText().toString();
                    String cedula = Cedula.getText().toString();
                    String ocupacion = Ocupacion.getText().toString();
                    String direccion = Direccion.getText().toString();
                    cliente.nombre = nombre;
                    cliente.apellido = apellido;
                    cliente.sexo = sexo;
                    cliente.telefono = telefono;
                    cliente.cedula = cedula;
                    cliente.ocupacion = ocupacion;
                    cliente.direccion = direccion;
                    Intent intent = new Intent();
                    intent.putExtra("cliente", cliente);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        Button button1 = findViewById(R.id.btCancelarCliente);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}

