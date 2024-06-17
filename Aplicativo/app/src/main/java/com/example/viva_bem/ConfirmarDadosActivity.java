package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_dados);

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewSenha = findViewById(R.id.textViewSenha);
        TextView textViewTelefone = findViewById(R.id.textViewTelefone);
        TextView textViewSexo = findViewById(R.id.textViewSexo);
        TextView textViewNumeroCartao = findViewById(R.id.textViewNumeroCartao);
        TextView textViewNomeTitular = findViewById(R.id.textViewNomeTitular);
        TextView textViewDataValidade = findViewById(R.id.textViewDataValidade);
        TextView textViewCv = findViewById(R.id.textViewCv);
        Button buttonConfirmar = findViewById(R.id.buttonConfirmar);

        // Retrieve data from intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String phone = intent.getStringExtra("phone");
        String sexo = intent.getStringExtra("sexo");
        String numeroCartao = intent.getStringExtra("numeroCartao");
        String nomeTitular = intent.getStringExtra("nomeTitular");
        String dataValidade = intent.getStringExtra("dataValidade");
        String cv = intent.getStringExtra("cv");

        // Display data in TextViews
        textViewEmail.setText(email);
        textViewSenha.setText(password);
        textViewTelefone.setText(phone);
        textViewSexo.setText(sexo);
        textViewNumeroCartao.setText(numeroCartao);
        textViewNomeTitular.setText(nomeTitular);
        textViewDataValidade.setText(dataValidade);
        textViewCv.setText(cv);

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConfirmarDadosActivity.this, "Dados Corretos!", Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(ConfirmarDadosActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}
