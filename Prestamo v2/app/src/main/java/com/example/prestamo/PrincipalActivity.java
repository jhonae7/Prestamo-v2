package com.example.prestamo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    public TextView Actividades;
    public static List<Cliente> listaClientes = new ArrayList<>();
    public static List<Prestamo> listaPrestamos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Actividades = findViewById(R.id.tvActividades);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnAcerdade:
                Toast.makeText(this, "Electiva Android", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnVerPrestamo:
                Intent intent3 = new Intent(this, PrestamosActivity.class);
                startActivity(intent3);
                break;
            case R.id.mnVerCliente:
                Intent intent2 = new Intent(this, ClienteActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnNuevoCliente:
                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent, 1111);
                break;
            case R.id.mnNuevoPrestamo:
                Intent intent1 = new Intent(this, SecondActivity.class);
                startActivityForResult(intent1, 2222);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1111){
            if(requestCode==0) {
                Actividades.append("Cancelo el ingreso de cliente\n");
                registerForContextMenu(Actividades);
            }
            else {
                Cliente cliente = (Cliente) data.getExtras().getSerializable("cliente");
                listaClientes.add(cliente);
                Actividades.append("Ingreso a cliente " + cliente.nombre + "\n" );
                registerForContextMenu(Actividades);
            }
        }
        //if(requestCode==2222)
        else{
            if (resultCode==0){
                Actividades.append("Cancelo ingreso de prestamo\n");
                registerForContextMenu(Actividades);
            }
            else
            {
                Prestamo prestamo = (Prestamo) data.getExtras().getSerializable("prestamo");
                listaPrestamos.add(prestamo);
                Actividades.append("Ingreso de nuevo prestamo\n");
                registerForContextMenu(Actividades);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.borrar:
                Actividades.setText("");
                break;
            case R.id.copiar:
                ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("CortaPapeles", Actividades.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

