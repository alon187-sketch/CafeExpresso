package com;

import com.example.demo.Produto;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {

        if(produto == null) {
            throw new IllegalArgumentException("Produto inválido.");
        }

        if(quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return quantidade + "x " +
               produto.getNome() +
               " = R$ " + calcularSubtotal();
    }

}
