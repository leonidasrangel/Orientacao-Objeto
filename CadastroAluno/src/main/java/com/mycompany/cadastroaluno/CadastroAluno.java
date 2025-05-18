package com.mycompany.cadastroaluno;

import classes.Estudante;
import classes.Telefone;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class CadastroAluno {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Estudante> estudantes = new ArrayList<>();

        System.out.print("Quantos estudantes deseja cadastrar? ");
        int qtd = leitor.nextInt();
        leitor.nextLine(); // limpar buffer

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n--- Estudante " + (i + 1) + " ---");
            Estudante est = new Estudante();
            est.preencher();
            estudantes.add(est);
        }

        System.out.println("\n=== Lista de Estudantes Cadastrados ===");
        for (Estudante est : estudantes) {
            est.imprimir();
            for (Telefone tel : est.getLstTelefone()) {
                tel.imprimir();
            }
            System.out.println();
        }

        verificarEstudantesPorDDDOperadora(estudantes);
    }

    public static void verificarEstudantesPorDDDOperadora(List<Estudante> estudantes) {
        System.out.println("=== Estudantes com o mesmo DDD ===");
        for (int i = 0; i < estudantes.size(); i++) {
            Estudante e1 = estudantes.get(i);
            for (int j = i + 1; j < estudantes.size(); j++) {
                Estudante e2 = estudantes.get(j);

                for (Telefone t1 : e1.getLstTelefone()) {
                    for (Telefone t2 : e2.getLstTelefone()) {
                        if (t1.getDdd().equals(t2.getDdd())) {
                            System.out.println(e1.getNome() + " e " + e2.getNome()
                                    + " possuem telefones com DDD: " + t1.getDdd());
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("\n=== Estudantes com a mesma operadora ===");
        for (int i = 0; i < estudantes.size(); i++) {
            Estudante e1 = estudantes.get(i);
            for (int j = i + 1; j < estudantes.size(); j++) {
                Estudante e2 = estudantes.get(j);

                for (Telefone t1 : e1.getLstTelefone()) {
                    for (Telefone t2 : e2.getLstTelefone()) {
                        if (t1.getOperadora().equalsIgnoreCase(t2.getOperadora())) {
                            System.out.println(e1.getNome() + " e " + e2.getNome()
                                    + " usam a operadora: " + t1.getOperadora());
                            break;
                        }
                    }
                }
            }
        }
    }
}