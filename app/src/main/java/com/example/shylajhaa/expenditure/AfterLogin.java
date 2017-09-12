package com.example.shylajhaa.expenditure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_up);

        Bundle msg = getIntent().getExtras();
        String userName = msg.getString("name");

        Toast.makeText(getBaseContext(), "Welcome "+userName, Toast.LENGTH_LONG).show();

    }
}
