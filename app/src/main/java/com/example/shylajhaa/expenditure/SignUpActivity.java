package com.example.shylajhaa.expenditure;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button signupButton;



    String fname;
    String lname;
    String emailID;
    String passWord;
    String conPassWord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName = (EditText)findViewById(R.id.fName);
        lastName = (EditText)findViewById(R.id.lName);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pwd);
        confirmPassword = (EditText)findViewById(R.id.conPwd);
        signupButton = (Button) findViewById(R.id.signUp);



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
        else
        {
            Toast.makeText(getBaseContext(), "Successfully Created", Toast.LENGTH_LONG).show();
            Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
            startActivity(i);
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this,
                R.style.Theme_AppCompat);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        fname = firstName.getText().toString();
        lname = lastName.getText().toString();
        emailID = email.getText().toString();
        passWord = password.getText().toString();
        conPassWord = confirmPassword.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Cannot create account", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        fname = firstName.getText().toString();
        lname = lastName.getText().toString();
        emailID = email.getText().toString();
        passWord = password.getText().toString();
        conPassWord = confirmPassword.getText().toString();

        if (fname.isEmpty() || fname.length() < 3) {
            firstName.setError("at least 3 characters");
            valid = false;
        } else {
            firstName.setError(null);
        }
        if (lname.isEmpty() || lname.length() < 3) {
            lastName.setError("at least 3 characters");
            valid = false;
        } else {
            lastName.setError(null);
        }

        if (emailID.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailID).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        if (passWord.isEmpty() || passWord.length() < 4 || passWord.length() > 10) {
            password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            password.setError(null);
        }
        if(!passWord.equals(conPassWord))
        {
            confirmPassword.setError("Passwords don't match");
            valid = false;
        }
        else
        {
            confirmPassword.setError(null);
        }
        return valid;
    }
}

