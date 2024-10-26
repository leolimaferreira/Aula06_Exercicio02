/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula06_exercicio02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula06_exercicio02.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private Pessoa pessoa = new Pessoa();
    private EditText etCpf;
    private EditText etNome;
    private Button btnLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCpf = findViewById(R.id.etCpf);
        etNome = findViewById(R.id.etNome);
        btnLocal = findViewById(R.id.btnLocal);
        btnLocal.setOnClickListener(op -> calc());
    }

    private void calc() {
        pessoa.setCpf(etCpf.getText().toString());
        pessoa.setNome(etNome.getText().toString());

        String cpf = pessoa.getCpf();
        String nome = pessoa.getNome();

        Bundle bundle = new Bundle();
        bundle.putString("cpf", cpf);
        bundle.putString("nome", nome);

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, Saida.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}