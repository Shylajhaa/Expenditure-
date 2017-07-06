package com.example.shylajhaa.expenditure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AfterSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_up);
        Toast.makeText(getBaseContext(), "Successfully Created", Toast.LENGTH_LONG).show();
    }
}
