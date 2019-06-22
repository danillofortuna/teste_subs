package test.com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.com.example.myapplication.models.Pessoa;
import test.com.example.myapplication.R;
import test.com.example.myapplication.persistence.PessoasPersistence;

//OBJETIVO: Tela para cadastrar as pessoas
public class SecondActivity extends AppCompatActivity {

    private Button btnInserir;
    private Button btnListar;
    private Button btnVoltar;
    private EditText edtNome;
    private EditText edtCPF;
    private EditText edtTelefone;
    private EditText edtIdade;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        realizarVinculos();

        configurarEventos();

    }

    //OBJETIVO: confiugra os eventos dos componentes
    private void configurarEventos() {
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirDados();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarTelaListagem();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarTelaInicial();
            }
        });
    }

    //OBJETIVO: realiza os vinculos dos componentes
    private void realizarVinculos() {
        btnInserir = findViewById(R.id.btnInserir);
        btnListar = findViewById(R.id.btnListar);
        btnVoltar = findViewById(R.id.btnVoltar);

        edtNome = findViewById(R.id.edtNome);
        edtCPF = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtIdade = findViewById(R.id.edtIdade);
        edtEmail = findViewById(R.id.edtEmail);
    }

    //OBJETIVO: Chamar a tela de Listagem e finalizar a tela atual
    private void chamarTelaListagem() {
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
        finish();
    }

    //OBJETIVO: montar o objeto Pessoa e chamar o método que grava no banco
    private void inserirDados() {

        if(edtNome.getText().toString().equals("")){
            Toast.makeText(this, "Necessário informar o nome", Toast.LENGTH_SHORT).show();
            return;
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(edtNome.getText().toString());
        pessoa.setCpf(edtCPF.getText().toString());
        pessoa.setIdade(edtIdade.getText().toString());
        pessoa.setTelefone(edtTelefone.getText().toString());
        pessoa.setEmail(edtEmail.getText().toString());

        new PessoasPersistence().salvar(pessoa);
        Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        limparCampos();
    }

    //OBJETIVO: Limpa os campos da tela
    private void limparCampos() {
        edtNome.setText("");
        edtCPF.setText("");
        edtIdade.setText("");
        edtEmail.setText("");
        edtTelefone.setText("");
    }


    //OBJETIVO: Chamar a tela inicial e finalizar a tela atual
    private void chamarTelaInicial(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
