package com.company;

public class Main {

    public static void main(String[] args) {
        Automovel a1 = new Automovel();
        a1.setMotorizacao("1.0");
        a1.setAno(2009);
        a1.setMarca("Fiat");
        a1.setModelo("Uno");
        a1.setPlaca("ABC-1234");
        a1.setQuilometragem(123456);
        a1.setLigado(true);
        System.out.println(a1.toString());


    }
}
