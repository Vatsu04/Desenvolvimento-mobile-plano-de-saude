package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class AgendamentosActivity extends AppCompatActivity {

    private int milhas = 0;

    private TextView milhasTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);


        milhasTextView = findViewById(R.id.textView38);

        String clinicName = getIntent().getStringExtra("CLINIC_NAME");

        TextView clinicNameTextView = findViewById(R.id.textView39);
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

    public void voltarDeAgendamentosParaAgendarConsulta(View view){
        Intent intent = new Intent(this, AgendarConsultaActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }

    public void agendarConsulta(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("milhas", milhas);
        startActivity(intent);
    }
}
