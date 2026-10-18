package com.filmnow;

public class Filme {
    private String nome;
    private String ano;
    private String local;

    public Filme(String nome, String ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        boolean nomeEq = (nome == null ? filme.nome == null : nome.equals(filme.nome));
        boolean anoEq = (ano == null ? filme.ano == null : ano.equals(filme.ano));
        return nomeEq && anoEq;
    }

    @Override
    public String toString() {
        return nome + ", " + ano;
    }
}


