package br.com.java.modelo;

import java.math.BigDecimal;

public class Funcionario extends Pessoa{
    
   
    private BigDecimal salario;
    private BigDecimal comissoes;
    private BigDecimal comissao;


    public Funcionario(int login, String nome, Data dtNasc, String cpf, int senha, BigDecimal salario) {
        super(login, senha, dtNasc, nome, cpf);
        super.setRole(TipoUsuario.FUNCIONARIO);

        this.salario = salario;
        this.comissoes = new BigDecimal(0);
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    // public void setSalario(BigDecimal salario) {
    //     this.salario = salario;
    // }


    public BigDecimal getComissoes() {
        return comissoes;
    }

    // public void setComissoes(BigDecimal comissoes) {
    //     this.comissoes = comissoes;
    // }


    public BigDecimal getComissao() {
        return this.comissao;
    }


    public void setComissao(BigDecimal valorVenda) {
        BigDecimal percentualComissao = new BigDecimal(0.5);
        this.comissao = comissoes.add(valorVenda.multiply(percentualComissao));
    }
}
