/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadmusica;

import classes.GerenciadorMusicas;
import classes.Musica;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class CadMusica {

     public static int imprimeMenu() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("1 - Inserir música.");
        System.out.println("2 - Pesquisar pelo nome da música."); 
        System.out.println("3 - Pesquisar pelo nome do artista."); 
        System.out.println("4 - Listar todas as musicas cadastradas."); 
        System.out.println("5 - Remover música por nome.");
        System.out.println("6 - Remover música por artista.");
        System.out.println("0 - Sair.");
        System.out.println("-----------------------------");
        System.out.print("Escolha uma opção: ");

        int opcao = leitor.nextInt();
        leitor.nextLine();
        return opcao;
    }
     
    public static void main(String[] args) {
        GerenciadorMusicas gerenciadorMusicas = new GerenciadorMusicas();
        Scanner leitor = new Scanner(System.in);
        int opcao;
        
        do {
            opcao = imprimeMenu();
            switch(opcao){
                case 1: {
                    Musica novaMusica = new Musica();
                    novaMusica.preencher();
                    gerenciadorMusicas.adicionarMusica(novaMusica);
                    break;
                }
                case 2: {
                    System.out.println("Informe o nome da música para pesquisar: ");
                    String titulo = leitor.nextLine();
                    
                    Musica musica = gerenciadorMusicas.pesquisarMusicaTitulo(titulo);
                    if (musica != null){
                        musica.imprimir();
                    }else {
                        System.out.println("Musica não encontrada.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Informe o nome do artista para pesquisar: ");
                    String artista = leitor.nextLine();
                    
                    List<Musica> musicaArtista = gerenciadorMusicas.pesquisarMusicaArtista(artista);
                    if(musicaArtista.isEmpty()){
                        System.out.println("Nenhuma musica encontrada para esse artista.");
                    }else{
                        for(Musica m1 : musicaArtista){
                            m1.imprimir();
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Músicas cadastradas:");
                    gerenciadorMusicas.imprimirTodasMusicas();
                    break;
                }
                case 5: {
                    System.out.println("Informe o nome da música para remover:");
                    String titulo = leitor.nextLine();
                    
                    if(gerenciadorMusicas.removerMusicaTitulo(titulo)){
                        System.out.println("Música removida com sucesso.");
                    }else {
                        System.out.println("Música não encontrada.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Informe o nome do artista para remover:");
                    String artista = leitor.nextLine();
                    
                    if(gerenciadorMusicas.removerMusicaArtista(artista)){
                        System.out.println("Música removida com sucesso.");
                    }else {
                        System.out.println("Música não encontrada.");
                    }
                    break;
                }
            }
            
        }while (opcao != 0);
        leitor.close();
    }
    
}
