package com.mycompany.projectmusic.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Artista {
    private String nome;
    private List<Album> lstAlbum;

    @Override
    public String toString() {
        return "Artista{" + "nome = " + nome 
                + ", lstAlbum = " + lstAlbum 
                + '}';
    }
    
    public Artista() {
        this.nome = "";
        this.lstAlbum = new ArrayList<>();
    }

    public void adicionarAlbum(Album album) {
        this.lstAlbum.add(album);
    }
        
    public void adicionarMusica(String nomeAlbum, Musica musica) {
        for (Album album : lstAlbum) {
            if (album.getNome().equalsIgnoreCase(nomeAlbum)) {
                album.adicionarMusica(musica);
                return;
            }
        }
        System.out.println("Álbum \"" + nomeAlbum + "\" não encontrado para o artista " + nome + ".");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Album> getLstAlbum() {
        return this.lstAlbum;
    }

    public void setLstAlbum(List<Album> lstAlbum) {
        this.lstAlbum = lstAlbum;
    }
    
    
}
