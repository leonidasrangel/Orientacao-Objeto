package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class GerenciadorPessoaFisica {
    private List<PessoaFisica> lstPessoaFisica;
    
    public GerenciadorPessoaFisica(){
        lstPessoaFisica = new ArrayList<>();
    }
    
    public void inserirPessoa(PessoaFisica pf){
        this.lstPessoaFisica.add(pf);
        System.out.println("Inserido com sucesso!");
    }
    
    public boolean removePessoa(String cpf){
        for(PessoaFisica pf : this.lstPessoaFisica){
            if(pf.getCpf().equals(cpf)){
                this.lstPessoaFisica.remove(pf);
                return true;
            }
        }
        return false;
    }
    
    public void inserirContaEmPessoa(String nomeProcurado, ContaAPagar novaConta) {
        boolean encontrou = false;

        for (PessoaFisica pf : lstPessoaFisica) {
            if (pf.getNome().equals(nomeProcurado)) {
                encontrou = true;
                
                pf.getLstContas().add(novaConta);
                break; // Assumindo que só há uma pessoa com esse nome
            }
        }

        if (!encontrou) {
            System.out.println("Não existe ninguém com este nome.");
        }
    }
    
    public PessoaFisica pesquisarPessoaPorNome(String nomeProcurado) {
        for (PessoaFisica pessoa : lstPessoaFisica) {
            if (pessoa.getNome().equals(nomeProcurado)) {
               return pessoa;
            }
        }
        return null;
    }
    public PessoaFisica pesquisarPessoaPorCPF(String cpfProcurado) {       
        for (PessoaFisica pessoa : lstPessoaFisica) {
            if (pessoa.getCpf().equals(cpfProcurado)) {
               return pessoa;
            }
        }
        return null;
    }
    
    public PessoaFisica buscarPessoa(String cpf){
        for(PessoaFisica pf : this.lstPessoaFisica){
            if(pf.getCpf().equals(cpf)){
                return pf;
            }
        }
        return null;
    }
    
    public String listarPessoa(){
        String texto = "";
        for(PessoaFisica pf : this.lstPessoaFisica){
            texto += pf.toString() + "\n";
        }
        return texto;
    }
    
    public PessoaFisica pessoaComMaiorDevedor(){
        double maiorDivida = 0.0;
        PessoaFisica pessoaDeMaiorDivida = new PessoaFisica();
        for(PessoaFisica pf : this.lstPessoaFisica){
            double divida = pf.calculaSaldoDevedor();
            if(divida > maiorDivida){
                maiorDivida = divida;
                pessoaDeMaiorDivida = pf;
            }
        }return pessoaDeMaiorDivida;
    } 
    
    public double totalDevido(){
        double total = 0.0;
        for(PessoaFisica pf : this.lstPessoaFisica){
            total += pf.calculaSaldoDevedor();
        }
        return total;
    }
}
