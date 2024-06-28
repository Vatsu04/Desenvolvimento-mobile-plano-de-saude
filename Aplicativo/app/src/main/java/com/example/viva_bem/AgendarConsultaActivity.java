package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AgendarConsultaActivity extends AppCompatActivity {
    private int milhas;
    private TextView milhasTextView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_consulta);
        milhasTextView = findViewById(R.id.textView35);

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

            if (id == R.id.nav_menu) {
                navigateToMenuActivity();
            } else if (id == R.id.nav_milhas) {
                navigateToMilhasActivity();
            } else if (id == R.id.nav_feedback) {
                navigateToFeedbackActivity();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


        ImageView imageView27 = findViewById(R.id.imageView27);
        imageView27.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START); // Open the navigation drawer
        });

        milhasTextView = findViewById(R.id.textView35);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navigateToMilhasActivity() {
        Intent intent = new Intent(this, MilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToFeedbackActivity() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoCepem(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "CEPEM");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoLabi(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Laboratórios Labi");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoFelippe(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Felippe Mattoso");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoLamina(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Lâmina");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }


    public void navigateBack(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateFeedback(){
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateMilhas(){
        Intent intent = new Intent(this, MilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
