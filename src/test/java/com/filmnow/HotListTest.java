package com.filmnow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotListTest {

    @Test
    public void testAdicionarEContem() {
        HotList hotList = new HotList();
        Filme filme = new Filme("Anatomia de uma Queda", "2023", "Cinema");
        hotList.adicionar(filme, 1);
        assertTrue(hotList.contem(filme));
    }

    @Test
    public void testRemover() {
        HotList hotList = new HotList();
        Filme filme = new Filme("Anatomia de uma Queda", "2023", "Cinema");
        hotList.adicionar(filme, 1);
        hotList.remover(1);
        assertFalse(hotList.contem(filme));
    }

    @Test
    public void testListar() {
        HotList hotList = new HotList();
        Filme filme = new Filme("Anatomia de uma Queda", "2023", "Cinema");
        hotList.adicionar(filme, 1);
        String resultado = hotList.listar();
        assertTrue(resultado.contains("1 - Anatomia de uma Queda, 2023"));
    }

    @Test
    public void testFilmeSoUmaVez() {
        HotList hotList = new HotList();
        Filme filme = new Filme("Anatomia de uma Queda", "2023", "Cinema");
        hotList.adicionar(filme, 1);
        hotList.adicionar(filme, 3);
        String resultado = hotList.listar();
        // Deve aparecer apenas uma vez
        assertEquals(1, resultado.split("Anatomia").length - 1);
    }
}
