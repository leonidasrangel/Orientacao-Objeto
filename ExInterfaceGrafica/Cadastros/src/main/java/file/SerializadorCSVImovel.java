/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import classes.Imovel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorCSVImovel {
    public String toCSV(List<Imovel> imoveis) {
        String csv = "Tipo;Quartos;Banheiros;Área;Preco;\n";
        for (Imovel imovel : imoveis) {
            csv += imovel.getTipoImovel() + ";" 
                + imovel.getQtdQuartos() + ";"
                + imovel.getQtdBanheiros() + ";"
                + imovel.getTamArea() + ";"
                + imovel.getPreco() + ";\n";
        }
        return csv;
    }

    public List<Imovel> fromCSV(String data) {
        List<Imovel> imoveis = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 5) {
                Imovel imovel = new Imovel();
                imovel.setTipoImovel(partes[0]);
                imovel.setQtdQuartos(Integer.parseInt(partes[1]));
                imovel.setQtdBanheiros(Integer.parseInt(partes[2]));
                imovel.setTamArea(Double.parseDouble(partes[3]));
                imovel.setPreco(Double.parseDouble(partes[4]));
                

                imoveis.add(imovel);
            }
        }
        return imoveis;
    }
}
