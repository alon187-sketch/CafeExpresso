package com.example.demo;

import org.junit.jupiter.api.Test;

import com.ItemPedido;

import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {

        @Test
    void deveCriarItemPedidoValido() {

        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 2);

        assertEquals(produto, item.getProduto());
        assertEquals(2, item.getQuantidade());
    }

    @Test
    void deveCalcularSubtotalCorretamente() {

        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 3);

        assertEquals(15.0, item.calcularSubtotal());
    }

    @Test
    void deveLancarExcecaoParaProdutoNulo() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 2)
        );

        assertEquals("Produto inválido.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoParaQuantidadeZero() {

        Produto produto = new Produto("Café", 5.0);

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(produto, 0)
        );

        assertEquals("Quantidade inválida.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoParaQuantidadeNegativa() {

        Produto produto = new Produto("Café", 5.0);

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(produto, -3)
        );

        assertEquals("Quantidade inválida.", ex.getMessage());
    }

}
