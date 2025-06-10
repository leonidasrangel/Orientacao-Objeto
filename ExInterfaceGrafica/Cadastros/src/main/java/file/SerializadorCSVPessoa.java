package file;

import classes.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class SerializadorCSVPessoa {

    public String toCSV(List<Pessoa> pessoas) {
        String csv = "Nome;CPF;Idade;Sexo;\n";
        for (Pessoa pessoa : pessoas) {
            csv += pessoa.getNome() + ";" 
                + pessoa.getCpf() + ";"
                + pessoa.getIdade() + ";"
                + pessoa.getSexo() + ";\n";
        }
        return csv;
    }

    public List<Pessoa> fromCSV(String data) {
        List<Pessoa> pessoas = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(partes[0]);
                pessoa.setCpf(partes[1]);
                pessoa.setIdade(Integer.parseInt(partes[2]));
                pessoa.setSexo((partes[3]));
                

                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }
}
