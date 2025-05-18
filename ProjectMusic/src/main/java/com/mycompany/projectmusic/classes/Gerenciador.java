package com.mycompany.projectmusic.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Gerenciador {
    
    private List<Artista> artistas;
    
    public Gerenciador() {
        this.artistas = new ArrayList<>();
    }
    
    public void adicionarArtista(Artista artista) {
        artistas.add(artista);
    }
    
    //MÉTODO: Artista com maior número de álbuns
    public Artista artistaComMaisAlbuns() {
        if (artistas.isEmpty()) return null;

        Artista topArtista = null;
        int maxAlbuns = -1;

        for (Artista artista : artistas) {
            int totalAlbuns = artista.getLstAlbum() != null ? artista.getLstAlbum().size() : 0;

            if (totalAlbuns > maxAlbuns) {
                maxAlbuns = totalAlbuns;
                topArtista = artista;
            }
        }

        return topArtista;
    }

    //MÉTODO: Álbum com maior quantidade de músicas
    public Album albumComMaisMusicas() {
        if (artistas.isEmpty()) return null;

        Album topAlbum = null;
        int maxMusicas = -1;

        for (Artista artista : artistas) {
            if (artista.getLstAlbum() != null) {
                for (Album album : artista.getLstAlbum()) {
                    int totalMusicas = album.getLstMusica() != null ? album.getLstMusica().size() : 0;

                    if (totalMusicas > maxMusicas) {
                        maxMusicas = totalMusicas;
                        topAlbum = album;
                    }
                }
            }
        }

        return topAlbum;
    }
}
