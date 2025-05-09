package classes;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> listaLivros;

    public Biblioteca() {
        this.listaLivros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public boolean removerLivroTitulo(String titulo) {
        for (int i = 0; i < listaLivros.size(); i++) {
            Livro li = listaLivros.get(i);
            if (li.getTitle().equals(titulo)) {
                listaLivros.remove(i);
                return true;
            }
        }
        return false;
    }
    
        public boolean removerLivroPorAutor(String author) {
        for (int i = 0; i < listaLivros.size(); i++) {
            Livro li = listaLivros.get(i);
            if (li.getAuthor().equals(author)) {
                listaLivros.remove(i);
                return true;
            }
        }
        return false;
    }

    public Livro pesquisarLivroPorTitulo(String titulo) {
        for (Livro livro : listaLivros) {		        
            if (livro.getTitle().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : listaLivros) {
            if (livro.getAuthor().equalsIgnoreCase(autor)) {
            encontrados.add(livro);
            }
        }
        return encontrados;
    }


    public void imprimirTodosLivros() {
        for (Livro livro : listaLivros) {
            livro.imprimir();
        }
    }

    // Pode-se adicionar métodos para pesquisar por autor, listar por gênero, etc.
}