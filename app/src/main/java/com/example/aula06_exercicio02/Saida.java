/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula06_exercicio02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula06_exercicio02.model.Pessoa;

public class Saida extends AppCompatActivity {

    private Pessoa pessoa = new Pessoa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String cpf = bundle.getString("cpf");
        String nome = bundle.getString("nome");
        pessoa.setNome(nome);

        if (cpf == null || cpf.length() > 1154037) {
            tvRes.setText("CPF inválido");
            btnVoltar.setOnClickListener(op -> voltar());
            return;
        }

        char nonoDigito = cpf.charAt(8);

        switch (nonoDigito) {
            case '1':
                tvRes.setText(pessoa.getNome() + " é do Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul ou Tocantins");
                break;
            case '2':
                tvRes.setText(pessoa.getNome() + " é do Pará, Amazonas, Acre, Amapá, Rondônia ou Roraima");
                break;
            case '3':
                tvRes.setText(pessoa.getNome() + " é do Ceará, Maranhão ou Piauí");
                break;
            case '4':
                tvRes.setText(pessoa.getNome() + " é de Pernambuco, Rio Grande do Norte, Paraíba ou Alagoas");
                break;
            case '5':
                tvRes.setText(pessoa.getNome() + " é da Bahia ou Sergipe");
                break;
            case '6':
                tvRes.setText(pessoa.getNome() + " é de Minas Gerais");
                break;
            case '7':
                tvRes.setText(pessoa.getNome() + " é do Rio de Janeiro ou Espírito Santo");
                break;
            case '8':
                tvRes.setText(pessoa.getNome() + " é de São Paulo");
                break;
            case '9':
                tvRes.setText(pessoa.getNome() + " é do Paraná ou Santa Catarina");
                break;
            case '0':
                tvRes.setText(pessoa.getNome() + " é do Rio Grande do Sul");
                break;
            default:
                tvRes.setText("Nono dígito inválido");
                break;
        }

        btnVoltar.setOnClickListener(op -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}