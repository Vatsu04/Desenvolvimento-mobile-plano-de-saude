package com.example.viva_bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View view) {
        EditText emailField = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordField = findViewById(R.id.editTextTextPassword);
        EditText phoneField = findViewById(R.id.editTextText);
        RadioGroup sexoField = findViewById(R.id.activity_sexo);
        EditText numeroCartaoField = findViewById(R.id.editTextTextNumCartao);
        EditText nomeTitularField = findViewById(R.id.editTextNomeTitular);
        EditText dataValidadeField = findViewById(R.id.editTextDataValidade);
        EditText cvField = findViewById(R.id.editTextCv);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        String phone = phoneField.getText().toString();

        int selectedSexoId = sexoField.getCheckedRadioButtonId();
        RadioButton selectedSexo = findViewById(selectedSexoId);
        String sexo = selectedSexo.getText().toString();

        String numeroCartao = numeroCartaoField.getText().toString();
        String nomeTitular = nomeTitularField.getText().toString();
        String dataValidade = dataValidadeField.getText().toString();
        String cv = cvField.getText().toString();

        Intent intent = new Intent(this, ConfirmarDadosActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("phone", phone);
        intent.putExtra("sexo", sexo);
        intent.putExtra("numeroCartao", numeroCartao);
        intent.putExtra("nomeTitular", nomeTitular);
        intent.putExtra("dataValidade", dataValidade);
        intent.putExtra("cv", cv);
        startActivity(intent);
    }
}
