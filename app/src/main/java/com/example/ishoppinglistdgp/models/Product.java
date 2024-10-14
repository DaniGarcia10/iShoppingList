package com.example.ishoppinglistdgp.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String note;
    private boolean status;

    // Constructor
    public Product(int id, String name, String note, boolean status) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.status = status;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // toString
    @Override
    // Devuelve el nombre
    public String toString() {
        return name;
    }
}