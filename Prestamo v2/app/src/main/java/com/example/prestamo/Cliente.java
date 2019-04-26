package com.example.prestamo;

import java.io.Serializable;

public class Cliente implements Serializable {
    String nombre;
    String apellido;
    String telefono;
    String sexo;
    String cedula;
    String ocupacion;
    String direccion;
    public Cliente (){
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.sexo = "";
        this.cedula = "";
        this.ocupacion = "";
        this.direccion = "";
    }
}
