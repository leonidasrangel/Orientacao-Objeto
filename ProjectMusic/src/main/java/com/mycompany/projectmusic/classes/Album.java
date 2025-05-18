package com.mycompany.projectmusic.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Album {
    private String nome;
    private int anoLancamento;
    private List<Musica> lstMusica;

    public Album() {
        this.nome = "";
        this.anoLancamento = 0;
        this.lstMusica = new ArrayList<>();
    }

    public Album(String nome, int anoLancamento, List<Musica> lstMusica) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.lstMusica = new ArrayList<>();
    }
    
    public void adicionarMusica(Musica musica) {
    this.lstMusica.add(musica);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<Musica> getLstMusica() {
        return this.lstMusica;
    }

    public void setLstMusica(List<Musica> lstMusica) {
        this.lstMusica = lstMusica;
    }
    
    
    
    
}
