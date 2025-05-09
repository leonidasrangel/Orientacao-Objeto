package classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFilmes {
    private List<Filme> listaFilmes;
    
    public GerenciadorFilmes(){
        this.listaFilmes = new ArrayList<>();
    }
    public void adicionarFilme(Filme filme){
        listaFilmes.add(filme);
    }
public boolean removerFilmeTitulo(String titulo){
    for (int i = 0; i < listaFilmes.size(); i++){
        Filme F1 = listaFilmes.get(i);
        if (F1.getTitulo().equals(titulo)){
            listaFilmes.remove(i);
            return true;
            }
        }
    return false;
    }
public boolean removerFilmeDiretor(String diretor){
    for (int i = 0; i < listaFilmes.size(); i++){
        Filme F1 = listaFilmes.get(i);
        if (F1.getDiretor().equals(diretor)){
            listaFilmes.remove(i);
            return true;
            }
        }
    return false;
    }
public Filme pesquisarFilmeTitulo(String titulo){
    for(Filme filme : listaFilmes){
        if(filme.getTitulo().equalsIgnoreCase(titulo)){
            return filme;
            }
        }
    return null;
    }
public List<Filme> pesquisarFilmeDiretor(String diretor){
    List<Filme> encontrados = new ArrayList<>();
    for(Filme filme : listaFilmes){
        if(filme.getDiretor().equalsIgnoreCase(diretor)){
            encontrados.add(filme);
        }
    }
    return encontrados;
}

public void imprimirTodosFilmes(){
    for (Filme filme : listaFilmes){
        filme.imprimir();
        }
    }
}
