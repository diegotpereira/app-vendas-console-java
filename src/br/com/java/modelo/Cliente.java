package br.com.java.modelo;

public class Cliente extends Pessoa {

    public Cliente(int login, String nome, Data dtNasc, String cpf, int senha) {
        super(login, senha, dtNasc, nome, cpf);
        super.setRole(TipoUsuario.CLIENTE);
    }
}
