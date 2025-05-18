package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Estudante {
    private String nome;
    private String matricula;
    private String email;
    private String curso;
    private List<Telefone> lstTelefones;

    public Estudante() {
        this.nome = "";
        this.matricula = "";
        this.email = "";
        this.curso = "";
        this.lstTelefones = new ArrayList<>();
    }

    public Estudante(String nome, String matricula, String email, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.curso = curso;
        this.lstTelefones = new ArrayList<>();
    }
    
    public void adicionarTelefone(Telefone telefone) {
        this.lstTelefones.add(telefone);
    }

    public void copiar(Estudante outra){
        this.nome = outra.getNome();
        this.matricula = outra.getMatricula();
        this.email = outra.getEmail();
        this.curso = outra.getCurso();
        
        this.lstTelefones = new ArrayList<>();
        for(Telefone outraTelefone : outra.getLstTelefone()){
            Telefone novo = new Telefone();
            novo.copiar(outraTelefone);
            this.lstTelefones.add(novo);
        }
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
    
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("_________ Informe os dados do estudante");
        System.out.print("Informe o nome: ");
        this.nome = leitor.nextLine();
        System.out.print("Infome o número da matrícula: ");
        this.matricula = leitor.nextLine();
        System.out.print("Informe o email: ");
        this.email = leitor.nextLine();
        System.out.print("Informe o curso: ");
        this.curso = leitor.nextLine();
        
        System.out.print("Quantos telefones deseja cadastrar? ");
        int quantidade = leitor.nextInt();
        leitor.nextLine();
        
        //Capturando telefones
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Telefone " + (i + 1) + ":");
            Telefone t = new Telefone();
            t.preencher();
            this.lstTelefones.add(t);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.matricula);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.curso);
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
        final Estudante other = (Estudante) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.curso, other.curso);
    }

    @Override
    public String toString() {
        return "Estudante{" + "nome = " + nome 
                + ", matricula = " + matricula 
                + ", email = " + email 
                + ", curso = " + curso 
                + ", lstTelefones"
                + '}';
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    public List<Telefone> getLstTelefone(){
        return lstTelefones;
    }
    
    
    
}
