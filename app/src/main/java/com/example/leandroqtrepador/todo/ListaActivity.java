package com.example.leandroqtrepador.todo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.leandroqtrepador.todo.Banco.ControlaBanco;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ControlaBanco crud = new ControlaBanco(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {"_id", "nome"};
        int[] idViews = new int[] {R.id.tvID, R.id.tvNome};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_tarefas, cursor, nomeCampos, idViews, 0);

        lista = findViewById(R.id.lvItens);
        lista.setAdapter(adapter);
    }
}
