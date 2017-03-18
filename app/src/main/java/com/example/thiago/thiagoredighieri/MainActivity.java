package com.example.thiago.thiagoredighieri;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Thiago Redighieri
//******************************************************

public class MainActivity extends AppCompatActivity {

    Button btsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsecond = (Button) findViewById(R.id.btsecond);
        btsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamasegundatela();
            }
        });
    }


    void chamasegundatela(){

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, secondActivity.class);
        startActivity(intent);
        finish();

    }


}
