package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AgendamentosInfoActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private int milhas = 0;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agendamentos_info);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                navigateMain();
            } else if (id == R.id.nav_cad) {
                navigateCadastro();
            } else if (id == R.id.nav_log) {
                navigateLogin();
            } else if (id == R.id.nav_clientes) {
                navigateClientes();
            } else if (id == R.id.nav_agendamentos) {
                navigateAgendamentosInfo();
            } else if (id == R.id.nav_programa_milhas) {
                navigateProgramaMilhas();
            } else if (id == R.id.nav_missao) {
                navigateMissao();
            } else if (id == R.id.nav_sobre) {
                navigateSobre();
            }

            drawerLayout.closeDrawers(); // Fechar o Navigation Drawer após a seleção
            return true;
        });


        ImageView imageView16 = findViewById(R.id.imageView6);
        imageView16.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navigateMain() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateCadastro() {

        Intent intent = new Intent(this, CadastroActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateClientes() {

        Intent intent = new Intent(this, ClienteActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateAgendamentosInfo() {

        Intent intent = new Intent(this, AgendamentosInfoActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateProgramaMilhas() {

        Intent intent = new Intent(this, ProgramaMilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateMissao() {

        Intent intent = new Intent(this, MissaoActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateSobre() {

        Intent intent = new Intent(this, SobreActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
