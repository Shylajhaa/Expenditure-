package com.example.shylajhaa.expenditure;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    EditText uName;
    EditText password;
    Button loginButton;



    String userName;
    String passWord;




        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            uName = (EditText)findViewById(R.id.enterUname);
            password = (EditText)findViewById(R.id.enterPwd);
            loginButton = (Button)findViewById(R.id.loginGo);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    login();
                }
            });

        }

    public void login() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onLoginFailed();
            return;
        }
        else
        {
            userName = uName.getText().toString();
            Intent i = new Intent(LoginActivity.this,AfterLogin.class);
            i.putExtra("name",userName);
            //Toast.makeText(getBaseContext(), "Welcome "+userName, Toast.LENGTH_LONG).show();
            startActivity(i);
        }

        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.Theme_AppCompat);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Verifying...");
        progressDialog.show();

        userName = uName.getText().toString();
        passWord = password.getText().toString();



        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Cannot create account", Toast.LENGTH_LONG).show();
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        userName = uName.getText().toString();
        passWord = password.getText().toString();

        if (userName.isEmpty() || userName.length() < 3) {
            uName.setError("at least 3 characters");
            valid = false;
        } else {
            uName.setError(null);
        }

        if (passWord.isEmpty() || passWord.length() < 4 || passWord.length() > 10) {
            password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            password.setError(null);
        }
        return valid;
    }
    }
