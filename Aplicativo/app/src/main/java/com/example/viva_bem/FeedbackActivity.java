package com.example.viva_bem;// Import statements
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FeedbackActivity extends AppCompatActivity {

    private int milhas;
    private TextView milhasTextView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Button escreverFeedbackButton = findViewById(R.id.feedbackCepem);
        escreverFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity("Clínica CEPEM");
            }
        });

        Button escreverFeedbackButton2 = findViewById(R.id.feedbackLabi);
        escreverFeedbackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity("Laboratórios Labi");
            }
        });

        Button escreverFeedbackButton3 = findViewById(R.id.feedbackFelippe);
        escreverFeedbackButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity("Clínica Felippe Mattoso");
            }
        });

        Button escreverFeedbackButton4 = findViewById(R.id.feedbackLamina);
        escreverFeedbackButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity("Lamina");
            }
        });
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
            } else if (id == R.id.nav_menu) {
                navigateToMenuActivity();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


        ImageView imageView26 = findViewById(R.id.imageView26);
        imageView26.setOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START); // Open the navigation drawer
        });

        milhasTextView = findViewById(R.id.textView21);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();

    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
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

    private void navigateToMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateToEscreverFeedbackActivity(String clinicName) {
        Intent intent = new Intent(this, EscreverFeedbackActivity.class);
        intent.putExtra("CLINIC_NAME", clinicName);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navegarMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
