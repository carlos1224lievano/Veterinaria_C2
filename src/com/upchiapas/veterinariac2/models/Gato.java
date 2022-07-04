package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Gato extends Mascota{
    public Gato(String nombre, String id, int edad, ArrayList<Servicio> listaServicios) {
        super(nombre, id, edad, listaServicios);
    }
}
