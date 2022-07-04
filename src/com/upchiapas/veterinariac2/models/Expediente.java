package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;
import java.util.Iterator;

public class Expediente {
    ArrayList<Mascota> listaMascotas = new ArrayList(); //Mascota objMascota;

    public Expediente(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public void buscarExpediente(String id) {
        Iterator <Mascota> iterador = listaMascotas.iterator();
        Mascota masc;

        while (iterador.hasNext()) {
            masc = iterador.next();
            if (masc.getId().equals(id)) {
                System.out.println(masc.getId() + "\t-\t" + masc.getNombre());
                mostrarServicios(masc); //Metodo imprime lo que contien la lista de materias
            }
        }
    }
    public void mostrarServicios(Mascota masc){
        System.out.println("---------- Historial Medico ----------");
        for (int i=0; i<masc.getListaServicios().size(); i++) {
            System.out.println((i+1)+". "+masc.getListaServicios().get(i).getTipoServicio());
        }
    }

}
