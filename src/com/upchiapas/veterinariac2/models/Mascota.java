package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Mascota {
    String nombre,id;
    int edad;
    ArrayList<Servicio> listaServicios = new ArrayList();

    public Mascota(String nombre, String id, int edad, ArrayList<Servicio> listaServicios) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.listaServicios = listaServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }
}
