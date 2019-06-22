package test.com.example.myapplication.persistence;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {

    private static DAO instance;

    private DAO(Context context) {
        super(context, "cadastropessoas", null, 1);
    }

    public static void init(Context context) {
        instance = new DAO(context);
    }

    public static DAO getInstance() {
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        criaTabelaPessoas(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql = "DROP TABLE TEXTOS ";

        sqLiteDatabase.execSQL(sql);
        criaTabelaPessoas(sqLiteDatabase);
    }

    private void criaTabelaPessoas(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS PESSOAS (ID INTEGER, CPF TEXT, NOME TEXT, IDADE TEXT, EMAIL TEXT, TELEFONE TEXT) ";

        sqLiteDatabase.execSQL(sql);
    }


}