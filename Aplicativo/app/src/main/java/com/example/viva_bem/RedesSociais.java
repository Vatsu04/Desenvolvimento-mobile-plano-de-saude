package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class RedesSociais extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redessociais);
        drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView22).setOnClickListener((view) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);

    }

    public void voltarParaSobre(View view){
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }


}
