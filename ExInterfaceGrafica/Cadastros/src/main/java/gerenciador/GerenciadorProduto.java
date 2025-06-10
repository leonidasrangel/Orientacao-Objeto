package gerenciador;

import classes.Produto;
import file.FilePersistence;
import file.SerializadorJSONProduto;
import file.SerializadorXMLPessoa;
import file.SerializadorXMLProduto;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rangel
 */
@XmlRootElement(name = "Produtos")
public class GerenciadorProduto {
    
    @XmlElement(name = "Produto")
    private List<Produto> produtos;

    public GerenciadorProduto() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public boolean removerProduto(String cod) {
        for (Produto produto : produtos) {
            if (produto.getCod().equals(cod)) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso!");
                return true;
            }
        }
        System.out.println("Produto não encontrado!");
        return false;
    }

    public Produto buscarProduto(String cod) {
        for (Produto produto : produtos) {
            if (produto.getCod().equals(cod)) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarProduto(String codAntigo, Produto produtoNovo) {
        Produto produtoExistente = buscarProduto(codAntigo);
        
        if (produtoExistente != null) {
            int indice = produtos.indexOf(produtoExistente);
            produtos.set(indice, produtoNovo);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto com o nome " + codAntigo + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Produto produto : produtos) {
            saida.append(produto.toString()).append("\n");
        }
        return saida.toString();
    }

    public void salvarNoArquivo(String caminhoDoArquivo) {
        SerializadorJSONProduto serializadorJSON = new SerializadorJSONProduto();
        String jsonData = serializadorJSON.ToJSON(this.produtos);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, caminhoDoArquivo);
        System.out.println("Produtos salvos com sucesso em " + caminhoDoArquivo);
    }

    public void carregarDoArquivo(String caminhoDoArquivo) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(caminhoDoArquivo);

        SerializadorJSONProduto desserializadorJSON = new SerializadorJSONProduto();
        this.produtos = desserializadorJSON.fromJSON(jsonData);

        System.out.println("Produtos carregados com sucesso de " + caminhoDoArquivo);
    }
    
    public void salvarEmXML(String caminhoDoArquivo) {
        try {
            SerializadorXMLProduto serializadorXML = new SerializadorXMLProduto();
            String xmlData = serializadorXML.ToXML(this); // O serializador XML espera o próprio GerenciadorProduto

            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(xmlData, caminhoDoArquivo);
            System.out.println("Lista de pessoas salvas com sucesso em " + caminhoDoArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao salvar em XML: " + e.getMessage());
        }
    }

    public void carregarDeXML(String caminhoDoArquivo) {
        try {
            FilePersistence filePersistence = new FilePersistence();
            String xmlData = filePersistence.loadFromFile(caminhoDoArquivo);

            // Se o arquivo não existir ou estiver vazio, não faz nada.
            if (xmlData == null || xmlData.trim().isEmpty()) {
                System.out.println("Arquivo XML não encontrado ou vazio. Nenhum produto carregado.");
                return;
            }

            SerializadorXMLProduto desserializadorXML = new SerializadorXMLProduto();
            GerenciadorProduto temp = desserializadorXML.fromXML(xmlData);

            if (temp != null) {
                this.produtos = temp.getListaProdutos(); // Aqui vai precisar de um getter para a lista em GerenciadorProduto
                System.out.println("Lista de produtos carregada com sucesso de " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar de XML: " + e.getMessage());
        }
    }

    // Getter que foi necessário criar 
    public List<Produto> getListaProdutos() {
        return this.produtos;
    }

}
