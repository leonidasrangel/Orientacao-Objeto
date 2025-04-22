/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadmusica;

import classes.Musica;
import java.util.ArrayList;
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
        System.out.println("1 - Inserir música");
        System.out.println("2 - Remover música");
        System.out.println("3 - Pesquisar pelo nome da música");
        System.out.println("4 - Pesquisar pelo artista");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opção:");

        return leitor.nextInt();
    }
     
    public static void main(String[] args) {
        List<Musica> listaMusicas;
        listaMusicas = new ArrayList<Musica>();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        
        do {
            opcao = imprimeMenu();
            if (opcao == 1) { //insercao
                Musica M1 = new Musica();
                M1.preencher();
                listaMusicas.add(M1);
            } else if (opcao == 2) {//remocao
                System.out.println("Informe a música:");
                String music = leitor.nextLine();

                for (int i = 0; i <= listaMusicas.size() - 1; i++) {
                    Musica M1 = listaMusicas.get(i);
                    if (music.equals(M1.getTitulo())) {
                        System.out.println("Música encontrada e removida");
                        listaMusicas.remove(M1);
                    }
                }                
            } else if (opcao == 3) {//pesquisa titulo
                System.out.println("Informe o artista:");
                String music = leitor.nextLine();

                for (int i = 0; i <= listaMusicas.size() - 1; i++) {
                    Musica M1 = listaMusicas.get(i);
                    if (music.equals(M1.getTitulo())) {
                        System.out.println("Música encontrada");
                        M1.imprimir();
                    }
                }                
            } else if (opcao == 4) { //pesquisa autor               
                System.out.println("Informe o artista:");
                String artist = leitor.nextLine();

                for (int i = 0; i <= listaMusicas.size() - 1; i++) {
                    Musica M1 = listaMusicas.get(i);
                    if (artist.equals(M1.getArtista())) {
                        System.out.println("Artista encontrado");
                        M1.imprimir();
                    }
                }
            }
        } while (opcao != 0);
    }
    
}
