package com.example.leandroqtrepador.todo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.leandroqtrepador.todo.Banco.ControlaBanco;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final ControlaBanco crud = new ControlaBanco(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {"_id", "nome", "endereco"};
        int[] idViews = new int[] {R.id.tvID, R.id.tvNome, R.id.tvEndereco};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_tarefas, cursor, nomeCampos, idViews, 0);

        lista = findViewById(R.id.lvItens);
        lista.setAdapter(adapter);

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                crud.deletaDado(codigo);
                finish();
                startActivity(getIntent());
                return false;
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer codigoId;

                cursor.moveToPosition(position);
                codigoId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));

                Intent intent = new Intent(ListaActivity.this, AtualizaActivity.class);
                intent.putExtra("codigoId", codigoId.toString());
                startActivity(intent);
                finish();
                

            }
        });

    }
}
