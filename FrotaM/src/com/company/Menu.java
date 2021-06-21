package com.company;

public class Menu {

    public default void menu() {
        int escolha = 0;
        switch (escolha) {
            case 1:
                System.out.println("Sua escolha foi a 1");
                break;
            case 2:
                System.out.println("Sua escolha foi a 2");
                break;
            default:
                System.out.println("Nenhum opção escolhida.");
        }

    }
}
