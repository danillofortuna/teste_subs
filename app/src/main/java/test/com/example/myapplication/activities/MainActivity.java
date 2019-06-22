package test.com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.com.example.myapplication.R;
import test.com.example.myapplication.persistence.DAO;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplin :  M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno : José Carlos da Costa Júnior
//******************************************************

public class MainActivity extends AppCompatActivity {

    private Button btnInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO.init(this);

        realizaVinculos();
        configuraEventos();

    }

    //OBJETIVO: cria os eventos dos componentes da tela
    private void configuraEventos() {
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarTelaCadastro();
            }
        });
    }

    //OBJETIVO: faz os vínculos dos componentes com os objetos da classe
    private void realizaVinculos() {
        btnInserir = findViewById(R.id.btnInserir);
    }


    //OBJETIVO: chama a tela de cadastro de pessoas e finaliza a tela atual
    private void chamarTelaCadastro(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}
