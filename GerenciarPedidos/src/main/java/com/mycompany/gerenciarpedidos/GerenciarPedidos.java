package com.mycompany.gerenciarpedidos;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Rangel
 */
public class GerenciarPedidos {

    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();
        // Criar clientes
        Cliente c1 = new Cliente("Ana", "123.456.789-00");
        Cliente c2 = new Cliente("Bruno", "987.654.321-00");
        Cliente c3 = new Cliente("Carlos", "111.222.333-44");

        // Criar produtos
        Produto p1 = new Produto("Notebook", 3500.00, 101);
        Produto p2 = new Produto("Mouse", 80.00, 102);
        Produto p3 = new Produto("Teclado", 150.00, 103);
        Produto p4 = new Produto("Monitor", 1200.00, 104);

        // Pedido 1 do cliente Ana
        Pedido pedido1 = new Pedido(c1, new ArrayList<>());
        pedido1.adicionarProduto(p1);
        pedido1.adicionarProduto(p2);

        // Pedido 2 do cliente Bruno
        Pedido pedido2 = new Pedido(c2, new ArrayList<>());
        pedido2.adicionarProduto(p3);
        pedido2.adicionarProduto(p4);

        // Pedido 3 do cliente Ana (mais um pedido)
        Pedido pedido3 = new Pedido(c1, new ArrayList<>());
        pedido3.adicionarProduto(p2);
        pedido3.adicionarProduto(p3);

        // Pedido 4 do cliente Carlos
        Pedido pedido4 = new Pedido(c3, new ArrayList<>());
        pedido4.adicionarProduto(p1);

        // Adicionar pedidos na lista
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);

        
        mostrarTotalPedidos(pedidos);
        mostrarFaturamentoTotal(pedidos);
        mostrarProdutoMaisVendido(pedidos);
        mostrarProdutoMenosVendido(pedidos);
        mostrarClienteComMaisPedidos(pedidos);
        mostrarClienteQueMaisGastou(pedidos);

    }
    
    //Total de pedidos
    public static void mostrarTotalPedidos(List<Pedido> pedidos) {
        System.out.println("Total de pedidos: " + pedidos.size());
    }
    
    //Faturamento total
    public static double calcularFaturamentoTotal(List<Pedido> pedidos) {
        double total = 0.0;
        for (Pedido pedido : pedidos) {
            for (Produto produto : pedido.getProdutos()) {
                total += produto.getPreco();
        }
    }
        return total;
    }
    public static void mostrarFaturamentoTotal(List<Pedido> pedidos) {
        double faturamento = calcularFaturamentoTotal(pedidos);
        System.out.println("Faturamento total dos pedidos: R$ " + faturamento);
    }
    
    //Produto que teve mais saída
    public static Produto produtoMaisVendido(List<Pedido> pedidos) {
        Map<Produto, Integer> contagemProdutos = new HashMap<>();

        for (Pedido pedido : pedidos) {
            for (Produto produto : pedido.getProdutos()) {
                contagemProdutos.put(produto, contagemProdutos.getOrDefault(produto, 0) + 1);
        }
    }

    Produto maisVendido = null;
    int maxQuantidade = 0;

    for (Entry<Produto, Integer> entry : contagemProdutos.entrySet()) {
        if (entry.getValue() > maxQuantidade) {
            maxQuantidade = entry.getValue();
            maisVendido = entry.getKey();
        }
    }

    return maisVendido;
    }
    public static void mostrarProdutoMaisVendido(List<Pedido> pedidos) {
        Produto produto = produtoMaisVendido(pedidos);
        if (produto != null) {
            System.out.println("Produto mais vendido: " + produto.getNome());
        } else {
            System.out.println("Nenhum produto vendido.");
        }
    }
    
    //Produto que teve menos saída
    public static Produto produtoMenosVendido(List<Pedido> pedidos) {
    Map<Produto, Integer> contagemProdutos = new HashMap<>();

    // Contar quantidades
    for (Pedido pedido : pedidos) {
        for (Produto produto : pedido.getProdutos()) {
            contagemProdutos.put(produto, contagemProdutos.getOrDefault(produto, 0) + 1);
        }
    }

    Produto menosVendido = null;
    int minQuantidade = Integer.MAX_VALUE;

    for (Map.Entry<Produto, Integer> entry : contagemProdutos.entrySet()) {
        int quantidade = entry.getValue();
        if (quantidade < minQuantidade) {
            minQuantidade = quantidade;
            menosVendido = entry.getKey();
        }
    }

    return menosVendido;
    }
    public static void mostrarProdutoMenosVendido(List<Pedido> pedidos) {
    Produto produto = produtoMenosVendido(pedidos);
    if (produto != null) {
        System.out.println("Produto menos vendido: " + produto.getNome());
    } else {
        System.out.println("Nenhum produto vendido.");
        }
    }
    
    //Cliente que fez mais pedido
    public static Cliente clienteComMaisPedidos(List<Pedido> pedidos) {
    Map<Cliente, Integer> contagemPedidos = new HashMap<>();

    for (Pedido pedido : pedidos) {
        Cliente cliente = pedido.getCliente();
        contagemPedidos.put(cliente, contagemPedidos.getOrDefault(cliente, 0) + 1);
    }

    Cliente topCliente = null;
    int maxPedidos = 0;

    for (Map.Entry<Cliente, Integer> entry : contagemPedidos.entrySet()) {
        if (entry.getValue() > maxPedidos) {
            maxPedidos = entry.getValue();
            topCliente = entry.getKey();
        }
    }

    return topCliente;
    }
    public static void mostrarClienteComMaisPedidos(List<Pedido> pedidos) {
    Cliente cliente = clienteComMaisPedidos(pedidos);
    if (cliente != null) {
        System.out.println("Cliente com mais pedidos: " + cliente.getNome());
        } else {
        System.out.println("Nenhum pedido registrado.");
        }
    }
    
    //Cliente que mais gastou dinheiro
    public static Cliente clienteQueMaisGastou(List<Pedido> pedidos) {
    Map<Cliente, Double> gastosPorCliente = new HashMap<>();

    for (Pedido pedido : pedidos) {
        Cliente cliente = pedido.getCliente();
        double valorPedido = pedido.calcularValorTotal();
        gastosPorCliente.put(cliente, gastosPorCliente.getOrDefault(cliente, 0.0) + valorPedido);
    }

    Cliente topCliente = null;
    double maxGasto = 0.0;

    for (Map.Entry<Cliente, Double> entry : gastosPorCliente.entrySet()) {
        if (entry.getValue() > maxGasto) {
            maxGasto = entry.getValue();
            topCliente = entry.getKey();
        }
    }

    return topCliente;
    }
    public static void mostrarClienteQueMaisGastou(List<Pedido> pedidos) {
    Cliente cliente = clienteQueMaisGastou(pedidos);
    if (cliente != null) {
        System.out.println("Cliente que mais gastou: " + cliente.getNome());
        } else {
        System.out.println("Nenhum pedido registrado.");
        }
    }

}
