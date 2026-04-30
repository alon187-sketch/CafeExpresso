package com.example.demo;

public class Main {
    public static void main(String[] args) {

        Produto cafe = new Produto("Café Expresso", 5.00);
        Produto pao = new Produto("Pão de Queijo", 7.50);
        Produto cappuccino = new Produto("Cappuccino", 8.00);

        ItemPedido item1 = new ItemPedido(cafe, 2);
        ItemPedido item2 = new ItemPedido(pao, 3);
        ItemPedido item3 = new ItemPedido(cappuccino, 1);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);

        pedido.mostrarPedido();

        pedido.pagarPedido();
        pedido.iniciarPreparo();
        pedido.finalizarPedido();

        pedido.mostrarPedido();
    }
}


