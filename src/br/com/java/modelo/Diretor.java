package br.com.java.modelo;

import java.math.BigDecimal;

public class Diretor extends Funcionario{

    public Diretor(int login, String nome, Data dtNasc, String cpf, int senha, BigDecimal salario) {
        super(login, nome, dtNasc, cpf, senha, salario);
        super.setRole(TipoUsuario.ADMINISTRADOR);
    }
}
