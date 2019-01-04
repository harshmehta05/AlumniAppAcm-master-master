package com.imbuegen.alumniapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlumniActivity extends AppCompatActivity {

    //Displaying List of Alumnis

    ListView listViewAlumni;
    List<AlumniModel> AlumniModelList;

    String fbDeptKey ;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference deptRef ;//=database.getReference("Departments").child(fbDeptKey);
    //DatabaseReference companyRef = deptRef.child("Companies");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_list);



        Bundle gt=getIntent().getExtras();
        String str1=gt.getString("DeptName");
        String str2=gt.getString("CompName");


        AlumniModelList = new ArrayList<>();


        deptRef = database.getReference("Departments").child(str1);
        DatabaseReference companyRef = deptRef.child("Companies");
        DatabaseReference alumniref=companyRef.child(str2);
        DatabaseReference alumniref2=alumniref.child("Alumnis");

        setTitle(str2);



        alumniref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                AlumniModelList.clear();

                for (DataSnapshot alumniSnapshot : dataSnapshot.getChildren())
                {
                    String key = alumniSnapshot.getKey();
                    AlumniModel alumniModel = new AlumniModel(key);

                    AlumniModelList.add(alumniModel);
                }


                AlumniListAdapter adapter = new AlumniListAdapter(AlumniActivity.this,AlumniModelList);
                listViewAlumni.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
