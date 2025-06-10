package file;

import classes.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorJSONProduto {

    public String ToJSON(List<Produto> produtos) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(produtos);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Desserializa JSON em formato String para um objeto Filme
    public List<Produto> fromJSON(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
             
            List<Produto> produtos = mapper.readValue(jsonString, new TypeReference<List<Produto>>() {});
           // GerenciadorProduto produtos = mapper.readValue(jsonString, GerenciadorProduto.class);
            
            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
