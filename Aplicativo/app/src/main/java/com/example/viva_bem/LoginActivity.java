package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        EditText emailField = findViewById(R.id.editTextText3);
        EditText passwordField = findViewById(R.id.editTextTextPassword2);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        Toast.makeText(this, "Login Confirmado!", Toast.LENGTH_SHORT).show();
        Intent mainIntent = new Intent(this, MenuActivity.class);

    }

    public void navigateMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}