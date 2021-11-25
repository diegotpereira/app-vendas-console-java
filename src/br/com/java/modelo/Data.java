package br.com.java.modelo;

import java.time.LocalDate;

public class Data {
    
    private int dia;
    private int mes;
    private int ano;


    static LocalDate localDate = LocalDate.now();
    static int day = localDate.getDayOfMonth();
    static int month = localDate.getMonthValue();
    static int year = localDate.getYear();

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static Data getDataHoje() {
        return new Data(day, month, year);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
