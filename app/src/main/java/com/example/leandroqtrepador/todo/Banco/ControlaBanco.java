package com.example.leandroqtrepador.todo.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//Definição do nome da classe ControlaBanco. segue o padrão de nomes: classes começam com a primeira letra maiúscula
public class ControlaBanco {

    //Declaração do objeto "db" do tipo "SQLiteDatabase"
    private SQLiteDatabase db;
    //Declaração de objeto "banco" do tipo "CriaBanco"
    private CriaBanco banco;

    //Construtor da classe. Recebe como parâmetro o contexto.
    public  ControlaBanco(Context context){
        banco = new CriaBanco(context);
    }

    //Método do tipo String (deve ser retomado um valor String).
    public String insereDado (String nome, String endereco){
        //Declara o objeto "valores" do tipo "Content/values"
        ContentValues valores;
        //Declara a variável "resultado" do tipo "long"
        long resultado;

        //Retorna o valor do método "getWritableDatabase" e adiciona no objeto "db". Diz que o banco está preparado para escrita de novos dados
        db = banco.getWritableDatabase();

        //instância o objeto "valores com o construtor da classe "ContetValues"
        valores = new ContentValues();

        //put é um método que recebe como parâmetro 2 Strings, a primeira é o nome da coluna do banco de dados, a segunda é o dado que será inserido na linha
        valores.put("nome", nome);
        valores.put("endereco", endereco);

        //insert é um método que recebe como parâmetro 3 valores. primeiro valor é uma String com o nome da tabela, segundo valor é uma String para os campos nulos,
        // terceira valor é um objeto do tipo "ContentValues" com valor a ser inserido
        resultado = db.insert("tarefa", null, valores);
        //close é um método que não recebe parâmetro nenhum. fechar a conexão do banco
        db.close();


        if (resultado == -1){
            return "Erro ao inserir dado";
        }
        else{
            return "Dado inserido com sucesso";
        }
    }

    //declarando o método do tipo cursor que não recebe nenhum parâmetro
    public Cursor carregaDados(){
        //objeto cursor do tipo Cursor
        Cursor cursor;

        //um array de string com o nome campos que recebe os valores entre as chaves
        String [] campos = {"_id", "nome", "endereco"};

        //getReadableDatabase é um método do objeto banco que retorna um valor para o objeto db. esse método diz que o banco esta disponível para a leitura
        db = banco.getReadableDatabase();

        //query é um método do db que recebe com parâmetro o que está entre parenteses. o valor retorna do método query será inserido no objeto cursor
        cursor = db.query("tarefa", campos, null, null, null, null, null);

        //estrutura de decisão como parâmetro cursor for nulo faça: método do objeto cursor que não possue nenhum parâmetro, colocando o cursor na primeira posição
        if (cursor != null){
            cursor.moveToFirst();
        }

        //fecha a conexão do banco
        db.close();
        return cursor; //retorno do objeto cursor no método
    }

    public void deletaDado (int id){
        String where = "_id = " + id;
        db = banco.getReadableDatabase();
        db.delete("tarefa", where, null);
        db.close();
    }

    public Cursor carregaDadoPorId(int id){
        Cursor cursor;
        String[] campos = {"_id", "nome", "endereco"};
        String where = "_id = " + id;
        db = banco.getReadableDatabase();
        cursor = db.query("tarefa", campos, where, null, null,null, null);

        if (cursor!=null){
            cursor.moveToFirst();

        }
        db.close();
        return cursor;
    }
}
