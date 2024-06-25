package com.example.viva_bem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ContatoActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_contato);
        drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView22).setOnClickListener((view) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);

    }

}