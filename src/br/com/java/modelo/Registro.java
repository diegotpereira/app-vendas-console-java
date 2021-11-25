package br.com.java.modelo;

public class Registro {
    
    Data data;
    String acao;
    String autor;

    public Registro(String acao, String autor) {
        this.acao = acao;
        this.autor = autor;
        this.data = Data.getDataHoje();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
