package com.example.ishoppinglistdgp.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String nombre;
    private String notaInformativa;
    private boolean pending;

    public Product(int id, String nombre, String notaInformativa, boolean pending) {
        this.id = id;
        this.nombre = nombre;
        this.notaInformativa = notaInformativa;
        this.pending = pending;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaInformativa() {
        return notaInformativa;
    }

    public void setNotaInformativa(String notaInformativa) {
        this.notaInformativa = notaInformativa;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    // toString
    @Override
    public String toString() {
        return nombre;
    }
}