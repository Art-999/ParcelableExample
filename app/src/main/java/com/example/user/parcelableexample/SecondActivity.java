package com.example.user.parcelableexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.parcelableexample.model.Employe;
import com.example.user.parcelableexample.model.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private List<Student> datalist = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sovorakan parceleable-ov
//        Student recievedStudent = getIntent().getParcelableExtra(Student.class.getCanonicalName());
//        if (recievedStudent != null) {
////           datalist.add(recievedStudent);
//        }
//        Log.d("Art", recievedStudent.toString());

        //Gson-ov
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gsonObject = extras.getString(Student.class.getCanonicalName());
            Student student = recievedGsonParseToObject(gsonObject);
            Log.d("Art", student.toString());
        }

        //Gson-ov List
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String gsonObject = extras.getString(Employe.class.getCanonicalName());
//            List<Employe> dataList = recievedGsonParceToObject(gsonObject);
//            Log.d("Art", dataList.get(1).getName());
//        }

    }

    private Student recievedGsonParseToObject(String gsonObject) {
        Gson gson = new Gson();
        Student student = gson.fromJson(gsonObject, Student.class);
        return student;
    }

    private List<Employe> recievedGsonParceToObject(String gsonObject) {
        Gson gson = new Gson();
        Type listOfEmployeType = new TypeToken<List<Employe>>() {
        }.getType();
        List<Employe> datalist = gson.fromJson(gsonObject, listOfEmployeType);
        return datalist;
    }
}
