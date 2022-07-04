package com.upchiapas.veterinariac2.models;

public class Producto {
    String nombre;// ,folio
    int precio,cantidad; //Para calcular subtotal de productos seria: En el for en la posicion .get(i) para .getPrecio y .getCantidad
    //que se van a multiplicar, ese resultado se guarda en subtotalP, para que totalP += subtotalP en cada vuelta

    public Producto(String nombre, int precio,int cantidad) {
        this.nombre = nombre;
        //this.folio = folio;
        this.precio = precio;
        this.cantidad=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
