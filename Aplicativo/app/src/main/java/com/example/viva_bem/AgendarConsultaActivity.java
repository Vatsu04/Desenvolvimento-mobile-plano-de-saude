package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class AgendarConsultaActivity extends AppCompatActivity {
    private int milhas;
    private TextView milhasTextView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

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

    public void navigateAgendamentoCepem(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "CEPEM");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoLabi(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Laboratórios Labi");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoFelippe(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Felippe Mattoso");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void navigateAgendamentoLamina(View view) {
        Intent intent = new Intent(this, AgendamentosActivity.class);
        intent.putExtra("CLINIC_NAME", "Clínica Lâmina");
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }


    public void navigateBack(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateFeedback(){
        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    private void navigateMilhas(){
        Intent intent = new Intent(this, MilhasActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
