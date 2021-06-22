package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleFrota {

    public static void main(String[] args) {

        FrotaMotorizada frota = new FrotaMotorizada();

        var veiculos = new ArrayList<Veiculo>();

        //String marca, String modelo, int ano, int quilometragem, String placa, String motorizacao
        veiculos.add(new Automovel("Fiat", "Siena", 2004, 359588, "ABC-1234", "Fire 1.0"));
        veiculos.add(new Onibus("Mercedez", "M1", 2012,30523, "CBA-4321", 20));
        veiculos.add(new Caminhao("Volkswagen", "VW-31", 2021, 000001, "DDD-0235", 15));


        System.out.println("Escolha uma das opções a seguir: ");
        //System.out.println("1. Mostrar lista; \n 2. Adicionar novo veiculo; \n 3. Remover Veiculo. \n 4. Sair.");
        Scanner leitor = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("1. Mostrar lista; \n 2. Adicionar novo veiculo; \n 3. Remover Veiculo. \n 4. Sair.");
            escolha = leitor.nextInt();
            switch (escolha){
                case 1:
                    frota.imprimirLista(veiculos);

                /*
                System.out.println("Voce escolheu a 1");
                for (var veiculo: veiculos) {
                    System.out.println(veiculo.toString());
                }
                */

                    break;
                case 2:
                    System.out.println("Escolho o tipo do veiculo: \n 1. Automovel. \n 2. Caminhao \n 3. Onibus.");
                    int tipo = leitor.nextInt();
                    if (tipo == 1) {
                        System.out.println("Adiione os dados a seguir: ");
                        System.out.println("marca: ");
                        String marca = leitor.next();
                        System.out.println("modelo: ");
                        String modelo = leitor.next();
                        System.out.println("ano: ");
                        int ano = leitor.nextInt();
                        System.out.println("Km: ");
                        int km = leitor.nextInt();
                        System.out.println("placa: ");
                        String placa = leitor.next();
                        System.out.println("Motor: ");
                        String motor = leitor.next();

                        veiculos.add(new Automovel(marca, modelo, ano, km, placa, motor));
                        System.out.println("Veiculo Adicionado com sucesso.");

                        frota.imprimirLista(veiculos);

                    } else if (tipo == 2) {
                        System.out.println("Adiione os dados a seguir: ");
                        System.out.println("marca: ");
                        String marca = leitor.next();
                        System.out.println("modelo: ");
                        String modelo = leitor.next();
                        System.out.println("ano: ");
                        int ano = leitor.nextInt();
                        System.out.println("Km: ");
                        int km = leitor.nextInt();
                        System.out.println("placa: ");
                        String placa = leitor.next();
                        System.out.println("Carga Máxima: ");
                        int carga = leitor.nextInt();

                        veiculos.add(new Caminhao(marca, modelo, ano, km, placa, carga));
                        System.out.println("Veiculo Adicionado com sucesso.");
                    } else if (tipo == 3) {
                        System.out.println("Adiione os dados a seguir: ");
                        System.out.println("marca: ");
                        String marca = leitor.next();
                        System.out.println("modelo: ");
                        String modelo = leitor.next();
                        System.out.println("ano: ");
                        int ano = leitor.nextInt();
                        System.out.println("Km: ");
                        int km = leitor.nextInt();
                        System.out.println("placa: ");
                        String placa = leitor.next();
                        System.out.println("Capacidade: ");
                        int capacidade = leitor.nextInt();

                        veiculos.add(new Onibus(marca, modelo, ano, km, placa, capacidade));
                        System.out.println("Veiculo Adicionado com sucesso.");
                    } else {
                        System.out.println("Veículo não adicionado. \n Favor digitar um valor válido!!");
                    }

                    break;
                case 3:
                    System.out.print("Qual item da lista quer remover, adicione o número: ");
                    int valorRemover = leitor.nextInt();
                    veiculos.remove(valorRemover);
                    System.out.println("Veiculo removido com sucesso.");
                    frota.imprimirLista(veiculos);

                    break;
                default:
                    System.out.println("Escolheu sair.");

            }
        } while (escolha != 4);






    }
}
