package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private int milhas = 200;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



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

            if (id == R.id.nav_consulta) {
                navigateToAgendamentosActivity();
            } else if (id == R.id.nav_milhas) {
                navigateToMilhasActivity();
            } else if (id == R.id.nav_feedback) {
                navigateToFeedbackActivity();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


        ImageView imageView16 = findViewById(R.id.imageView16);
        imageView16.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START); // Open the navigation drawer
        });

        milhasTextView = findViewById(R.id.textView20);

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

    public void navigateToMilhasActivity() {
        Intent intent = new Intent(this, MilhasActivity.class);
        startActivity(intent);
    }

    public void navigateToAgendamentosActivity() {
        Intent intent = new Intent(this, AgendarConsultaActivity.class);
        startActivity(intent);
    }

    public void navigateToFeedbackActivity() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }
}
