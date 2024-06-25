package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView6).setOnClickListener((view) -> {
                drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
    }

    public void navigateLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void navigateAgendamentos(View view) {
        Intent intent = new Intent(this,  AgendamentosActivity.class);
        startActivity(intent);
    }

    public void navigateCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    public void navigateSobre(View view) {
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }

    public void navigateMissao(View view) {
        Intent intent = new Intent(this, MissaoActivity.class);
        startActivity(intent);
    }

    public void navigateProgamaMilhas(View view) {
        Intent intent = new Intent(this, ProgramaMilhasActivity.class);
        startActivity(intent);
    }

    public void navigateClientes(View view) {
        Intent intent = new Intent(this, ClienteActivity.class);
        startActivity(intent);
    }


    public static class LoginActivity extends AppCompatActivity {

        private DrawerLayout drawerLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            drawerLayout = findViewById(R.id.drawer_layout);

            findViewById(R.id.imageView6).setOnClickListener((view) -> {
                drawerLayout.openDrawer(GravityCompat.START);
            });

            NavigationView navigationView = findViewById(R.id.navigationView);
            navigationView.setItemIconTintList(null);
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
}
