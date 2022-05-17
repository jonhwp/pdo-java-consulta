package src;

import java.util.ArrayList;
import java.util.Scanner;

import static src.Jogador.jogadores;
import static src.Equipe.jogadoresPorEquipe;

public class GerenciaEquipes {

    public static void main(String[] args)

    {

        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        int escolha;

        // loop para exibir o menu principal
        while (!sair)
        {
            menu();
            escolha = sc.nextInt();

            // Menu de opções
            switch (escolha)
            {
                case 1:
                    // Contem 2 contrutores, um com reserva, outro sem.
                    cadastrarJogador(jogadores);
                    break;
                case 2:
                    // Cadastrar Técnico
                    cadastrarTecnico(Tecnico.tecnicos);
                    break;
                case 3:
                    //cadastrarEquipe(listaEquipes, listaTecnicos, listaJogadores);
                    cadastrarEquipe(Equipe.equipes);
                case 4:
                    // Lista as equipes cadastradas.
                    listarEquipes(Equipe.equipes);
                    break;
                case 5:
                    // Sais.
                    System.out.println("Você escoulheu sair. Até mais!");
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    // função para chamada do menu
    private static void menu()
    {
        String displayMenu =
                "\n         MENU DE OPÇÕES \n " +
                "\n 1 - Cadastrar Jogador " +
                "\n 2 - Cadastrar Técnico  " +
                "\n 3 - Cadastrar Equipe " +
                "\n 4 - Exibir Equipes " +
                "\n 5 - Sair";

        System.out.println(displayMenu);
    }


    // função para o cadastro de novos jogadores
    public static void cadastrarJogador(ArrayList<Jogador> jogadores)
    {
        // Leia os atributos e crie um objeto do tipo jogador e
        // adicione na lista de jogadores
        while (true)
        {
            System.out.println("\nInsira as informações sobre o jogador:");

            String  nomeJogador=    Console.leString("Nome do jogador:");
            int     idadeJogador=   Console.leInteiro("Idade do jogador:");
            String  modalidadeJog=  Console.leString("Modalidade do esporte do jogador: ");

            // Condicional: se ArrayList de Jogadores não estiver vazia...
            if( !(jogadores.isEmpty())  )
            {
                int valida = Console.leInteiro("Gostaria de registrar algum reserva para este jogador?\n1 - Sim\n2 - Não");

                Jogador reserva = null;
                if (valida == 1) {

                    int indexRes = 1;
                    System.out.println("\nJogadores disponíveis: ");
                    for (Jogador j : jogadores) {
                        System.out.println("\t" + indexRes + " - " + j.getNome());
                        indexRes++;
                    }
                    int numJogSelecionado = Console.leInteiro("\nDigite o número do jogador desejado: ");
                    while (!(numJogSelecionado > 0 && numJogSelecionado <= jogadores.size())) {
                        // Aqui estamos garantindo que o número digitado seja uma
                        // posição válida do ArrayList
                        System.out.println("Posição do jogador inválida!");
                        numJogSelecionado = Console.leInteiro("Digite o número do técnico: ");
                    }
                    // Agora, a partir do número digitado, vamos recuperar o objeto da lista
                    // de jogadores. Lembra que temos que subtrair 1, pois o ArrayList é indexado
                    // a partir do 0 (zero)
                    reserva = jogadores.get(numJogSelecionado - 1);
                }

                Jogador j = new Jogador(nomeJogador, idadeJogador, modalidadeJog, reserva);
                jogadores.add(j);
            }else{
                // Criação padrão de Jogadores.
                Jogador s = new Jogador(nomeJogador, idadeJogador, modalidadeJog);
                jogadores.add(s);
            }

            for (Jogador j: jogadores){
                System.out.println(j);
            }
            
            System.out.println("\nJogador incluído com sucesso!");

            String c = Console.leString("Digite N para encerrar ou qualquer tecla para inserir um novo jogador: ");
            if (c.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void cadastrarTecnico(ArrayList<Tecnico> tecnicos) {
        // Leia os atributos e crie um objeto do tipo tecnico e
        // adicione na lista de tecnicos

        while (true) {
            System.out.println("\nInsira as informações sobre o técnico:");
            Tecnico t = new Tecnico(
                    Console.leString(   "Nome completo do técnico"),
                    Console.leInteiro(  "Idade do técnico:"),
                    Console.leString(   "Modalidade do esporte do técnico:"),
                    Console.leReal(     "Salário do técnico: ")
            );
            tecnicos.add(t);
            System.out.println("Técnico incluído com sucesso!");

            String c = Console.leString("Digite N para encerrar ou qualquer tecla para inserir um novo técnico: ");
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

    public static void cadastrarEquipe(ArrayList<Equipe> equipes){

        boolean inserirNovaEquipe = true;
        do {
            if (inserirNovaEquipe) {

                String equipe = Console.leString("Nome da equipe:");
                String modalidade = Console.leString("Modalidade de esporte da equipe:");
                int quantidade = Console.leInteiro(  "Quantidade de jogadores da equipe:");

                // Adiciona a quantidade de jogadores no ArrayList jogadoresPorEquipe.
                for (int i = 0; i < quantidade; i++)
                {
                    // Seleciona o jogador da consulta
                    Jogador jogadorSelecionado = null;
                    int indexTec = 1;
                    System.out.println("\nJogadores disponíveis: ");
                    for (Jogador j : jogadores) {
                        System.out.println("\t" + indexTec + " - " + j.getNome());
                        indexTec++;
                    }
                    int numJogSelecionado = Console.leInteiro("\nDigite o número do jogador para adicionar à equipe: ");
                    while (!(numJogSelecionado > 0 && numJogSelecionado <= Jogador.jogadores.size())) {
                        // Aqui estamos garantindo que o número digitado seja uma
                        // posição válida do ArrayList
                        System.out.println("Posição do jogador inválida!");
                        numJogSelecionado = Console.leInteiro("Digite o número do jogador: ");
                    }
                    //  Com isso, podemos pegar o objeto da lista jogadores e adicionar a lista de jogadoresPorEquipe
                    System.out.println(jogadores.get(numJogSelecionado-1));
                    jogadoresPorEquipe.add(jogadores.get(numJogSelecionado-1));

                    for(Jogador je: jogadoresPorEquipe){
                        System.out.println(je);
                    }
                }

                // Seleciona o técnico da equipe através do ArrayList técnicos
                Tecnico tecnico = null;
                int indexTec = 1;
                System.out.println("\nTécnicos disponíveis: ");
                for (Tecnico t : Tecnico.tecnicos)
                {
                    System.out.println("\t" + indexTec + " - " + t.getNome());
                    indexTec++;
                }
                int numTecSelecionado = Console.leInteiro("\nDigite o número do técnico desejado: ");
                // Validação para checar se o usuário digitou uma opção válida.
                while (!(numTecSelecionado > 0 && numTecSelecionado <= Tecnico.tecnicos.size()))
                {
                    // Aqui estamos garantindo que o número digitado seja uma
                    // posição válida do ArrayList
                    System.out.println("Posição do técnico inválida!");
                    numTecSelecionado = Console.leInteiro("Digite o número do técnico: ");
                }
                tecnico = Tecnico.tecnicos.get(numTecSelecionado - 1);

                // Intancia um objeto Equipe.
                Equipe c = new Equipe(
                        equipe,
                        modalidade,
                        quantidade,
                        tecnico,
                        Equipe.jogadoresPorEquipe
                );

                equipes.add(c);
                System.out.println("Equipe incluída com sucesso!");

            }
            String continuar = Console.leString("\nDeseja inserir outra equipe (Y/N)? ");
            if (continuar.equalsIgnoreCase("N"))
                inserirNovaEquipe = false;

        } while (inserirNovaEquipe == true);
    }

    public static void lsitarJogadores(ArrayList<Jogador>  jogadores) {
        // Itere a lista de equipes e chame o método toString de

        if (jogadores.isEmpty()){
            Console.msg("Não há jogadores cadastrados.");
        }else{
            Console.msg("\nLista de jogadores: ");
            for (Jogador j : jogadores) {
                System.out.println(j);
            }
        }
    }

    public static void listarEquipes(ArrayList<Equipe>  equipes) {
        // Itere a lista de equipes e chame o método toString de

        if (equipes.isEmpty()){
            Console.msg("Não há equipes cadastradas.");
        }else{
            Console.msg("\nLista de equipes: ");
            for (Equipe e : equipes) {
                System.out.println(e);
            }
        }
    }
}

