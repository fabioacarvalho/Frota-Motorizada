package com.company;

public abstract class Veiculo {
    //Veículo (marca, modelo, ano, quilometragem, placa)
    //Atributos:
    private String marca;
    private String modelo;
    private int ano;
    private int quilometragem;
    private String placa;
    private boolean ligado;

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
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                ", placa='" + placa + '\'' +
                ", ligado=" + (getLigado() ? " Veiculo Ligado" : " Veiculo Desligado") + ", ";
    }
}
