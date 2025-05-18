package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class PessoaFisica {
    private String nome;
    private String cpf;
    private String email;
    
    private List<ContaAPagar> lstContas;

    public PessoaFisica() {
        this.nome = "";
        this.cpf = "";
        this.email = "";
        
        this.lstContas = new ArrayList<>();
    }

    public PessoaFisica(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.lstContas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", lstContas=" + lstContas + '}';
    }
    public void imprimir(){
        System.out.println("this");
    }
    public void copiar(PessoaFisica outra){
        this.nome = outra.getNome();
        this.cpf = outra.getCpf();
        this.email = outra.getEmail();
        
        this.lstContas = new ArrayList<>();
        for(ContaAPagar c : outra.getLstContas()){
            this.lstContas.add(c);
        }
    }
    
    public double calculaSaldoDevedor(){
        double totalDevedor = 0.0;
        
        for(ContaAPagar conta : this.lstContas){
            totalDevedor += conta.getValor();
        }
        return totalDevedor;
    }
    
    public void addContaAPagar(ContaAPagar nova){
        this.lstContas.add(nova);
    }
    
    public void removerContaAPagar(int idConta){
        for(ContaAPagar conta : this.lstContas){
            if(conta.getId() == idConta){
                this.lstContas.remove(conta);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public List<ContaAPagar> getLstContas() {
        return lstContas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLstContas(List<ContaAPagar> lstContas) {
        this.lstContas = lstContas;
    }   
    
}
