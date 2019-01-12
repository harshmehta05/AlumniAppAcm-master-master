package com.imbuegen.alumniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        Intent intent1 = new Intent(MainActivity.this, DepartmentsActivity.class);
        Intent intent2 = new Intent(MainActivity.this, RegistrationActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if(currentUser!=null)
            startActivity(intent1);
        else
            startActivity(intent2);
        finish();
    }
}
