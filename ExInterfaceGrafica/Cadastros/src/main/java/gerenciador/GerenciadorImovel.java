package gerenciador;

import classes.Imovel;
import file.FilePersistence;
import file.SerializadorJSONImovel;
import file.SerializadorXMLImovel;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rangel
 */
@XmlRootElement(name = "Imóveis")
public class GerenciadorImovel {
    
    @XmlElement(name = "Imóvel")
    private List<Imovel> imoveis;

    public GerenciadorImovel() {
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
        System.out.println("Imóvel adicionado com sucesso!");
    }

    public boolean removerImovel(String tipoImovel) {
        for (Imovel imovel : imoveis) {
            if (imovel.getTipoImovel().equals(tipoImovel)) {
                imoveis.remove(imovel);
                System.out.println("Imóvel removido com sucesso!");
                return true;
            }
        }
        System.out.println("Imóvel não encontrado!");
        return false;
    }

    public Imovel buscarImovel(String tipoImovel) {
        for (Imovel imovel : imoveis) {
            if (imovel.getTipoImovel().equals(imovel)) {
                return imovel;
            }
        }
        return null;
    }

    public void atualizarImovel(String imovelAntigo, Imovel imovelNovo) {
        Imovel imovelExistente = buscarImovel(imovelAntigo);
        
        if (imovelExistente != null) {
            int indice = imoveis.indexOf(imovelExistente);
            imoveis.set(indice, imovelNovo);
            System.out.println("Imóvel atualizado com sucesso.");
        } else {
            System.out.println("Imóvel" + imovelAntigo + " não encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Imovel imovel : imoveis) {
            saida.append(imovel.toString()).append("\n");
        }
        return saida.toString();
    }

    public void salvarNoArquivo(String caminhoDoArquivo) {
        SerializadorJSONImovel serializadorJSON = new SerializadorJSONImovel();
        String jsonData = serializadorJSON.ToJSON(this.imoveis);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, caminhoDoArquivo);
        System.out.println("Imóveis salvos com sucesso em " + caminhoDoArquivo);
    }

    public void carregarDoArquivo(String caminhoDoArquivo) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(caminhoDoArquivo);

        SerializadorJSONImovel desserializadorJSON = new SerializadorJSONImovel();
        this.imoveis = desserializadorJSON.fromJSON(jsonData);

        System.out.println("Imóveis carregados com sucesso de " + caminhoDoArquivo);
    }
    
    public void salvarEmXML(String caminhoDoArquivo) {
        try {
            SerializadorXMLImovel serializadorXML = new SerializadorXMLImovel();
            String xmlData = serializadorXML.ToXML(this); // O serializador XML espera o próprio GerenciadorImovel

            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(xmlData, caminhoDoArquivo);
            System.out.println("Lista de imóveis salva com sucesso em " + caminhoDoArquivo);
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

            SerializadorXMLImovel desserializadorXML = new SerializadorXMLImovel();
            GerenciadorImovel temp = desserializadorXML.fromXML(xmlData);

            if (temp != null) {
                this.imoveis = temp.getListaImoveis(); // Aqui vai precisar de um getter para a lista em GerenciadorImovel
                System.out.println("Lista de imóveis carregada com sucesso de " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar de XML: " + e.getMessage());
        }
    }

    // Getter que foi necessário criar 
    public List<Imovel> getListaImoveis() {
        return this.imoveis;
    }

    public void salvarEmCSV(String caminhoDoArquivo) {
        StringBuilder csvData = new StringBuilder();

        csvData.append("Tipo;Quartos;Banheiros;Área;Preço\n");

        for (Imovel imovel : this.imoveis) {
            csvData.append(String.format("%s;%s;%d;%s\n",
                    imovel.getTipoImovel(),
                    imovel.getQtdQuartos(),
                    imovel.getQtdBanheiros(),
                    imovel.getTamArea(),
                    imovel.getPreco()
            ));
        }

        try {
            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(csvData.toString(), caminhoDoArquivo);
            System.out.println("Imóveis salvos com sucesso em " + caminhoDoArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }
    }
}
