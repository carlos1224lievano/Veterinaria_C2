package com.upchiapas.veterinariac2.models;

import java.util.ArrayList;

public class Orden {
    Cliente cliente;
    ArrayList<Servicio> listaServicios = new ArrayList();//Crea ArrayList para objetos
    ArrayList<Producto> listaProductos = new ArrayList();//Crea ArrayList para objetos

    public Orden(ArrayList<Servicio> listaServicios, ArrayList<Producto> listaProductos) {
        this.listaServicios = listaServicios;
        this.listaProductos = listaProductos;
    }

    public Orden() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }


    public void calcularTotalServicios(){
        int subTotalS,totalS = 0;
        for(int i=0; i<listaServicios.size(); i++){
            totalS += listaServicios.get(i).getPrecio();
        }
        mostrarTicketServicios(totalS);
    }
    public void mostrarTicketServicios(int totalS){
        System.out.println("------------- TICKET -------------");
        System.out.println("\t\tCliente: "+cliente.getNombre());
        System.out.println("Servicio:\t\t\tCosto:");
        for (int i=0; i<listaServicios.size(); i++) {
            System.out.println(listaServicios.get(i).getTipoServicio()+" --- $"+listaServicios.get(i).getPrecio()+".00");
        }
        System.out.println("\t\t\tTotal a Pagar: $"+totalS+".00");
    }

    public void calcularTotalProductos(){
        int subTotalP,totalP = 0;
        for(int i=0; i<listaProductos.size(); i++){
            subTotalP = (listaProductos.get(i).getPrecio() * listaProductos.get(i).getCantidad());
            totalP += subTotalP;
        }
        mostrarTicketProductos(totalP);
    }
    public void mostrarTicketProductos(int totalP){
        System.out.println("--------------- TICKET ---------------");
        System.out.println("Producto:\t\t\tCosto:\t\t\t\tCantidad:");
        for (int i=0; i<listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i).getNombre()+" --- $"+listaProductos.get(i).getPrecio()+".00\t-----\t"+listaProductos.get(i).getCantidad());
        }
        System.out.println("\t\t\t\tTotal a Pagar: $"+totalP+".00");
        listaProductos.clear();
    }
}
