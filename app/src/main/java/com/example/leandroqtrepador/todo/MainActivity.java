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

    public void cadastrar (View view){
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }

    public void listar (View view){
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }


}
