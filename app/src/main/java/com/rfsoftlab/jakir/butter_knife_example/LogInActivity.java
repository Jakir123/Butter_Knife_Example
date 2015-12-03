package com.rfsoftlab.jakir.butter_knife_example;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogInActivity extends AppCompatActivity {
    @Bind(R.id.etEmailInLogIn)
    EditText etEmail;
    @Bind(R.id.etPasswordInLogIn)
    EditText etPassword;
    @Bind(R.id.tvSignUp)
    TextView tvSignUp;
    @Bind(R.id.btnLogIn)
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarInLogIn);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogIn)
    public void btnLogInClicked() {

        String email = etEmail.getText().toString().toLowerCase().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() && password.isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content), "You Have To Enter Your Email And Password!!", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Log In Successful", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.GREEN)
                    .show();
            Toast.makeText(LogInActivity.this, "Email: "+email, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.tvSignUp)
    public void tvSignUpClicked() {
        Intent gotoSignUpPage = new Intent(this, SignUpActivity.class);
        gotoSignUpPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(gotoSignUpPage);

    }

}
