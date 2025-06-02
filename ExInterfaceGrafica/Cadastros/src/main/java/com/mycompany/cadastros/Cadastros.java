package com.mycompany.cadastros;

import gui.FrCadPessoa;
import gui.FrCadProfessor;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */

// A janela da interface gráfica será aberta conforme a escolha. 

public class Cadastros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro de Pessoas");
            System.out.println("2 - Cadastro de Professores");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    FrCadPessoa telaPessoa = new FrCadPessoa();
                    telaPessoa.setVisible(true);
                    break;
                case 2:
                    FrCadProfessor telaProfessor = new FrCadProfessor();
                    telaProfessor.setVisible(true);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
