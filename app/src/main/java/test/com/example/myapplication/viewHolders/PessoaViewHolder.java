package test.com.example.myapplication.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import test.com.example.myapplication.R;


//VIEW HOLDER USADO NO ADAPTER DO RECYCLERVIEW
public class PessoaViewHolder extends RecyclerView.ViewHolder {

    public final TextView nome;

    public PessoaViewHolder(View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.txtNome);
    }
}
