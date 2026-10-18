package com.filmnow;

public class HotList {
    private static final int MAX_HOTLIST = 10;
    private Filme[] filmes;

    public HotList() {
        this.filmes = new Filme[MAX_HOTLIST];
    }

    public void adicionar(Filme filme, int posicao) {
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null && filmes[i].equals(filme)) filmes[i] = null;
        }
        filmes[posicao - 1] = filme;
    }

    public void remover(int posicao) {
        if (posicao >= 1 && posicao <= MAX_HOTLIST) filmes[posicao - 1] = null;
    }

    public boolean contem(Filme filme) {
        for (Filme f : filmes) if (f != null && f.equals(filme)) return true;
        return false;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) sb.append(i + 1).append(" - ").append(filmes[i].getNome()).append(", ").append(filmes[i].getAno()).append("\n");
        }
        return sb.toString().trim();
    }
}
