package br.com.java.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Pessoa {
    
    private static final AtomicInteger count = new AtomicInteger(0);
    private int codigo;
    private int login;
    private int senha;
    private String nome;
    private String cpf;
    private Data dtNasc;
    public TipoUsuario role;

    public Pessoa(int login, int senha, String nome, String cpf) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Data getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Data dtNasc) {
        this.dtNasc = dtNasc;
    }

    public TipoUsuario getRole() {
        return role;
    }

    public void setRole(TipoUsuario role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Pessoa [codigo=" + codigo + ", cpf=" + cpf + ", dtNasc=" + dtNasc + ", login=" + login + ", nome="
                + nome + ", role=" + role + ", senha=" + senha + "]";
    }
}
