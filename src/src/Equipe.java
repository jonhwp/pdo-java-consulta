package src;

import java.util.ArrayList;

public class Equipe {

    /*
        nome da equipe
        modalidade
        quantidade de jogadores
        técnico
        lista de jogadores
    * */

    String nome_equipe;
    String modalidade;
    int qnt_jogadores;
    Tecnico tecnico;
    ArrayList<Jogador> jogadores;


    static ArrayList<Equipe> equipes = new ArrayList<Equipe>();

    public Equipe(String nome, int qnt, String modalidade, Tecnico tecnico, ArrayList<Jogador> listaDeJogadores) {
        this.nome_equipe = nome;
        this.modalidade = modalidade;
        this.qnt_jogadores = qnt;
        this.jogadores = listaDeJogadores;
    }

    public String getNome_equipe() {
        return nome_equipe;
    }

    public void setNome_equipe(String nome_equipe) {
        this.nome_equipe = nome_equipe;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getQnt_jogadores() {
        return qnt_jogadores;
    }

    public void setQnt_jogadores(int qnt_jogadores) {
        this.qnt_jogadores = qnt_jogadores;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public String toString() {

        String s =
                "\nNome: "+ this.getNome_equipe() +
                        "\nIdade: "+ this.getModalidade() +
                        "\nModalida: " + this.getQnt_jogadores() +
                        "\nJogador reserva: " + this.getTecnico();
        return s;
    }
}