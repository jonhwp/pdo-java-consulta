import java.util.ArrayList;

public class Jogador {

    String nome;
    int idade;
    String modalidade;
    Jogador reserva;

    static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    public Jogador( String nome, int idade, String modalidade ) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
    }

    public Jogador( String nome, int idade, String modalidade, Jogador reserva ) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
        this.reserva = reserva;
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

    public Jogador getReserva() {
        return reserva;
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

    public void setReserva(Jogador reserva) {
        this.reserva = reserva;
    }

    public static void setJogadores(ArrayList<Jogador> jogadores) {
        Jogador.jogadores = jogadores;
    }

    public String toString() {
        if(this.getReserva() == null){
            String s =  "\nNome do jogador: "   + this.getNome() +
                        "\nIdade do jogador: "  + this.getIdade() +
                        "\nModalida de atuação:"+ this.getModalidade() +
                        "\nJogador reserva: sem registro.";
            return s;
        }else{
            String s =  "\nNome do jogador: "   + this.getNome() +
                        "\nIdade do jogador: "  + this.getIdade() +
                        "\nModalida de atuação:"+ this.getModalidade() +
                        "\nJogador reserva:"   + this.getReserva().getNome();
            return s;
        }
    }
}
