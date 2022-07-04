package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Hamster extends Mascota{
    public Hamster(String nombre, String id, int edad, ArrayList<Servicio> listaServicios) {
        super(nombre, id, edad, listaServicios);
    }
}
