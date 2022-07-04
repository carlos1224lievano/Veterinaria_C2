package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Perro extends Mascota{
    public Perro(String nombre, String id, int edad, ArrayList<Servicio> listaServicios) {
        super(nombre, id, edad, listaServicios);
    }
}
