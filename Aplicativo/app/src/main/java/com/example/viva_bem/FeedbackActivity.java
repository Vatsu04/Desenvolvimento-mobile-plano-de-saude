package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private int milhas;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        milhasTextView = findViewById(R.id.textView21);

        // Retrieve milhas from intent if available
        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();

        Button escreverFeedbackButton = findViewById(R.id.feedbackCepem);
        escreverFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity();
            }
        });

        Button escreverFeedbackButton2 = findViewById(R.id.buttonEscreverFeedback);
        escreverFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity();
            }
        });

        Button escreverFeedbackButton3 = findViewById(R.id.buttonEscreverFeedback);
        escreverFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity();
            }
        });

        Button escreverFeedbackButton4 = findViewById(R.id.buttonEscreverFeedback);
        escreverFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEscreverFeedbackActivity();
            }
        });
    }



    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    public void navigateToEscreverFeedbackActivity() {
        Intent intent = new Intent(this, EscreverFeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateBack() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
