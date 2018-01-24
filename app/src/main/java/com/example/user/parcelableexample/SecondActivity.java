package com.example.user.parcelableexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.parcelableexample.model.Student;

import java.util.Collections;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private List<Student> datalist = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Student recievedStudent=getIntent().getParcelableExtra(Student.class.getCanonicalName());
        if(recievedStudent!=null){
//           datalist.add(recievedStudent);
        }
        Log.d("Art", recievedStudent.toString());
    }
}
