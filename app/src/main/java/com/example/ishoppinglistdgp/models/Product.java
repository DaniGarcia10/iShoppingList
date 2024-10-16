package com.example.ishoppinglistdgp.models;

import android.widget.Switch;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String note;
    private boolean status;

    private boolean lactosa;

    private boolean gluten;

    // Constructor
    public Product(int id, String name, String note, boolean status, boolean lactosa, boolean gluten) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.status = status;
        this.lactosa = lactosa;
        this.gluten = gluten;
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

    public boolean isLactosa() {
        return lactosa;
    }

    public void setLactosa(boolean lactosa) {
        this.lactosa = lactosa;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    // toString
    @Override
    // Devuelve el nombre
    public String toString() {
        return name;
    }
}