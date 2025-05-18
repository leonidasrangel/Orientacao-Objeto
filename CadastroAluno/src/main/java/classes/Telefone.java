package classes;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Telefone {
    private String ddd;
    private String numero;
    private String descricao;
    private String operadora;

    public Telefone() {
        this.ddd = "";
        this.numero = "";
        this.descricao = "";
        this.operadora = "";
    }

    public Telefone(String ddd, String numero, String descricao, String operadora) {
        this.ddd = ddd;
        this.numero = numero;
        this.descricao = descricao;
        this.operadora = operadora;
    }
    
    public void copiar(Telefone outra){
        this.ddd = outra.getDdd();
        this.numero = outra.getNumero();
        this.descricao = outra.getDescricao();
        this.operadora = outra.getOperadora();
    }
    
        public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("_________ Informe os dados do telefone");
        System.out.print("Informe o ddd: ");
        this.ddd = leitor.next();
        System.out.print("Infome o número: ");
        this.numero = leitor.next();
        System.out.print("Informe a descrição: ");
        this.descricao = leitor.next();
        System.out.print("Informe a operadora: ");
        this.operadora = leitor.next();
    }
    
    public void imprimir(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Telefone{" + "ddd = " + ddd 
                + ", numero = " + numero 
                + ", descricao = " + descricao 
                + ", operadora = " + operadora 
                + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ddd);
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.operadora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.operadora, other.operadora);
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOperadora() {
        return this.operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
    
    
}
