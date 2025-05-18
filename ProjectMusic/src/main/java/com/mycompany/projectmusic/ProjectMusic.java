package com.mycompany.projectmusic;

import com.mycompany.projectmusic.classes.Album;
import com.mycompany.projectmusic.classes.Artista;
import com.mycompany.projectmusic.classes.Gerenciador;
import com.mycompany.projectmusic.classes.Musica;

public class ProjectMusic {
    public static void main(String[] args) {
        // Artista 1 e seus álbuns/músicas
        Artista artista1 = new Artista();
        artista1.setNome("Artista 1");

        Album album1 = new Album();
        album1.setNome("Álbum 1");
        album1.setAnoLancamento(2020);

        Album album2 = new Album();
        album2.setNome("Álbum 2");
        album2.setAnoLancamento(2021);

        artista1.adicionarAlbum(album1);
        artista1.adicionarAlbum(album2);

        artista1.adicionarMusica("Álbum 1", new Musica("Música 1", 3.30));
        artista1.adicionarMusica("Álbum 1", new Musica("Música 2", 4.00));
        artista1.adicionarMusica("Álbum 2", new Musica("Música 3", 3.50));

        // Artista 2 e seus álbuns/músicas
        Artista artista2 = new Artista();
        artista2.setNome("Artista 2");

        Album album3 = new Album();
        album3.setNome("Álbum A");
        album3.setAnoLancamento(2018);

        Album album4 = new Album();
        album4.setNome("Álbum B");
        album4.setAnoLancamento(2019);

        Album album5 = new Album();
        album5.setNome("Álbum C");
        album5.setAnoLancamento(2022);

        artista2.adicionarAlbum(album3);
        artista2.adicionarAlbum(album4);
        artista2.adicionarAlbum(album5);

        artista2.adicionarMusica("Álbum A", new Musica("Canção A1", 2.45));
        artista2.adicionarMusica("Álbum A", new Musica("Canção A2", 3.10));
        artista2.adicionarMusica("Álbum B", new Musica("Canção B1", 4.20));
        artista2.adicionarMusica("Álbum B", new Musica("Canção B2", 3.55));
        artista2.adicionarMusica("Álbum B", new Musica("Canção B3", 5.00));
        artista2.adicionarMusica("Álbum C", new Musica("Canção C1", 4.15));

        // Artista 3 e seus álbuns/músicas
        Artista artista3 = new Artista();
        artista3.setNome("Artista 3");

        Album album6 = new Album();
        album6.setNome("Primeiro Álbum");
        album6.setAnoLancamento(2015);

        artista3.adicionarAlbum(album6);

        artista3.adicionarMusica("Primeiro Álbum", new Musica("Hit 1", 3.50));
        artista3.adicionarMusica("Primeiro Álbum", new Musica("Hit 2", 4.10));
        artista3.adicionarMusica("Primeiro Álbum", new Musica("Hit 3", 3.20));
        artista3.adicionarMusica("Primeiro Álbum", new Musica("Hit 4", 5.00));

        // gerenciador e adicionando artistas
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.adicionarArtista(artista1);
        gerenciador.adicionarArtista(artista2);
        gerenciador.adicionarArtista(artista3);

        // Mostrando artista com mais álbuns
        Artista artistaComMaisAlbuns = gerenciador.artistaComMaisAlbuns();
        if (artistaComMaisAlbuns != null) {
            System.out.println("Artista com mais álbuns: " + artistaComMaisAlbuns.getNome());
        }

        // Mostrando álbum com mais músicas
        Album albumComMaisMusicas = gerenciador.albumComMaisMusicas();
        if (albumComMaisMusicas != null) {
            System.out.println("Álbum com mais músicas: " + albumComMaisMusicas.getNome());
        }
    }
}
