package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_dados);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String phone = intent.getStringExtra("phone");
        String sexo = intent.getStringExtra("sexo");
        String numeroCartao = intent.getStringExtra("numeroCartao");
        String nomeTitular = intent.getStringExtra("nomeTitular");
        String dataValidade = intent.getStringExtra("dataValidade");
        String cv = intent.getStringExtra("cv");

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(email);

        TextView textViewSenha = findViewById(R.id.textViewSenha);
        textViewSenha.setText(password);

        TextView textViewTelefone = findViewById(R.id.textViewTelefone);
        textViewTelefone.setText(phone);

        TextView textViewSexo = findViewById(R.id.textViewSexo);
        textViewSexo.setText(sexo);

        TextView textViewNumeroCartao = findViewById(R.id.textViewNumeroCartao);
        textViewNumeroCartao.setText(numeroCartao);

        TextView textViewNomeTitular = findViewById(R.id.textViewNomeTitular);
        textViewNomeTitular.setText(nomeTitular);

        TextView textViewDataValidade = findViewById(R.id.textViewDataValidade);
        textViewDataValidade.setText(dataValidade);

        TextView textViewCv = findViewById(R.id.textViewCv);
        textViewCv.setText(cv);
    }

    public void confirmarDados(View view) {
        Toast.makeText(this, "Cadastro Confirmado!", Toast.LENGTH_SHORT).show();
        Intent mainIntent = new Intent(this, MenuActivity.class);
        startActivity(mainIntent);
        finish();
    }

    public void voltarParaCadastro(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
