package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }
    
    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void removerProduto(Produto p) {
        produtos.remove(p);
    }
    
    public double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cliente = " + cliente 
                + ", produtos = " + produtos 
                + '}';
    }
}
