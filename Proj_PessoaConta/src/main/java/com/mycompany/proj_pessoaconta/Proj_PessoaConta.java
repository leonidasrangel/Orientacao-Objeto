package com.mycompany.proj_pessoaconta;

import classes.ContaAPagar;
import classes.GerenciadorPessoaFisica;
import classes.PessoaFisica;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Proj_PessoaConta {
    
    public static int imprimeMenu() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("\n\t------- Sistema PessoaFisica e suas contas -------");
        System.out.println("\t1 - Inserir Pessoa");
        System.out.println("\t2 - Remover Pessoa");
        System.out.println("\t3 - Inserir conta a uma pessoa");
        System.out.println("\t4 - Pesquisar Pessoa (cpf)");
        System.out.println("\t5 - Pesquisar Pessoa (nome)");
        System.out.println("\t6 - Pessoa com maior devedor ");
        System.out.println("\t7 - Total devido por todas pessoas ");
        System.out.println("\t0 - Sair");
        System.out.println("\t-----------------------------------------");
        System.out.print("\tEscolha uma opção:");

        return leitor.nextInt();
    }

    public static void main(String[] args) {
        GerenciadorPessoaFisica gerenciador = new GerenciadorPessoaFisica();
        Scanner reader = new Scanner(System.in);
        String nomeProcurado, cpfProcurado;
        PessoaFisica pessoa = new PessoaFisica();
        
        PessoaFisica p = new PessoaFisica();
        p.copiar(pessoa);

        int opcao;
        do {
            opcao = imprimeMenu();

            switch (opcao) {
                case 1: //Adicionar pessoa fisica
                    pessoa = new PessoaFisica();
                    pessoa = criarPessoaFisicaComContas(reader);
                    
                    gerenciador.inserirPessoa(pessoa);
                    break;
                case 2: // Remover pessoa fisica
                    System.out.print("Remoção: Informe o CPF da pessoa:");
                    cpfProcurado = reader.nextLine();

                    gerenciador.removePessoa(cpfProcurado);
                    break;
                case 3:// Adicionar contaAPagar para uma pessoaFisica
                    System.out.print("Informe o nome da pessoa:");
                    nomeProcurado = reader.nextLine();
                    ContaAPagar novaConta = criarContaAPagar(reader);

                    gerenciador.inserirContaEmPessoa(nomeProcurado, novaConta);
                    break;
                case 4://Procurar uma pessoa pelo CPF
                    System.out.print("Informe o CPF pessoa:");
                    cpfProcurado = reader.nextLine();

                    pessoa = gerenciador.pesquisarPessoaPorCPF(cpfProcurado);
                    if (pessoa == null) {
                        System.out.println("CPF não cadastrado.");
                    } else {
                        System.out.println(pessoa);
                    }
                    break;
                case 5://Procurar uma pessoa pelo nome
                    System.out.print("Informe o nome da pessoa:");
                    nomeProcurado = reader.nextLine();

                    pessoa = gerenciador.pesquisarPessoaPorNome(nomeProcurado);
                    if (pessoa == null) {
                        System.out.println("Nome não cadastrado.");
                    } else {
                        System.out.println(pessoa);
                    }

                    break;
                case 6://Procurar pessoa com maior saldo devedor
                    pessoa = gerenciador.pessoaComMaiorDevedor();

                    System.out.println("A maior dívida é: " + pessoa.calculaSaldoDevedor());
                    System.out.println("Ela é referente à Pessoa Física:");
                    pessoa.imprimir();

                    //System.out.println(pessoa); //usando toString()
                    break;
                case 7: //Calcular o total da divida de todas as pessoas.
                    double total = gerenciador.totalDevido();
                    System.out.println("O total devido e:"+ total);
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
    
    private static PessoaFisica criarPessoaFisicaComContas(Scanner leitor) {
        
        System.out.println("------ Preenchendo dados da Pessoa Física -----");
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
       
        System.out.print("Email: ");
        String email = leitor.nextLine();
      
        System.out.print("Cpf: ");
        String cpf = leitor.nextLine();

        PessoaFisica pessoa = new PessoaFisica(nome, cpf, email);

        
        String resposta = "n";
        do{
            ContaAPagar conta = criarContaAPagar(leitor);
             pessoa.addContaAPagar(conta);
            
            System.out.print("Deseja inserir mais conta(s/n) ?");
            resposta = leitor.next();            
        }while(resposta.equals("s"));  

        return pessoa;
    }

    private static ContaAPagar criarContaAPagar(Scanner leitor) {        
        
        System.out.println("------ Preenchendo dados da Conta a Pagar -----");
        System.out.print("ID da conta: ");
        int id = leitor.nextInt();
        leitor.nextLine(); // Consome a quebra de linha após a leitura do número
       
        System.out.print("Código de barras: ");
        String codBarras = leitor.nextLine();
        
        System.out.print("Valor da conta: ");
        double valor = leitor.nextDouble();
        leitor.nextLine(); // Consome a quebra de linha após a leitura do número
        
        return new ContaAPagar(id, codBarras, valor);
    }

}
