package com.example.parcial2;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Registro {

    @PrimaryKey(autoGenerate = true)
    int idFactura;

    @ColumnInfo(name="NumeroFactura")
    int numeroFac;

    @ColumnInfo(name="Fecha")
    String fecha;

    @ColumnInfo(name="tipoCom")
    String tipoCom;

    @ColumnInfo(name="MontoCom")
    double montoCom;

    @ColumnInfo(name = "ktm")
    int ktm;

    public Registro(int numeroFac, String fecha, String tipoCom, double montoCom, int ktm) {
        this.numeroFac = numeroFac;
        this.fecha = fecha;
        this.tipoCom = tipoCom;
        this.montoCom = montoCom;
        this.ktm = ktm;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFac() {
        return numeroFac;
    }

    public void setNumeroFac(int numeroFac) {
        this.numeroFac = numeroFac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCom() {
        return tipoCom;
    }

    public void setTipoCom(String tipoCom) {
        this.tipoCom = tipoCom;
    }

    public double getMontoCom() {
        return montoCom;
    }

    public void setMontoCom(double montoCom) {
        this.montoCom = montoCom;
    }

    public int getKtm() {
        return ktm;
    }

    public void setKtm(int ktm) {
        this.ktm = ktm;
    }
}
