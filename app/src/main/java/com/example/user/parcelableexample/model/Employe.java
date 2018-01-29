package com.example.user.parcelableexample.model;

import java.util.ArrayList;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class Employe extends ArrayList<Employe> {
    private String ID;
    private String name;
    private String surName;
    private double number;

    public Employe() {

    }

    public Employe(String ID, String name, String surName, double number) {
        this.ID = ID;
        this.name = name;
        this.surName = surName;
        this.number = number;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ID:" + ID + " name:" + name + " surname:" + surName + " number:" + number;
    }


}
