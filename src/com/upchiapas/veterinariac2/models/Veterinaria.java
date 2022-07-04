package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Veterinaria {
    ArrayList<Cliente> listaClientes = new ArrayList();//Crea ArrayList para objetos
    ArrayList<Orden> compras = new ArrayList();

    public Veterinaria(ArrayList<Cliente> listaClientes, ArrayList<Orden> compras) {
        this.listaClientes = listaClientes;
        this.compras = compras;
    }

    public Veterinaria() {

    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Orden> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Orden> compras) {
        this.compras = compras;
    }
}
