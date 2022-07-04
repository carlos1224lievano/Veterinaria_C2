package com.upchiapas.veterinariac2.models;

public class Servicio {
    String tipoServicio;
    int precio;

    public Servicio(String tipoServicio, int precio) {
        this.tipoServicio = tipoServicio;
        this.precio = precio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
