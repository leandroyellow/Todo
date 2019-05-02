package com.example.leandroqtrepador.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leandroqtrepador.todo.Banco.ControlaBanco;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insere (View view){

        ControlaBanco crud = new ControlaBanco(getBaseContext());
        EditText edNome = findViewById(R.id.txtNome);
        TextView tvResultado = findViewById(R.id.tvResultado);
        String nome = edNome.getText().toString();

        if (nome.equals("") ) {

            tvResultado.setText("digite um nome");


        }
        else{

            String resultado = crud.insereDado(nome);
            tvResultado.setText(resultado);

            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);

            edNome.setText("");
        }
    }
}
