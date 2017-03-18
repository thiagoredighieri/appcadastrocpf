package com.example.thiago.thiagoredighieri;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Thiago on 19/12/2016.
 */
public class dbhelper {

    private static  final String DATABASE_NAME = "bancodedados.db";
    private static  final int DATABASE_VERSION = 1;
    private static  final String  TABLE_NAME= "pessoa";

    private Context context;

    private SQLiteDatabase db;

    private SQLiteStatement insertStnt;


    private static final String INSERT = "insert into " + TABLE_NAME + " (nome, cpf, idade, tel, email) values (?,?,?,?,?)";


    public dbhelper(Context context) {
        this.context = context;
        OpenHelper openhelper = new OpenHelper(this.context);
        this.db = openhelper.getWritableDatabase();
        this.insertStnt = this.db.compileStatement(INSERT);
    }


    public long insert(String nome, String cpf, String idade, String tel, String email) {
        this.insertStnt.bindString(1, nome);
        this.insertStnt.bindString(2, cpf);
        this.insertStnt.bindString(3, idade);
        this.insertStnt.bindString(4, tel);
        this.insertStnt.bindString(5, email);

        return this.insertStnt.executeInsert();
    }



    public List<PessoaFisica> queryAll() {

        List<PessoaFisica> list = new ArrayList<PessoaFisica>();

        try {
            Cursor cursor = this.db.query(TABLE_NAME, new String[]{"nome", "cpf", "idade", "tel", "email"},
                    null, null, null, null, null, null);

            int nregistros = cursor.getCount();

            if (nregistros != 0) {
                cursor.moveToFirst();

                do {
                    PessoaFisica pessoa = new PessoaFisica(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                    list.add(pessoa);

                } while (cursor.moveToNext());

                if (cursor != null && ! cursor.isClosed())
                    cursor.close();
                return list;

            } else
                return null;
        }
        catch (Exception err) {
            return null;
        }


    }


    private static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context){

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate (SQLiteDatabase db){
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cpf TEXT, idade TEXT, tel TEXT, email TEXT);";
            db.execSQL(sql);

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

    }







}
