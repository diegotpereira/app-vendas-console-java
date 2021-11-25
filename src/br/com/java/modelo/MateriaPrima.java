package br.com.java.modelo;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class MateriaPrima {
    
    String nome;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int codigo;
    StatusProduto statusProduto;
    Data dataAlteracao;
    int quantidade;
    BigDecimal valor;
    Funcionario autor;
    
    public MateriaPrima(String nome, int quantidade, BigDecimal valor, Funcionario autor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = count.incrementAndGet();
        this.dataAlteracao = Data.getDataHoje();
        this.statusProduto = StatusProduto.PENDENTE;
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }

    public Data getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Data dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void aprovaAquisicao() {
        this.statusProduto = StatusProduto.APROVADO;
        this.setDataAlteracao(Data.getDataHoje());
    }

    public void recusaAquisicao() {
        this.statusProduto = StatusProduto.RECUSADO;
        this.setDataAlteracao(Data.getDataHoje());
    }

    public String getResponsavel() {
        return autor.getNome();
    }
}
