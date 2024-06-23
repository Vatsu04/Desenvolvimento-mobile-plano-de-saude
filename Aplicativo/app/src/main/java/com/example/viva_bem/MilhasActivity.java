package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MilhasActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private int milhas = 200;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milhas);

        drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView6).setOnClickListener((view) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        milhasTextView = findViewById(R.id.textView21);

        setupButtonListeners();
        updateMilhasUI();
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

    public void voltarMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

}
