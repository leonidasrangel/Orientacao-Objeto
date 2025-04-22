/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadfilme;

import classes.Filme;
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
        System.out.println("1 - Inserir filme");
        System.out.println("2 - Remover filme");
        System.out.println("3 - Pesquisar pelo nome do filme");
        System.out.println("4 - Pesquisar pelo diretor do filme");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opção:");

        return leitor.nextInt();
    }
public static void main(String[] args) {
        List<Filme> listaFilmes;
        listaFilmes = new ArrayList<Filme>();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        
        do {
            opcao = imprimeMenu();
            if (opcao == 1) { //insercao
                Filme F1 = new Filme();
                F1.preencher();
                listaFilmes.add(F1);
            } else if (opcao == 2) {//remocao
                System.out.println("Informe o filme:");
                String movie = leitor.nextLine();

                for (int i = 0; i <= listaFilmes.size() - 1; i++) {
                    Filme F1 = listaFilmes.get(i);
                    if (movie.equals(F1.getTitulo())) {
                        System.out.println("Filme encontrado e removido");
                        listaFilmes.remove(F1);
                    }
                }                
            } else if (opcao == 3) {//pesquisa titulo
                System.out.println("Informe o titulo:");
                String movie = leitor.nextLine();

                for (int i = 0; i <= listaFilmes.size() - 1; i++) {
                    Filme F1 = listaFilmes.get(i);
                    if (movie.equals(F1.getTitulo())) {
                        System.out.println("Filme encontrado");
                        F1.imprimir();
                    }
                }                
            } else if (opcao == 4) { //pesquisa autor               
                System.out.println("Informe o diretor:");
                String director = leitor.nextLine();

                for (int i = 0; i <= listaFilmes.size() - 1; i++) {
                    Filme F1 = listaFilmes.get(i);
                    if (director.equals(F1.getDiretor())) {
                        System.out.println("Diretor encontrado");
                        F1.imprimir();
                    }
                }
            }
        } while (opcao != 0);
    }
    
}
