package com.example.leandroqtrepador.todo.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//cria uma classe CriaBanco que herda da classe SQLiteOpenHelper
public class CriaBanco extends SQLiteOpenHelper {

    //Definição das constantes para nomes do banco, tabela e colunas
    private static final String NOME_BD = "banco.bd";
    private static final String TABELA = "tarefa";
    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final int VERSAO = 1;

    //Construtor da classe que recebe como parametro o contexto
    //Deve ser criado dessa forma pois a classe CriaBanco herda da classe SQLiteOpenHelper
    public CriaBanco (Context context){

        super (context, NOME_BD, null, VERSAO);
    }

    //Anotação JAVA para sobreescrever um método herdado de uma classe
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Cria uma String com o conteúdo de uma query para criar o banco de dados
        String sql = "CREATE TABLE " + TABELA + " ("
                + ID + " integer primary key autoincrement, "
                + NOME + " text"
                + ")";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Query para apagar a tabela
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        //Chama o metodo onCreate novamente
        onCreate(db);
    }
}
