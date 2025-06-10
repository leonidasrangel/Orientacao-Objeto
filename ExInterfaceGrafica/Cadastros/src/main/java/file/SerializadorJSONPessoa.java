package file;

import classes.Pessoa;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;

/**
 *
 * @author Rangel
 */
public class SerializadorJSONPessoa {
    public String ToJSON(List<Pessoa> pessoas) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(pessoas);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pessoa> fromJSON(String jsonString) {
        // Se a string do arquivo estiver vazia ou nula, já retorna uma lista vazia
        if (jsonString == null || jsonString.trim().isEmpty()) {
            return new ArrayList<>();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Pessoa> pessoas = mapper.readValue(jsonString, new TypeReference<List<Pessoa>>() {});
            return pessoas;
        } catch (Exception e) {
            System.err.println("Erro ao desserializar JSON: " + e.getMessage());
            return new ArrayList<>(); // Vai retornar uma lista vazia em caso de erro
        }
    }
}
