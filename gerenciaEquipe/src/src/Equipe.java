package src;

import java.util.ArrayList;

public class Equipe {

    String equipe;
    String modalidade;
    int quantidade;
    Tecnico tecnico;

    static ArrayList<Jogador> jogadoresPorEquipe = new ArrayList<Jogador>();
    static ArrayList<Equipe> equipes = new ArrayList<Equipe>();

    public Equipe(
            String nome,
            String modalidade,
            int quantidade,
            Tecnico tecnico,
            ArrayList<Jogador> jogadores)
    {
        this.equipe = nome;
        this.modalidade = modalidade;
        this.quantidade = quantidade;
        this.tecnico = tecnico;
        this.jogadoresPorEquipe = jogadores;
    }

    public String getEquipe() {
        return equipe;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String toString() {
        String s =  "\nNome da equipe:"             + this.getEquipe() +
                    "\nModalidade do time: "        + this.getModalidade() +
                    "\nQuantidade de jogadores: "   + this.getQuantidade() +
                    "\nQuantidade de jogadores: "   + this.jogadoresPorEquipe +
                    "\nTécnico atual:"           + this.getTecnico().getNome();
        return s;
    }
}