package com.example.viva_bem;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerUtil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.menu.navigation_menu);
    }

    public static void openDrawer(Activity activity) {
        DrawerLayout drawerLayout = activity.findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(GravityCompat.START);
    }


}