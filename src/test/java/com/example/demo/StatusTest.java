package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



public class StatusTest {    

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

}
