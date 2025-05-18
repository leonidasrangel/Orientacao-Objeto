package com.mycompany.projectmusic.classes;

/**
 *
 * @author Rangel
 */
public class Musica {
    private String titulo;
    private double duracao;

    public Musica() {
        this.titulo = "";
        this.duracao = 0.0;
    }

    public Musica(String titulo, double duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Musica{" + "titulo = " + titulo 
                + ", duracao = " + duracao 
                + '}';
    }
    

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
    
    
    
}
