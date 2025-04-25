/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Musica {
    private String titulo;
    private String artista;
    private double duracao;
    private double preco;
    
    public Musica(){
        this.titulo = "";
        this.artista = "";
        this.duracao = 0;
        this.preco = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados da música  -----------------");
        System.out.print("Infome o titulo: ");
        this.titulo = leitor.next();
        System.out.print("Informe o artista: ");
        this.artista = leitor.next();
        System.out.print("Informe a duração da musica: ");
        this.duracao = leitor.nextDouble();
        System.out.print("Informe o preço: ");
        this.preco = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Título "+ this.titulo);
        System.out.println("Diretor: "+ this.artista);
        System.out.println("Duração: "+ this.duracao);
        System.out.println("Preço: "+ this.preco);
    }
        public void copiar(Musica outro){
        this.titulo = outro.getTitulo();
        this.artista = outro.getArtista();
        this.duracao = outro.getDuracao();
        this.preco = outro.getPreco();
    }
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        public String getTitulo(){
            return this.titulo;
        }
        public void setArtista(String artista){
            this.artista = artista;
        }
        public String getArtista(){
            return this.artista;
        }
        public void setDuracao(double duracao){
            this.duracao = duracao;
        }
        public double getDuracao(){
            return this.duracao;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public double getPreco(){
            return this.preco;
        }
}
