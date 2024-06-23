package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EscreverFeedbackActivity extends AppCompatActivity {

    private int milhas;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_feedback);

        milhasTextView = findViewById(R.id.textView35);

        String clinicName = getIntent().getStringExtra("CLINIC_NAME");

        TextView clinicNameTextView = findViewById(R.id.clinicNameTextView);
        clinicNameTextView.setText(clinicName);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    private void incrementMilhasUI(){
        milhas += 300;
        updateMilhasUI();
    }

    public void navigateBack() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void enviarFeedback(){
        Intent intent = new Intent(this, MenuActivity.class);
        incrementMilhasUI();
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }


}
