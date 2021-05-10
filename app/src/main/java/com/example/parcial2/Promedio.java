package com.example.parcial2;

public class Promedio {
    public int id;
    public String titulo;
    public int imagenKilometros;
    public String kilometros;
    public int imagenCostos;
    public String costos;

    public Promedio(int id, String titulo, int imagenKilometros, String kilometros, int imagenCostos, String costos) {
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

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public int getImagenCostos() {
        return imagenCostos;
    }

    public void setImagenCostos(int imagenCostos) {
        this.imagenCostos = imagenCostos;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }
}
