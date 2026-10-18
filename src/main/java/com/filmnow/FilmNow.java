package com.filmnow;

import java.util.Scanner;

public class FilmNow {
    private static final int MAX_FILMES = 100;
    private static final int MAX_HOTLIST = 10;
    private Filme[] filmes;
    private HotList hotList;
    private Scanner scanner;

    public FilmNow() {
        this.filmes = new Filme[MAX_FILMES];
        this.hotList = new HotList();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            System.out.print("Opção> ");
            String opcao = scanner.nextLine().trim().toUpperCase();

            switch (opcao) {
                case "A":
                    adicionarFilme();
                    break;
                case "M":
                    mostrarTodos();
                    break;
                case "D":
                    detalharFilme();
                    break;
                case "E":
                    exibirHotList();
                    break;
                case "H":
                    atribuirHot();
                    break;
                case "R":
                    removerHot();
                    break;
                case "S":
                    executando = false;
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    System.out.println();
            }
        }
    }

    private void exibirMenu() {
        System.out.println("(A)Adicionar filme");
        System.out.println("(M)Mostrar todos");
        System.out.println("(D)Detalhar filme");
        System.out.println("(E)Exibir HotList");
        System.out.println("(H)Atribuir Hot");
        System.out.println("(R)Remover Hot");
        System.out.println("(S)Sair");
        System.out.println();
    }

    private void adicionarFilme() {
        System.out.print("Posição> ");
        int posicao = Integer.parseInt(scanner.nextLine().trim());

        if (posicao < 1 || posicao > MAX_FILMES) {
            System.out.println("POSIÇÃO INVÁLIDA");
            return;
        }

        System.out.print("Nome> ");
        String nome = scanner.nextLine().trim();

        System.out.print("Ano> ");
        String ano = scanner.nextLine().trim();

        System.out.print("Local> ");
        String local = scanner.nextLine().trim();

        if (nome.isEmpty() || local.isEmpty()) {
            System.out.println("FILME INVALIDO");
            return;
        }

        Filme novoFilme = new Filme(nome, ano, local);

        for (Filme filme : filmes) {
            if (filme != null && filme.equals(novoFilme)) {
                System.out.println("FILME JA ADICIONADO");
                return;
            }
        }

        filmes[posicao - 1] = novoFilme;
        System.out.println("FILME ADICIONADO");
    }

    private void mostrarTodos() {
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) System.out.println((i + 1) + " - " + filmes[i].getNome());
        }
    }

    private void detalharFilme() {
        System.out.print("Filme> ");
        int posicao = Integer.parseInt(scanner.nextLine().trim());

        if (posicao < 1 || posicao > MAX_FILMES || filmes[posicao - 1] == null) {
            System.out.println("POSIÇÃO INVÁLIDA!");
            return;
        }

        Filme filme = filmes[posicao - 1];
        boolean isHot = hotList.contem(filme);

        String prefixo = isHot ? "🔥 " : "";
        System.out.println(prefixo + filme.getNome() + ", " + filme.getAno());
        System.out.println(filme.getLocal());
    }

    private void exibirHotList() {
        System.out.println(hotList.listar());
    }

    private void atribuirHot() {
        System.out.print("Filme> ");
        int posicaoFilme = Integer.parseInt(scanner.nextLine().trim());

        if (posicaoFilme < 1 || posicaoFilme > MAX_FILMES || filmes[posicaoFilme - 1] == null) {
            System.out.println("POSIÇÃO INVÁLIDA!");
            return;
        }

        System.out.print("Posicao> ");
        int posicaoHot = Integer.parseInt(scanner.nextLine().trim());

        if (posicaoHot < 1 || posicaoHot > MAX_HOTLIST) {
            System.out.println("POSIÇÃO INVÁLIDA!");
            return;
        }

        Filme filme = filmes[posicaoFilme - 1];
        hotList.adicionar(filme, posicaoHot);
        System.out.println("ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!");
    }

    private void removerHot() {
        System.out.print("Posicao> ");
        int posicao = Integer.parseInt(scanner.nextLine().trim());

        if (posicao < 1 || posicao > MAX_HOTLIST) {
            System.out.println("POSIÇÃO INVÁLIDA!");
            return;
        }

        hotList.remover(posicao);
    }

    public static void main(String[] args) {
        FilmNow app = new FilmNow();
        app.executar();
    }
}

