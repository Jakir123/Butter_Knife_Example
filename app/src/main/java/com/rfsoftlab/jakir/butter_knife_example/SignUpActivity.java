package com.rfsoftlab.jakir.butter_knife_example;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etEmail)
    EditText etEmail;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btnSignUp)
    Button btnSignUp;
    @Bind(R.id.tvLogIn)
    TextView tvLogIn;

    @Bind(R.id.inputLayoutName)
    TextInputLayout inputLayoutName;
    @Bind(R.id.inputLayoutEmail)
    TextInputLayout inputLayoutEmail;
    @Bind(R.id.inputLayoutPassword)
    TextInputLayout inputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnSignUp)
    public void btnSignUpClicked() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().toLowerCase().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() && password.isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content), "You Have To Fill All Field!!", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Sign Up Successful!!", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.GREEN)
                    .show();
        }
    }

    @OnClick(R.id.tvLogIn)
    public void btnLogInClicked() {
        Intent gotoLogInPage = new Intent(SignUpActivity.this, LogInActivity.class);
        gotoLogInPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(gotoLogInPage);
        finish();
    }


}
