package com.company;

//Imports Realizados:
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class ControleFrota {

    //Criação do meu ArrayLista aonde serão armazenados os veículos:
    private ArrayList<Veiculo> veiculos;

    //Criação do Construtor:
    public ControleFrota() {
        //Instanciando meu array...
        this.veiculos = new ArrayList<Veiculo>();
    }

    //Criando uma função para leitura dos valores:
    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        //Criando um for para gerar meu menu:
        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    //Vamos criar agora nossos leitores das instancias de Veiculo:
    public Automovel leAutomovel (){

        String [] valores = new String [7];
        String [] nomeVal = {"marca", "modelo", "ano", "quilometragem", "placa", "motor"};
        valores = leValores (nomeVal);

        //Converter para inteiro meus valores que estão dentro do array valores para adicionar na nova instancia de Automovel:
        int ano = this.retornaInteiro(valores[1]);
        int quilometragem = this.retornaInteiro(valores[3]);

        Automovel automovel = new Automovel (valores[0], valores[1], ano, quilometragem, valores[4], valores[5]);
        return automovel;
    }

    public Caminhao leCaminhao (){

        String [] valores = new String [7];
        String [] nomeVal = {"marca", "modelo", "ano", "quilometragem", "placa", "Carga Maxima"};
        valores = leValores (nomeVal);

        //Converter para inteiro meus valores que estão dentro do array valores para adicionar na nova instancia de Automovel:
        int ano = this.retornaInteiro(valores[1]);
        int quilometragem = this.retornaInteiro(valores[3]);
        int cargaMaxima = this.retornaInteiro(valores[5]);

        //Caminhão recebe / instancia um novo caminhão passando como parametro os seguintes atributos:
        Caminhao caminhao = new Caminhao (valores[0], valores[1], ano, quilometragem, valores[4], cargaMaxima);
        return caminhao;
    }

    public Onibus leOnibus (){

        String [] valores = new String [7];
        String [] nomeVal = {"marca", "modelo", "ano", "quilometragem", "placa", "Capacidade"};
        valores = leValores (nomeVal);

        //Converter para inteiro meus valores que estão dentro do array valores para adicionar na nova instancia de Automovel:
        int ano = this.retornaInteiro(valores[1]);
        int quilometragem = this.retornaInteiro(valores[3]);
        int capacidade = this.retornaInteiro(valores[5]);

        //Onibus recebe / instancia um novo Onibus passando como parametro os seguintes atributos:
        Onibus onibus = new Onibus (valores[0], valores[1], ano, quilometragem, valores[4], capacidade);
        return onibus;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) { // Caso não consiga converter em inteiro e gera erro.
            return false;
        }
    }

    //Criamos uma formula para converter em inteiro os dados que eu receber de um Array.
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Criando um loop para leitura / conversão para um valor inteiro:
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n�mero inteiro.");
        }
        return Integer.parseInt(entrada);
    }


    //Implementando o Código para salvar em arquivo:

    public void salvaFrota (ArrayList<Veiculo> veiculos){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    //Local aonde salvar:
                    (new FileOutputStream("FrotaMotorizada.json"));
            for (int i=0; i < veiculos.size(); i++)
                outputStream.writeObject(veiculos.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Recuperando dados do arquivo:

    public ArrayList<Veiculo> recuperaVeiculos (){
        ArrayList<Veiculo> veiculosTemp = new ArrayList<Veiculo>();

        ObjectInputStream inputStream = null;

        //Tratando erros:
        try {
            inputStream = new ObjectInputStream
                    //local aonde recuperar:
                    (new FileInputStream("FrotaMotorizada.json"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Veiculo) {
                    veiculosTemp.add((Veiculo) obj);
                }
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com veiculos NÃO existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectInputStream
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return veiculosTemp;
        }
    }

    //Implementando o MENU:

    public void menuFrotaMotorizada (){

        String menu = "";
        String entrada;
        int    opc1, opc2;


        do {
            menu = "Controle Frota\n" +
                    "Opções:\n" +
                    "1. Entrar Novo Veiculo\n" +
                    "2. Exibir Veiculos\n" +
                    "3. Limpar Veiculos\n" +
                    "4. Gravar Veiculos\n" +
                    "5. Recuperar Veiculos\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Veiculos\n" +
                            "Opções:\n" +
                            "1. Automovel\n" +
                            "2. Caminhao\n" +
                            "3. Onibus\n";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    //Adicionando novos veiculos:
                    switch (opc2){
                        case 1: veiculos.add((Veiculo)leAutomovel());
                            break;
                        case 2: veiculos.add((Veiculo)leCaminhao());
                            break;
                        case 3: veiculos.add((Veiculo)leOnibus());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Veiculo para entrada NÃO escolhido!");
                    }

                    break;
                case 2: // Exibir dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com um veiculo primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < veiculos.size(); i++)	{
                        dados += veiculos.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3: // Limpar Dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com um veiculo primeiramente");
                        break;
                    }
                    veiculos.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com um veiculo primeiramente");
                        break;
                    }
                    salvaFrota(veiculos);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    veiculos = recuperaVeiculos();
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo Frota Motorizada");
                    break;
            }
        } while (opc1 != 9);
    }



    public static void main(String[] args) {

        ControleFrota frota = new ControleFrota ();
        frota.menuFrotaMotorizada();

    }
}
