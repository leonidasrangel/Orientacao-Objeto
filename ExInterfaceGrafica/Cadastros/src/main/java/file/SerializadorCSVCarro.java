package file;

import Classes.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorCSVCarro {
    public String toCSV(List<Carro> carros) {
        String csv = "Marca;Modelo;Ano;Preco;\n";
        for (Carro carro : carros) {
            csv += carro.getMarca() + ";" 
                + carro.getModelo() + ";"
                + carro.getAno() + ";"
                + carro.getPreco() + ";\n";
        }
        return csv;
    }

    public List<Carro> fromCSV(String data) {
        List<Carro> carros = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Carro carro = new Carro();
                carro.setMarca(partes[0]);
                carro.setModelo(partes[1]);
                carro.setAno(Integer.parseInt(partes[2]));
                carro.setPreco(Integer.parseInt(partes[3]));
                

                carros.add(carro);
            }
        }
        return carros;
    }
}
