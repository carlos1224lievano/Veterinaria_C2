package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Cliente {
    String nombre;
    ArrayList<Mascota> listaMascotas = new ArrayList();//Crea ArrayList para objetos

    public Cliente(String nombre, ArrayList<Mascota> listaMascotas) {
        this.nombre = nombre;
        this.listaMascotas = listaMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}
