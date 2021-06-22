package com.company;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    //Veículo (marca, modelo, ano, quilometragem, placa)
    //Atributos:
    protected String marca;
    protected String modelo;
    protected int ano;
    protected int quilometragem;
    protected String placa;
    protected boolean ligado;

    //Construtor:


    public Veiculo(String marca, String modelo, int ano, int quilometragem, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.ligado = false;
    }

    //Métodos:
    public void ligar() {
        if (ligado == true) {
            System.out.println("Veiculo ligado");
        } else {
            System.out.println("Veiculo desligado");
        }
    }

    //Acessores:

    public boolean getLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return  "marca= " + marca + '\n' +
                "modelo= " + modelo + " - " +
                "ano=" + ano + '\n' +
                "quilometragem= " + quilometragem + '\n' +
                "placa= " + placa + '\n' +
                "ligado= " + (getLigado() ? " Veiculo Ligado" : " Veiculo Desligado") + '\n';
    }
}
