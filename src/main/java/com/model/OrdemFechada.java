package com.model;

import java.sql.Date;

public class OrdemFechada {

    private int id;
    private Date data;
    private double valor;

    public OrdemFechada(int id, Date data, double valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }

    public OrdemFechada(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
