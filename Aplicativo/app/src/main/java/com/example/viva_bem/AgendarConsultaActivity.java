package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AgendarConsultaActivity extends AppCompatActivity {
    private int milhas;
    private TextView milhasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);
        milhasTextView = findViewById(R.id.textView21);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    public void navigateBack() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}