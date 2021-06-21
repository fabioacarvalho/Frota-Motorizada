package com.company;

public class Onibus extends Veiculo {
    private int capacidade;

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacidade=" + capacidade +
                '}';
    }
}
