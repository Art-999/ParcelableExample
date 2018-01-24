package com.example.user.parcelableexample;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.parcelableexample.model.Student;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nextActivityBtn;
    private List<Student> datalist = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextActivityBtn = findViewById(R.id.next_activity_btn);
       // initializeDataList();
        nextActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_activity_btn:
                sendObjectData();
                break;
        }
    }

    public void sendObjectData() {
//        Student currentStudent=datalist.get(0);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Student.class.getCanonicalName(), new Student("1", "Artur", "Musayelyan", 077117030d));
        startActivity(intent);
    }

    private void initializeDataList() {
        datalist.add(new Student("1", "Artur", "Musayelyan", 077117030d));
        datalist.add(new Student("2", "Armen", "Karapetyan", 077988556d));
        datalist.add(new Student("3", "Hrant", "Firdusyan", 096867885d));
        datalist.add(new Student("4", "Ohan", "Titanyan", 096457889d));
        datalist.add(new Student("5", "Petros", "Hayrapetyan", 091111211d));
    }
}
