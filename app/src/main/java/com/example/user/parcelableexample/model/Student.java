package com.example.user.parcelableexample.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by USER on 25.01.2018.
 */

@SuppressLint("ParcelCreator")
public class Student implements Parcelable {
    private String id;
    private String name;
    private String surName;
    private double number;

    public Student() {
    }

    // обычный конструктор
    public Student(String id, String name, String surName, double number) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "id:" + id + " " + "name:" + name + " " + "surName:" + surName + " " + "number:" + number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(surName);
        parcel.writeDouble(number);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {

        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    private Student(Parcel parcel) {
        id = parcel.readString();
        name = parcel.readString();
        surName = parcel.readString();
        number = parcel.readDouble();
    }
}
