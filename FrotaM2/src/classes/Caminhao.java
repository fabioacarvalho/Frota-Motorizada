package classes;

public class Caminhao extends Veiculo {
    //Caminhão (carga máxima: 16 toneladas, 23 toneladas...)
    //Atributos:
    private int cargaMaxima;

    //Construtor:

    public Caminhao(String marca, String modelo, int ano, int quilometragem, String placa, int cargaMaxima) {
        super(marca, modelo, ano, quilometragem, placa);
        this.cargaMaxima = cargaMaxima;
    }


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
