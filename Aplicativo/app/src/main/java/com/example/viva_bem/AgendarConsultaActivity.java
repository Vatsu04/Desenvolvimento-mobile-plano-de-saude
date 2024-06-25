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
        setContentView(R.layout.activity_agendar_consulta);
        milhasTextView = findViewById(R.id.textView35);

        Intent intent = getIntent();
        if (intent.hasExtra("milhas")) {
            milhas = intent.getIntExtra("milhas", 0);
        }

        updateMilhasUI();
    }

    private void updateMilhasUI() {
        milhasTextView.setText(String.valueOf(milhas));
    }

    public void navigateAgendamentoCepem() {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "CEPEM");
        startActivity(intent);
    }

    public void navigateAgendamentoLabi() {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Laboratórios Labi");
        startActivity(intent);
    }

    public void navigateAgendamentoFelippe() {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Felippe Mattoso");
        startActivity(intent);
    }

    public void navigateAgendamentoLamina() {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Lâmina");
        startActivity(intent);
    }


    public void navigateBack() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
