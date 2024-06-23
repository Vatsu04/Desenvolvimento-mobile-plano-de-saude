package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private int milhas = 200;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        milhasTextView = findViewById(R.id.textView20);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }
        drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageView16).setOnClickListener((view) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });


        updateMilhasUI();
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    public void navigateToMilhasActivity() {
        Intent intent = new Intent(this, MilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateToAgendamentosActivity() {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateToFeedbackActivity() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
