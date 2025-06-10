package gerenciador;

import Classes.Carro;
import file.FilePersistence;
import file.SerializadorJSONCarro;
import file.SerializadorXMLCarro;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rangel
 */
@XmlRootElement(name = "Veiculos")
public class GerenciadorCarro {
    
    @XmlElement(name = "Veiculo")
    private List<Carro> carros;

    public GerenciadorCarro() {
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
        System.out.println("Veículo adicionado com sucesso!");
    }

    public boolean removerCarro(String marca) {
        for (Carro carro : carros) {
            if (carro.getMarca().equals(marca)) {
                carros.remove(carro);
                System.out.println("Veículo removido com sucesso!");
                return true;
            }
        }
        System.out.println("Veículo não encontrado!");
        return false;
    }

    public Carro buscarCarro(String marca) {
        for (Carro carro : carros) {
            if (carro.getMarca().equals(marca)) {
                return carro;
            }
        }
        return null;
    }

    public void atualizarCarro(String marcaAntiga, Carro marcaNova) {
        Carro veiculoExistente = buscarCarro(marcaAntiga);
        
        if (veiculoExistente != null) {
            int indice = carros.indexOf(veiculoExistente);
            carros.set(indice, marcaNova);
            System.out.println("Veículo atualizado com sucesso.");
        } else {
            System.out.println("Veículo com marca " + marcaAntiga + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Carro carro : carros) {
            saida.append(carro.toString()).append("\n");
        }
        return saida.toString();
    }

    public void salvarNoArquivo(String caminhoDoArquivo) {
        SerializadorJSONCarro serializadorJSON = new SerializadorJSONCarro();
        String jsonData = serializadorJSON.ToJSON(this.carros);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, caminhoDoArquivo);
        System.out.println("Veículos salvos com sucesso em " + caminhoDoArquivo);
    }

    public void carregarDoArquivo(String caminhoDoArquivo) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(caminhoDoArquivo);

        SerializadorJSONCarro desserializadorJSON = new SerializadorJSONCarro();
        this.carros = desserializadorJSON.fromJSON(jsonData);

        System.out.println("Veículos carregados com sucesso de " + caminhoDoArquivo);
    }
    
    public void salvarEmXML(String caminhoDoArquivo) {
        try {
            SerializadorXMLCarro serializadorXML = new SerializadorXMLCarro();
            String xmlData = serializadorXML.ToXML(this); // O serializador XML espera o próprio GerenciadorCarro

            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(xmlData, caminhoDoArquivo);
            System.out.println("Lista de veículos salva com sucesso em " + caminhoDoArquivo);
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

            SerializadorXMLCarro desserializadorXML = new SerializadorXMLCarro();
            GerenciadorCarro temp = desserializadorXML.fromXML(xmlData);

            if (temp != null) {
                this.carros = temp.getListaCarros(); // Aqui vai precisar de um getter para a lista em GerenciadorCarro
                System.out.println("Lista de veículos carregada com sucesso de " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar de XML: " + e.getMessage());
        }
    }

    // Getter que foi necessário criar 
    public List<Carro> getListaCarros() {
        return this.carros;
    }

    public void salvarEmCSV(String caminhoDoArquivo) {
        StringBuilder csvData = new StringBuilder();

        csvData.append("Marca;Modelo;Ano;Preço\n");

        for (Carro carro : this.carros) {
            csvData.append(String.format("%s;%s;%d;%s\n",
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.getPreco()
            ));
        }

        try {
            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(csvData.toString(), caminhoDoArquivo);
            System.out.println("Veículos salvos com sucesso em " + caminhoDoArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }
    }
}
