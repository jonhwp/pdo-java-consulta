package src;

import java.util.ArrayList;

public class Jogador {

    String nome;
    int idade;
    String modalidade;
    String jogadorReserva;
    static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    public Jogador( String nome, int idade, String modalidade ) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
    }

    public Jogador( String nome, int idade, String modalidade, String reserva ) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
        this.jogadorReserva = reserva;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getJogadorReserva() {
        return jogadorReserva;
    }

    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public void setJogadorReserva(String jogadorReserva) {
        this.jogadorReserva = jogadorReserva;
    }

    public static void setJogadores(ArrayList<Jogador> jogadores) {
        Jogador.jogadores = jogadores;
    }

    public String toString() {

        String s =
                "\nNome: "+ this.getNome() +
                "\nIdade: "+ this.getIdade() +
                "\nModalida: " + this.getModalidade() +
                "\nJogador reserva: " + this.getJogadorReserva();
        return s;
    }
}
