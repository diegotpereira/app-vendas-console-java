package br.com.java.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Venda {
    
    private Cliente comprador;
    private List<Produto> itensVenda;
    private Data datavenda;
    private BigDecimal valorTotal = new BigDecimal(0);
    private Funcionario funcionarioAtendimento;

    LocalDate localDate = LocalDate.now();
    int day = localDate.getDayOfMonth();
    int month = localDate.getMonthValue();
    int year = localDate.getYear();
    
    public Venda(Cliente comprador, List<Produto> itensVenda, Funcionario vendedor) {
        this.comprador = comprador;
        this.itensVenda = itensVenda;
        this.datavenda = new Data(day, month, year);
        setValorTotal(itensVenda);
        this.funcionarioAtendimento = vendedor;
    }

    public void setValorTotal(List<Produto> itensVenda) {
        for(int i =0; i < itensVenda.size(); i++) {
            this.valorTotal = this.valorTotal.add(itensVenda.get(i).getValor());
        }
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getComprador() {
        return comprador.getNome();
    }

    public String getFuncionarioAtendimento() {
        return funcionarioAtendimento.getNome();
    }

    public List<Produto> getItensVenda() {
        return itensVenda;
    }

    public Data getDatavenda() {
        return datavenda;
    }

    public int getCodComprador() {
        return this.comprador.getCodigo();
    }
}
