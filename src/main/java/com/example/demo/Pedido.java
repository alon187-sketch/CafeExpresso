package com.example.demo;
import java.util.ArrayList;

public class Pedido {

    private ArrayList<ItemPedido> itens;
    private StatusPedido status;

    public StatusPedido getStatus() {
        return status;
    }

    public Pedido() {
        itens = new ArrayList<>();
        status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for(ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void pagarPedido() {
        if(status == StatusPedido.PENDENTE) {
            status = StatusPedido.PAGO;
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Não é possível pagar neste status.");
        }
    }

    public void iniciarPreparo() {
        if(status == StatusPedido.PAGO) {
            status = StatusPedido.EM_PREPARO;
            System.out.println("Pedido em preparo.");
        } else {
            System.out.println("Pagamento não confirmado.");
        }
    }

    public void finalizarPedido() {
        if(status == StatusPedido.EM_PREPARO) {
            status = StatusPedido.FINALIZADO;
            System.out.println("Pedido finalizado.");
        } else {
            System.out.println("Pedido ainda não está em preparo.");
        }
    }

    public void mostrarPedido() {

        System.out.println("\n--- PEDIDO ---");

        for(ItemPedido item : itens) {
            System.out.println(item);
        }

        System.out.println("Total: R$ " + calcularTotal());
        System.out.println("Status: " + status);
    }
}
