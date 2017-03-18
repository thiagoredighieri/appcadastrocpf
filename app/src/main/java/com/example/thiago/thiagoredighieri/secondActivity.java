package com.example.thiago.thiagoredighieri;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class secondActivity extends AppCompatActivity {

    private dbhelper dh;
    Button btvoltar;
    Button btsalvar;
    Button btlistar;
    EditText ednome, edemail, edtel, edidade, edcpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ednome = (EditText)findViewById(R.id.ednome);
        edcpf = (EditText)findViewById(R.id.edcpf);
        edidade = (EditText)findViewById(R.id.edidade);
        edemail = (EditText)findViewById(R.id.edemail);
        edtel = (EditText)findViewById(R.id.edtel);

        btvoltar = (Button) findViewById(R.id.btvoltar);
        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaprimeiratela();
            }
        });

        btsalvar = (Button) findViewById(R.id.btsalvar);
        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ednome.getText().length() > 0 && edcpf.getText().length() > 0 && edidade.getText().length() > 0 && edtel.getText().length() > 0 && edemail.getText().length() > 0){

                    dh.insert(ednome.getText().toString(), edcpf.getText().toString(), edidade.getText().toString(), edtel.getText().toString(), edemail.getText().toString());


                    AlertDialog.Builder adb = new AlertDialog.Builder(secondActivity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Cadastro Realizado!");
                    adb.show();

                    ednome.setText("");
                    edcpf.setText("");
                    edemail.setText("");
                    edidade.setText("");
                    edtel.setText("");

                }
                else
                {
                    AlertDialog.Builder adb = new AlertDialog.Builder(secondActivity.this);
                    adb.setTitle("Erro");
                    adb.setMessage("Todos os campos devem ser preenchidos!");
                    adb.show();

                }


            }
        });


        btlistar = (Button) findViewById(R.id.btlistar);
        btlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PessoaFisica> pessoas = dh.queryAll();
                if (pessoas == null){

                    AlertDialog.Builder adb = new AlertDialog.Builder(secondActivity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.show();

                    return;
                }
                for (int i = 0; i < pessoas.size(); i++) {
                    PessoaFisica pessoa = (PessoaFisica) pessoas.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(secondActivity.this);
                    adb.setTitle("Registro " + i);
                    adb.setMessage("Nome: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nIdade: " + pessoa.getIdade() + "\nCelular: " + pessoa.getTel() + "\nEmail: " + pessoa.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    adb.show();
                }
            }
        });
    }




    void chamaprimeiratela(){

        Intent intent = new Intent();
        intent.setClass(secondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
