package com.company;

import java.util.ArrayList;

public class FrotaMotorizada  {


    public System System;
    protected Veiculo marca;
    protected Veiculo modelo;
    protected Veiculo ano;
    protected Veiculo quilometragem;
    protected Veiculo placa;
    protected Veiculo ligado;


    //Função que retorna o arrayList de main:
    public void imprimirLista(ArrayList<Veiculo> veiculos) {
        System.out.println("Voce escolheu a 1");
        System.out.println("  ");
        for (var v: veiculos) {
            System.out.println(v);
        }
        System.out.println("  ");
        System.out.println("----------------------------------");
        System.out.println("  ");
    }

}
