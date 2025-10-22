package com.model;

public class OrdemServicoItem {

    private int idOrdemServico;
    private int idServico;
    private int quantidade;

    public OrdemServicoItem(int idOrdemServico, int idServico, int quantidade) {
        this.idOrdemServico = idOrdemServico;
        this.idServico = idServico;
        this.quantidade = quantidade;
    }

    public OrdemServicoItem(int idServico, int quantidade) {
        this.idServico = idServico;
        this.quantidade = quantidade;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString (){
        return "ID da Ordem de Serviço: " + idOrdemServico + " - ID Serviço: " + idServico + " - Quantidade: " + quantidade;
    }
}
