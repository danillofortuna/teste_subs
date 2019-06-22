package test.com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import test.com.example.myapplication.models.Pessoa;
import test.com.example.myapplication.R;
import test.com.example.myapplication.activities.VerPessoaActivity;
import test.com.example.myapplication.viewHolders.PessoaViewHolder;

//Adapter usado para listar as pessoas
public class PessoaAdapter  extends RecyclerView.Adapter<PessoaViewHolder>{

    private Context context;
    private List<Pessoa> pessoas;

    public PessoaAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }

    @Override
    public PessoaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pessoa, parent, false);
        PessoaViewHolder holder = new PessoaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PessoaViewHolder holder, final int position) {
        holder.nome.setText(pessoas.get(position).getNome());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarTelaVerPessoa(pessoas.get(position));
            }
        });
    }

    //Chama a tela de ver detalhes da pessoa selecionada
    private void chamarTelaVerPessoa(Pessoa pessoa) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pessoa", pessoa);
        Intent intent = new Intent(context, VerPessoaActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }
}
