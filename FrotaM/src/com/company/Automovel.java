package com.company;

public class Automovel extends Veiculo {
    //Automóvel (motorização: motor 1.0, motor, motor 1.6...)
    //Atributos:
    private String motorizacao;


    //Acessores:

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    @Override
    public String toString() {
        return super.toString() +
                "motorizacao='" + motorizacao + '\'' +
                '}';
    }
}
