package com.example.prestamo;

import java.io.Serializable;

public class Prestamo implements Serializable {
    String cliente;
    String monto_credito;
    String interes;
    String plazo;
    String fecha_actual;
    String fecha_final;
    String monto_pagar;
    String monto_cuota;
    public Prestamo(){
        this.cliente = "";
        this.monto_credito = "";
        this.interes = "";
        this.plazo = "";
        this.fecha_actual= "";
        this.fecha_final = "";
        this.monto_pagar = "";
        this.monto_cuota = "";
    }
}
