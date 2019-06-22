package test.com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import test.com.example.myapplication.models.Pessoa;
import test.com.example.myapplication.R;
import test.com.example.myapplication.adapters.PessoaAdapter;
import test.com.example.myapplication.persistence.PessoasPersistence;

//OBJETIVO: Listar as pessoas cadastradas
public class ListaActivity extends AppCompatActivity {


    private Button btnVoltar;
    private RecyclerView listView;
    private PessoaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        realizarVinculos();
        configurarEventos();
        configuraLista();
    }

    //OBJETIVO: realizar vinculos dos componentes da tela
    private void realizarVinculos() {
        btnVoltar = findViewById(R.id.btnVoltar);
        listView = findViewById(R.id.listView);
    }

    //OBJETIVO: configurar eventos dos componentes
    private void configurarEventos() {
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarTelaCadastro();
            }
        });
    }

    //OBJETIVO: chama a tela de cadastro de pessoas e finaliza a tela atual
    private void chamarTelaCadastro(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    //OBJETIVO: configura a lista de pessoas
    private void configuraLista(){
        List<Pessoa> pessoas = new PessoasPersistence().getLista();
        adapter = new PessoaAdapter(this ,pessoas);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(adapter);
    }
}
