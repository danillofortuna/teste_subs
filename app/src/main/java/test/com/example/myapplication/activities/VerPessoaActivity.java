package test.com.example.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.com.example.myapplication.models.Pessoa;
import test.com.example.myapplication.R;

//OBJETIVO: Tela para ver os detalhes das pessoas selecionadas na listagem
public class VerPessoaActivity extends AppCompatActivity {

    private Button btnVoltar;
    private EditText edtNome;
    private EditText edtCPF;
    private EditText edtTelefone;
    private EditText edtIdade;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pessoa);

        realizarVinculos();
        configurarEventos();
        carregaInformacoes();
    }

    //OBJETIVO: carrega informacoes da pessoa selecionada
    private void carregaInformacoes() {
        Pessoa pessoa = (Pessoa) getIntent().getExtras().getSerializable("pessoa");
        edtNome.setText(pessoa.getNome());
        edtEmail.setText(pessoa.getEmail());
        edtTelefone.setText(pessoa.getTelefone());
        edtIdade.setText(pessoa.getIdade());
        edtCPF.setText(pessoa.getCpf());
    }

    //OBJETIVO: confiugra os eventos dos componentes
    private void configurarEventos() {

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OBJETIVO: fecha a tela atual
                VerPessoaActivity.this.finish();
            }
        });
    }

    //OBJETIVO: realiza os vinculos dos componentes
    private void realizarVinculos() {
        btnVoltar = findViewById(R.id.btnVoltar);

        edtNome = findViewById(R.id.edtNome);
        edtCPF = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtIdade = findViewById(R.id.edtIdade);
        edtEmail = findViewById(R.id.edtEmail);
    }
}
