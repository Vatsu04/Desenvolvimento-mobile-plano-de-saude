package com.example.viva_bem;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerUtil extends AppCompatActivity {


    public static void openDrawer(Activity activity) {
        DrawerLayout drawerLayout = activity.findViewById(R.id.drawer_layout); // Replace with your drawer layout id
        drawerLayout.openDrawer(GravityCompat.START);
    }


}