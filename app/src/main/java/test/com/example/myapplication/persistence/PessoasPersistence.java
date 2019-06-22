package test.com.example.myapplication.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import test.com.example.myapplication.models.Pessoa;

public class PessoasPersistence {

    //OBJETIVO: Pega o maior ID cadastrado no banco e adiciona 1 para pegar o próximo ID disponível
    public int next(){
        SQLiteDatabase database = DAO.getInstance().getReadableDatabase();
        String select = "SELECT MAX(ID)+1 ID FROM PESSOAS";
        Cursor c = database.rawQuery(select, new String[]{});
        int ret = 1;
        if(c.moveToFirst()){
            ret = c.getInt(c.getColumnIndex("ID"));
        }
        c.close();
        return ret;
    }

    //OBJETIVO: Pega a lista de pessoas cadastradas no banco
    public List<Pessoa> getLista(){
        SQLiteDatabase database = DAO.getInstance().getReadableDatabase();
        String select = "SELECT * FROM PESSOAS";
        Cursor c = database.rawQuery(select, new String[]{});
        List<Pessoa> list = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Pessoa pessoa = new Pessoa();
                pessoa.setId(c.getInt(c.getColumnIndex("ID")));
                pessoa.setNome(c.getString(c.getColumnIndex("NOME")));
                pessoa.setCpf(c.getString(c.getColumnIndex("CPF")));
                pessoa.setTelefone(c.getString(c.getColumnIndex("TELEFONE")));
                pessoa.setEmail(c.getString(c.getColumnIndex("EMAIL")));
                pessoa.setIdade(c.getString(c.getColumnIndex("IDADE")));
                list.add(pessoa);
            }while (c.moveToNext());
        }
        c.close();
        return list;
    }

    //OBJETIVO: Salva a pessoa no banco
    public void salvar(Pessoa pessoa){
        SQLiteDatabase database = DAO.getInstance().getWritableDatabase();
        String sql = "INSERT INTO PESSOAS(ID, NOME, CPF, EMAIL, TELEFONE, IDADE) VALUES(?, ?, ?, ?, ?, ?)";
        pessoa.setId(next());
        database.execSQL(sql, new String[]{String.valueOf(next()), pessoa.getNome(), pessoa.getCpf(), pessoa.getEmail(), pessoa.getTelefone(), pessoa.getIdade()});
    }
}
