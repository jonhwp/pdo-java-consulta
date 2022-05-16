import java.util.ArrayList;

public class Equipe {

    String equipe;
    String modalidade;
    int quantidade;
    Tecnico tecnico;
    static ArrayList<Jogador> jogadoresPorEquipe;

    static ArrayList<Equipe> equipes = new ArrayList<Equipe>();

    public Equipe(String nome, int qnt, String modalidade, Tecnico tecnico, ArrayList<Jogador> jogadores) {
        this.equipe = nome;
        this.modalidade = modalidade;
        this.quantidade = qnt;
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
                    "\nTécnico operante:"           + this.getTecnico();
        return s;
    }
}