package classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorMusicas {
    private List<Musica> listaMusicas;
    
    public GerenciadorMusicas(){
        this.listaMusicas = new ArrayList<>();
    }
    public void adicionarMusica(Musica musica){
        listaMusicas.add(musica);
    }
public boolean removerMusicaTitulo(String titulo){
    for (int i = 0; i < listaMusicas.size(); i++){
        Musica m1 = listaMusicas.get(i);
        if (m1.getTitulo().equals(titulo)){
            listaMusicas.remove(i);
            return true;
            }
        }
    return false;
    }
public boolean removerMusicaArtista(String artista){
    for (int i = 0; i < listaMusicas.size(); i++){
        Musica m1 = listaMusicas.get(i);
        if (m1.getArtista().equals(artista)){
            listaMusicas.remove(i);
            return true;
            }
        }
    return false;
    }
public Musica pesquisarMusicaTitulo(String titulo){
    for(Musica musica : listaMusicas){
        if(musica.getTitulo().equalsIgnoreCase(titulo)){
            return musica;
            }
        }
    return null;
    }

public List<Musica> pesquisarMusicaArtista(String artista){
    List<Musica> encontrados = new ArrayList<>();
    for(Musica musica : listaMusicas){
        if(musica.getArtista().equalsIgnoreCase(artista)){
            encontrados.add(musica);
        }
    }
    return encontrados;
}
public void imprimirTodasMusicas(){
    for (Musica musica : listaMusicas){
        musica.imprimir();
        }
    }
}
