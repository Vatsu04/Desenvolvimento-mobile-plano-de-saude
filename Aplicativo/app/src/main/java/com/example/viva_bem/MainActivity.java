package com.example.viva_bem;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            drawerLayout.closeDrawers();
            return true;
        });

        ImageView imageView16 = findViewById(R.id.imageView25);
        imageView16.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START); // Open the navigation drawer
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
         startActivity(intent);
    }

    private void navigateCadastro() {

         Intent intent = new Intent(this, CadastroActivity.class);
         startActivity(intent);
    }

    private void navigateLogin() {

         Intent intent = new Intent(this, LoginActivity.class);
         startActivity(intent);
    }

    private void navigateClientes() {

         Intent intent = new Intent(this, ClienteActivity.class);
         startActivity(intent);
    }

    private void navigateAgendamentosInfo() {

         Intent intent = new Intent(this, AgendamentosInfoActivity.class);
         startActivity(intent);
    }

    private void navigateProgramaMilhas() {

         Intent intent = new Intent(this, ProgramaMilhasActivity.class);
         startActivity(intent);
    }

    private void navigateMissao() {

         Intent intent = new Intent(this, MissaoActivity.class);
         startActivity(intent);
    }

    private void navigateSobre() {

         Intent intent = new Intent(this, SobreActivity.class);
         startActivity(intent);
    }

    public void irParaCadastro(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    public void irParaLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
