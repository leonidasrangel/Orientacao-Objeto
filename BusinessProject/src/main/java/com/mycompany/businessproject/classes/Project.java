package com.mycompany.businessproject.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Project {
    private String nome;
    private int codProject;
    private String descricaoProject;
    private List<Employee> funcionariosAlocados;

    public Project() {
        this.nome = "";
        this.codProject = 0;
        this.descricaoProject = "";
        this.funcionariosAlocados = new ArrayList();
    }

    public Project(String nome, int codProject, String descricaoProject, List<Employee> funcionariosAlocados) {
        this.nome = nome;
        this.codProject = codProject;
        this.descricaoProject = descricaoProject;
        this.funcionariosAlocados = funcionariosAlocados;
    }
    
            //Adicionar e remover projetos
    public void adicionarEmployee(Employee employee){
        if (!funcionariosAlocados.contains(employee)) {
            funcionariosAlocados.add(employee);
            employee.adicionarProject(this); // garante o vínculo no outro lado
        }
    }

    public void removerEmployee(Employee employee){
        if (funcionariosAlocados.contains(employee)) {
            funcionariosAlocados.remove(employee);
            employee.removerProject(this); // remove também no outro lado
        }
    }


        @Override
    public int hashCode() {
        return Objects.hash(codProject);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project other = (Project) obj;
        return this.codProject == other.codProject;
    }

    @Override
    public String toString() {
        // Cria um StringBuilder vazio para construir a lista de nomes dos funcionários de forma eficiente.
        StringBuilder funcionarios = new StringBuilder();
        for (Employee e : funcionariosAlocados) { // Itera sobre a coleção funcionariosAlocados, onde cada elemento e é um objeto Employee.
            funcionarios.append(e.getNome()).append(", "); // Adiciona o nome do funcionário (via getNome()) ao StringBuilder, seguido de uma vírgula e espaço.
        }
        if (funcionarios.length() > 0) { // Verifica se o StringBuilder contém caracteres (ou seja, se há funcionários na lista).
            funcionarios.setLength(funcionarios.length() - 2); // Remove os últimos dois caracteres (", ") para evitar uma vírgula extra no final da lista.
        }

        return "Project{" +
               "nome = '" + nome + '\'' +
               ", codProject = " + codProject +
               ", descricao = '" + descricaoProject + '\'' +
               ", funcionarios = [" + funcionarios + "]" +
               '}';
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodProject() {
        return this.codProject;
    }

    public void setCodProject(int codProject) {
        this.codProject = codProject;
    }

    public String getDescricaoProject() {
        return this.descricaoProject;
    }

    public void setDescricaoProject(String descricaoProject) {
        this.descricaoProject = descricaoProject;
    }

    public List<Employee> getFuncionariosAlocados() {
        return this.funcionariosAlocados;
    }

    public void setFuncionariosAlocados(List<Employee> funcionariosAlocados) {
        this.funcionariosAlocados = funcionariosAlocados;
    }
    
    
    
    
}
