package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void deveCriarProdutoValido() {

        Produto p = new Produto("Café Expresso", 6.00);

        assertEquals("Café Expresso", p.getNome());
        assertEquals(6.00, p.getPreco());
    }

    @Test
    void deveLancarExcecaoParaNomeVazio() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("", 5.00)
        );

        assertEquals("Nome inválido.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoParaNomeNulo() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto(null, 5.00)
        );

        assertEquals("Nome inválido.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoParaPrecoZero() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Café", 0)
        );

        assertEquals("Preço inválido.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoParaPrecoNegativo() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Café", -10)
        );

        assertEquals("Preço inválido.", ex.getMessage());
    }
}