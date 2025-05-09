/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadfilme;

import classes.Filme;
import classes.GerenciadorFilmes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class CadFilme {

    public static int imprimeMenu() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("1 - Inserir filme.");
        System.out.println("2 - Pesquisar pelo nome do filme.");
        System.out.println("3 - Pesquisar pelo diretor do filme.");
        System.out.println("4 - Listar todos os filmes.");
        System.out.println("5 - Remover filme pelo nome.");
        System.out.println("6 - Remover filme pelo nome do diretor.");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.print("Escolha uma opção:");

        int opcao = leitor.nextInt();
        leitor.nextLine();
        return opcao;
    }
    public static void main(String[] args) {
        
        GerenciadorFilmes gerenciadorFilmes = new GerenciadorFilmes();
        Scanner leitor = new Scanner(System.in);
        int opcao;
        
        do {
            opcao = imprimeMenu();
            switch(opcao){
                case 1: {
                    Filme novoFilme = new Filme();
                    novoFilme.preencher();
                    gerenciadorFilmes.adicionarFilme(novoFilme);
                    break;
                }
                case 2: {
                    System.out.println("Informe o nome do filme para pesquisar: ");
                    String titulo = leitor.nextLine();
                    
                    Filme filme = gerenciadorFilmes.pesquisarFilmeTitulo(titulo);
                    if (filme != null){
                        filme.imprimir();
                    }else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Informe o nome do diretor para pesquisar: ");
                    String diretor = leitor.nextLine();
                    
                    List<Filme> filmeDiretor = gerenciadorFilmes.pesquisarFilmeDiretor(diretor);
                    if(filmeDiretor.isEmpty()){
                        System.out.println("Nenhum filme encontrado para esse diretor.");
                    }else{
                        for(Filme F1 : filmeDiretor){
                            F1.imprimir();
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Filmes cadastrados:");
                    gerenciadorFilmes.imprimirTodosFilmes();
                    break;
                }
                case 5: {
                    System.out.println("Informe o nome do filme para remover:");
                    String titulo = leitor.nextLine();
                    
                    if(gerenciadorFilmes.removerFilmeTitulo(titulo)){
                        System.out.println("Filme removido com sucesso.");
                    }else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Informe o nome do diretor para remover:");
                    String diretor = leitor.nextLine();
                    
                    if(gerenciadorFilmes.removerFilmeDiretor(diretor)){
                        System.out.println("Filme removido com sucesso.");
                    }else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                }
            }
            
        }while (opcao != 0);
        leitor.close();
    }
    
}
