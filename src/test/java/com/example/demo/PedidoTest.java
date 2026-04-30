package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



public class PedidoTest {    

    private Pedido pedido;

    @BeforeEach
    public void setup (){
        pedido = new Pedido();
    }

    @AfterEach
    public void tearDown(){
        pedido = null;
    }
    
    @Test
    void deveIniciarComStatusPendente() {
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void deveAdicionarItensECalcularTotal() {

        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        pedido.adicionarItem(new ItemPedido(cafe, 3)); // 15
        pedido.adicionarItem(new ItemPedido(pao, 3));  // 9

        assertEquals(24.0, pedido.calcularTotal());
    }

    @Test
    void deveMudarStatusParaPago() {
        pedido.pagarPedido();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void deveMudarStatusParaEmPreparo() {
        pedido.pagarPedido();
        pedido.iniciarPreparo();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void deveFinalizarPedido() {
        pedido.pagarPedido();
        pedido.iniciarPreparo();
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDeveIrParaPreparoSemPagamento() {
        pedido.iniciarPreparo();
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void naoDeveFinalizarSemEstarEmPreparo() {
        pedido.finalizarPedido();
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void naoDevePagarDuasVezes() {
        pedido.pagarPedido();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }
}
