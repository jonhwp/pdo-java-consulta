package src;
import java.util.ArrayList;
import java.util.Scanner;

import static src.Equipe.equipes;
import static src.Jogador.jogadores;
import static src.Tecnico.tecnicos;


public class GerenciaEquipes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Equipe> listaEquipes = new ArrayList<Equipe>();

        boolean sair = false;
        int escolha;

        while (!sair)   // loop para exibir o menu principal
        {
            menu();
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    // Cadastrar Jogador
                    cadastrarJogador(jogadores);

                    break;
                case 2:
                    // Cadastrar Técnico
                    cadastrarTecnico(tecnicos);
                    break;
                case 3:
                    // Cadastrar Equipe
                    //cadastrarEquipe(listaEquipes, listaTecnicos, listaJogadores);
                    boolean inserirNovaEquipe = true;

                    do {
                        if (inserirNovaEquipe) {

                            String nomeEquipe = Console.leString("Nome da equipe:");
                            String modalidade = Console.leString("Modalidade do time:");
                            int quantidade = Console.leInteiro("Quantidade de jogadores:");

                            ArrayList<Jogador> jogadoresPorTime = null;
                            for (int i = 0; i <= quantidade; i++)
                            {

                                // Seleciona os jogadores da consulta
                                Jogador jogadorConsulta = null;

                                int indexJog = 1;
                                System.out.println("\nJogadores disponíveis: ");
                                for (Jogador j : jogadores) {
                                    System.out.println("\t" + indexJog + " - " + j.getNome());
                                    indexJog++;
                                }
                                int numJogSelecionado = Console.leInteiro("Digite o número do jogador: ");

                                //O número digitado deve estar entre 1 e pacientes.size()
                                while (!(numJogSelecionado > 0) && (numJogSelecionado <= jogadores.size())) {
                                    // Aqui estamos garantindo que o número digitado seja uma
                                    // posição válida do ArrayList
                                    System.out.println("Posição do jogador inválida!");
                                    numJogSelecionado = Console.leInteiro("Digite o número do jogador: ");
                                }

                                // Agora, a partir do número digitado, vamos recuperar o objeto da lista
                                // de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
                                // a partir do 0 (zero)

                                jogadorConsulta = jogadores.get(indexJog - 1);
                                jogadoresPorTime = new ArrayList<>();
                                jogadoresPorTime.add(jogadorConsulta);

                            }
                            // Seleciona o técnico da consulta
                            Tecnico tecnicoConsulta = null;

                            int indexTec = 1;
                            System.out.println("\nTécnicos disponíveis: ");
                            for (Tecnico t : tecnicos) {
                                System.out.println("\t" + indexTec + " - " + t.getNome());
                                indexTec++;
                            }

                            int numTecSelecionado = Console.leInteiro("\nDigite o número do técnico: ");

                            while (!(numTecSelecionado > 0 && numTecSelecionado <= tecnicos.size())) {
                                // Aqui estamos garantindo que o número digitado seja uma
                                // posição válida do ArrayList
                                System.out.println("Posição do médico inválida!");
                                numTecSelecionado = Console.leInteiro("Digite o número do técnico: ");
                            }

                            // Agora, a partir do número digitado, vamos recuperar o objeto da lista
                            // de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
                            // a partir do 0 (zero)

                            tecnicoConsulta = tecnicos.get(numTecSelecionado - 1);


                            // Recebe demais atributos

                            // Estas mensagens serão utilizadas apenas para exibir informações
                            // para o usuário final.

                            // Cria uma nova consulta
                            // String nome, int qnt, String modalidade, Tecnico tecnico, Jogador jogador)
                            Equipe c = new Equipe(
                                    nomeEquipe,
                                    quantidade,
                                    modalidade,
                                    tecnicoConsulta,
                                    jogadoresPorTime
                            );

                            // Adiciona na lista de consultas
                            equipes.add(c);
                            System.out.println("Equipe incluída com sucesso!");

                            String continuar = Console.leString("\nDeseja inserir outra consulta (Y/N)? ");

                            if (continuar.equalsIgnoreCase("N"))
                                inserirNovaEquipe = false;

                        }

                        String continuar = Console.leString("\nDeseja inserir outra consulta (Y/N)? ");

                        if (continuar.equalsIgnoreCase("N"))
                            inserirNovaEquipe = false;

                    } while (inserirNovaEquipe == true);

                case 4:
                    System.out.println("\nLista de equipes: ");

                    listarEquipes(equipes);

                    break;

                        default:
                            System.out.println("Opção invalida!");
                            break;
                    }
            }
        }

    private static void menu() {
        String displayMenu = "\n 1 - Cadastrar Jogador " +
                "\n 2 - Cadastrar Técnico           " +
                "\n 3 - Cadastrar Equipe     " +
                "\n 4 - Exibir Equipes           " +
                "\n 5 - Sair";

        System.out.println(displayMenu);
    }

    public static void cadastrarJogador(ArrayList<Jogador> jogadores) {
        // Leia os atributos e crie um objeto do tipo jogador e
        // adicione na lista de jogadores
        while (true) {
            int valida = Console.leInteiro("Digite 1 para com reserva e 2 para sem reserva.");
            switch (valida){
                case 1:
                    System.out.println("\nInformações sobre o jogador:");
                    Jogador j = new Jogador(Console.leString("Nome Completo"),
                            Console.leInteiro("Idade:"),
                            Console.leString("Modalidade do esporte: ")
                    );
                    jogadores.add(j);
                    System.out.println("Jogador incluído com sucesso!");
                    break;
                case 2:
                    System.out.println("\nInformações sobre o jogador:");
                    Jogador o = new Jogador(Console.leString("Nome Completo"),
                            Console.leInteiro("Idade:"),
                            Console.leString("Modalidade do esporte: "),
                            Console.leString("Nome do reserva: ")
                    );
                    jogadores.add(o);
                    System.out.println("Jogador incluído com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            String c = Console.leString("Digite N para encerrar ou qualquer tecla para inserir um novo paciente: ");

            if (c.equalsIgnoreCase("N")) {
                break;
            }
        }

        for (Jogador j : jogadores) {
            System.out.println("\nLista de jogadores disponíveis:");
            System.out.println("\t" + j.toString());

        }

    }

    public static void cadastrarTecnico(ArrayList<Tecnico> tecnicos) {
        // Leia os atributos e crie um objeto do tipo tecnico e
        // adicione na lista de tecnicos
        while (true) {
            System.out.println("\nInformações sobre o técnico:");
            Tecnico t = new Tecnico(
                    Console.leString("Nome completo"),
                    Console.leInteiro("Idade:"),
                    Console.leString("Modalidade do esporte:"),
                    Console.leReal("Salário: ")
            );
            tecnicos.add(t);
            System.out.println("Técnico incluído com sucesso!");

            String c = Console.leString("Digite N para encerrar ou qualquer tecla para inserir um novo paciente: ");

            if (c.equalsIgnoreCase("N")) {
                break;
            }
        }

        for (Tecnico t : tecnicos) {
            // Para recuperar o nome do paciente, use o getNome()
            System.out.println("\nLista de técnicos cadastrados:");
            System.out.println("\t" + t.toString());
        }

    }

    public static void listarEquipes(ArrayList<Equipe>  equipes) {
        // Itere a lista de equipes e chame o método toString de
        // cada equipe na lista
        for (Equipe e : equipes) {
            System.out.println(e);
        }
    }


}

