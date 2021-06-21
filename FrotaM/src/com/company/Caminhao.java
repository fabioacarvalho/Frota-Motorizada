package com.company;

public class Caminhao extends Veiculo {
    //Caminhão (carga máxima: 16 toneladas, 23 toneladas...)
    //Atributos:
    private int cargaMaxima;

    //Métodos:


    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() +
                " cargaMaxima=" + cargaMaxima +
                '}';
    }
}
