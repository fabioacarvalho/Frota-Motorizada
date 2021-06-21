package classes;

public class Onibus extends Veiculo {
    private int capacidade;


    //Construtor:

    public Onibus(String marca, String modelo, int ano, int quilometragem, String placa, int capacidade) {
        super(marca, modelo, ano, quilometragem, placa);
        this.capacidade = capacidade;
    }


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
