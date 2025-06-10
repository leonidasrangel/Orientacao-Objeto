package file;

import Classes.Carro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorJSONCarro {
    public String ToJSON(List<Carro> carros) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(carros);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Carro> fromJSON(String jsonString) {
        // Se a string do arquivo estiver vazia ou nula, já retorna uma lista vazia
        if (jsonString == null || jsonString.trim().isEmpty()) {
            return new ArrayList<>();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Carro> pessoas = mapper.readValue(jsonString, new TypeReference<List<Carro>>() {});
            return pessoas;
        } catch (Exception e) {
            System.err.println("Erro ao desserializar JSON: " + e.getMessage());
            return new ArrayList<>(); // Vai retornar uma lista vazia em caso de erro
        }
    }
}
