package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {    
    
    @Test
    void deveIniciarComStatusPendente() {
        Pedido pedido = new Pedido();
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void deveAdicionarItensECalcularTotal() {

        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(new ItemPedido(cafe, 3)); // 15
        pedido.adicionarItem(new ItemPedido(pao, 3));  // 9

        assertEquals(24.0, pedido.calcularTotal());
    }

    @Test
    void deveMudarStatusParaPago() {

        Pedido pedido = new Pedido();

        pedido.pagarPedido();

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void deveMudarStatusParaEmPreparo() {

        Pedido pedido = new Pedido();

        pedido.pagarPedido();
        pedido.iniciarPreparo();

        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void deveFinalizarPedido() {

        Pedido pedido = new Pedido();

        pedido.pagarPedido();
        pedido.iniciarPreparo();
        pedido.finalizarPedido();

        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDeveIrParaPreparoSemPagamento() {

        Pedido pedido = new Pedido();

        pedido.iniciarPreparo();

        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void naoDeveFinalizarSemEstarEmPreparo() {

        Pedido pedido = new Pedido();

        pedido.finalizarPedido();

        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void naoDevePagarDuasVezes() {

        Pedido pedido = new Pedido();

        pedido.pagarPedido();
        pedido.pagarPedido(); // tentativa inválida

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

}
