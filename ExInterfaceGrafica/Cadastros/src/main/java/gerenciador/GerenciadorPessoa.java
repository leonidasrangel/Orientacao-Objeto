package gerenciador;

import classes.Pessoa;
import file.FilePersistence;
import file.SerializadorJSONPessoa;
import file.SerializadorXMLPessoa;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rangel
 */
@XmlRootElement(name = "Pessoas")
public class GerenciadorPessoa {
    
    @XmlElement(name = "Pessoa")
    private List<Pessoa> pessoas;

    public GerenciadorPessoa() {
        this.pessoas = new ArrayList<>();
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    public boolean removerPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoas.remove(pessoa);
                System.out.println("Pessoa removida com sucesso!");
                return true;
            }
        }
        System.out.println("Pessoa não encontrada!");
        return false;
    }

    public Pessoa buscarPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }

    public void atualizarPessoa(String cpfAntigo, Pessoa pessoaNova) {
        Pessoa pessoaExistente = buscarPessoa(cpfAntigo);
        
        if (pessoaExistente != null) {
            int indice = pessoas.indexOf(pessoaExistente);
            pessoas.set(indice, pessoaNova);
            System.out.println("Pessoa atualizada com sucesso.");
        } else {
            System.out.println("Pessoa com o CPF \"" + cpfAntigo + "\" não encontrada.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            saida.append(pessoa.toString()).append("\n");
        }
        return saida.toString();
    }
    
    public void salvarNoArquivo(String caminhoDoArquivo) {
        SerializadorJSONPessoa serializadorJSON = new SerializadorJSONPessoa();
        String jsonData = serializadorJSON.ToJSON(this.pessoas);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, caminhoDoArquivo);
        System.out.println("Lista de pessoas salvas com sucesso em " + caminhoDoArquivo);
    }

    public void carregarDoArquivo(String caminhoDoArquivo) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(caminhoDoArquivo);

        //Desserializando JSON
        SerializadorJSONPessoa desserializadorJSON = new SerializadorJSONPessoa();
        this.pessoas = desserializadorJSON.fromJSON(jsonData);

        System.out.println("Lista de pessoas carregadas com sucesso de " + caminhoDoArquivo);
    }
    

    public void salvarEmXML(String caminhoDoArquivo) {
        try {
            SerializadorXMLPessoa serializadorXML = new SerializadorXMLPessoa();
            String xmlData = serializadorXML.ToXML(this); // O serializador XML espera o próprio GerenciadorPessoa

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
                System.out.println("Arquivo XML não encontrado ou vazio. Nenhuma pessoa carregada.");
                return;
            }

            SerializadorXMLPessoa desserializadorXML = new SerializadorXMLPessoa();
            GerenciadorPessoa temp = desserializadorXML.fromXML(xmlData);

            if (temp != null) {
                this.pessoas = temp.getListaPessoas(); // Aqui vai precisar de um getter para a lista em GerenciadorPessoa
                System.out.println("Lista de pessoas carregadas com sucesso de " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar de XML: " + e.getMessage());
        }
    }

    // Getter que foi necessário criar 
    public List<Pessoa> getListaPessoas() {
        return this.pessoas;
    }
    
    
}
