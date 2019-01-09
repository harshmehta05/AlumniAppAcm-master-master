package com.imbuegen.alumniapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.imbuegen.alumniapp.Adapters.QuestionsAdapter;
import com.imbuegen.alumniapp.Models.AlumniModel;


public class AlumniInfoActivity extends AppCompatActivity {

    public static final String ALUMNI_OBJ = "qwe";






    TextView nameTextView;
    TextView positionTextView;
    TextView dateJoinTextView;
    TextView companyTextView;

    ListView questionsListView;
    QuestionsAdapter adapter;


    AlumniModel mAlumni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_info);


        nameTextView = findViewById(R.id.alumniName_tv);
        positionTextView = findViewById(R.id.position_tv);
        dateJoinTextView = findViewById(R.id.date_join_tv);
        companyTextView =  findViewById(R.id.companyName_tv);

        questionsListView = findViewById(R.id.list);


        mAlumni = (AlumniModel) getIntent().getSerializableExtra(ALUMNI_OBJ);
        nameTextView.setText(mAlumni.getAlumniName());
        companyTextView.setText(mAlumni.getCompany());
        positionTextView.setText(mAlumni.getPosition());
        dateJoinTextView.setText("Member Since: "+mAlumni.getJoinDate());

        adapter = new QuestionsAdapter(mAlumni.getQuestionsList(),getApplicationContext());

        questionsListView.setAdapter(adapter);



    }
}
