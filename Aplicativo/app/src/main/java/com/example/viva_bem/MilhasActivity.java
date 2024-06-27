package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MilhasActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private int milhas = 0;
    private TextView milhasTextView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milhas);

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

        milhasTextView = findViewById(R.id.textView21);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupButtonListeners() {
        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementMilhas(70);
            }
        });

        findViewById(R.id.button15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementMilhas(80);
            }
        });

        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementMilhas(100);
            }
        });

        findViewById(R.id.button16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementMilhas(20);
            }
        });
    }

    private void decrementMilhas(int cost) {
        if (milhas >= cost) {
            milhas -= cost;
            updateMilhasUI();
        } else {
            Toast.makeText(this, "Milhas insuficientes", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    public void voltarMenu(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToMilhasActivity() {
        Intent intent = new Intent(this, MilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToAgendamentosActivity() {
        Intent intent = new Intent(this, AgendarConsultaActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToFeedbackActivity() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

}
