/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import classes.Imovel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorJSONImovel {
    public String ToJSON(List<Imovel> imoveis) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(imoveis);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Imovel> fromJSON(String jsonString) {
        // Se a string do arquivo estiver vazia ou nula, já retorna uma lista vazia
        if (jsonString == null || jsonString.trim().isEmpty()) {
            return new ArrayList<>();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Imovel> imoveis = mapper.readValue(jsonString, new TypeReference<List<Imovel>>() {});
            return imoveis;
        } catch (Exception e) {
            System.err.println("Erro ao desserializar JSON: " + e.getMessage());
            return new ArrayList<>(); // Vai retornar uma lista vazia em caso de erro
        }
    }
}
