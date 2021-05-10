package com.example.parcial2;

public class Promedio {
    public int id;
    public String titulo;
    public int imagenKilometros;
    public Double kilometros;
    public int imagenCostos;
    public Double costos;

    public Promedio(int id, String titulo, int imagenKilometros, Double kilometros, int imagenCostos, Double costos) {
        this.id = id;
        this.titulo = titulo;
        this.imagenKilometros = imagenKilometros;
        this.kilometros = kilometros;
        this.imagenCostos = imagenCostos;
        this.costos = costos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagenKilometros() {
        return imagenKilometros;
    }

    public void setImagenKilometros(int imagenKilometros) {
        this.imagenKilometros = imagenKilometros;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(Double  kilometros) {
        this.kilometros = kilometros;
    }

    public int getImagenCostos() {
        return imagenCostos;
    }

    public void setImagenCostos(int imagenCostos) {
        this.imagenCostos = imagenCostos;
    }

    public double getCostos() {
        return costos;
    }

    public void setCostos(Double costos) {
        this.costos = costos;
    }
}
