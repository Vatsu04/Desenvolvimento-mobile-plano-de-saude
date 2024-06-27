package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        milhas += 400;
        updateMilhasUI();
    }

    public void escreverFeedbackParaMain(View view) {
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void enviarFeedback(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        incrementMilhasUI();
        Toast.makeText(this, "Obrigado pelo seu feedback!", Toast.LENGTH_SHORT).show();
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }


}
