package src;

import java.util.ArrayList;

public class Tecnico {
    String nome;
    int idade;
    String modalidade;
    float salario;

    static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

    public Tecnico( String nome, int idade, String modalidade, float salario ) {
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public static ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public static void setTecnicos(ArrayList<Tecnico> tecnicos) {
        Tecnico.tecnicos = tecnicos;
    }
    public String toString() {

        String s =
                "\nNome: "+ this.getNome() +
                "\nIdade: "+ this.getIdade() +
                "\nModalida: " + this.getModalidade() +
                "\nJogador reserva: " + this.getSalario();
        return s;
    }
}
