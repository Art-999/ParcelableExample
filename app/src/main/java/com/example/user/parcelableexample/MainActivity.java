package com.example.user.parcelableexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.parcelableexample.model.Employe;
import com.example.user.parcelableexample.model.Student;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nextActivityBtn;
    private ArrayList<Employe> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextActivityBtn = findViewById(R.id.next_activity_btn);
        datalist = new ArrayList<>();
        initializeDataList();
        nextActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_activity_btn:
                //sendObjectData();
                sendObjectViaGson();
                //sendListObjectViaGson();
                break;
        }
    }

    public void sendObjectData() {
//        Student currentStudent=datalist.get(0);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Student.class.getCanonicalName(), new Student("1", "Artur", "Musayelyan", 077117030d));
        startActivity(intent);
    }

    public void sendObjectViaGson() {
        Gson gson = new Gson();
        Student student = new Student("1", "Artur", "Musayelyan", 077117030d);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Student.class.getCanonicalName(), gson.toJson(student));
        startActivity(intent);
    }

    public void sendListObjectViaGson() {
        //Liste xorhurd chi trvum poxancel vorovhetev inch vor limit goyutyun uni ev karox e qrash linel
        Gson gson = new Gson();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Employe.class.getCanonicalName(), gson.toJson(datalist));
        startActivity(intent);
    }

    private void initializeDataList() {
        datalist.add(new Employe("1", "Artur", "Musayelyan", 077117030d));
        datalist.add(new Employe("2", "Armen", "Karapetyan", 077988556d));
        datalist.add(new Employe("3", "Hrant", "Firdusyan", 096867885d));
        datalist.add(new Employe("4", "Ohan", "Titanyan", 096457889d));
        datalist.add(new Employe("5", "Petros", "Hayrapetyan", 091111211d));
    }
}
