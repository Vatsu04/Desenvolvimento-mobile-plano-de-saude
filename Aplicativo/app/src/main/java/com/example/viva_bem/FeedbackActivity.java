package com.example.viva_bem;// Import statements
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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
    }

    private void navigateToEscreverFeedbackActivity(String clinicName) {
        Intent intent = new Intent(this, EscreverFeedbackActivity.class);
        intent.putExtra("CLINIC_NAME", clinicName);
        startActivity(intent);
    }

    public void navegarMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
