package com.model;

import javax.sound.midi.MidiMessage;

public class Moto {

    private int id;
    private String modelo;
    private String placa;
    private int ano;

    public Moto(int id, String modelo, String placa, int ano) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public Moto(String modelo, String placa, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return "ID: " + id + " - Modelo: " + modelo + " - Placa: " +  placa + " - Ano: " + ano;
    }
}
