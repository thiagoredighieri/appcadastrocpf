package com.example.thiago.thiagoredighieri;

/**
 * Created by Thiago on 19/12/2016.
 */
public class PessoaFisica {

    private String nome;
    private String cpf;
    private String idade;
    private String tel;
    private String email;

    public PessoaFisica(String nome, String cpf, String idade, String tel, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.tel = tel;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
