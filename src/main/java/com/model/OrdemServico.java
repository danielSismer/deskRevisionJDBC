package com.model;

import java.sql.Date;

public class OrdemServico {

    private int id;
    private String placaMoto;
    private Date dataAbertura;
    private String status;
    private String observacao;

    public OrdemServico(int id, String placaMoto, Date dataAbertura, String status, String observacao) {
        this.id = id;
        this.placaMoto = placaMoto;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.observacao = observacao;
    }

    public OrdemServico(String observacao, String placaMoto) {
        this.observacao = observacao;
        this.placaMoto = placaMoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }
}
