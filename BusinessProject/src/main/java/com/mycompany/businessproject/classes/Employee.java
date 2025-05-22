package com.mycompany.businessproject.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Employee {
    private String nome;
    private int Id;
    private List<Project> projects;

    public Employee() {
        this.nome = "";
        this.Id = 0;
        this.projects = new ArrayList();
    }

    public Employee(String nome, int Id, List<Project> projects) {
        this.nome = nome;
        this.Id = Id;
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return this.Id == other.Id;
    }


    @Override
    public String toString() {
        return "Employee{" + "nome = " + nome 
                + ", Id = " + Id 
                + ", projects = " 
                + projects 
                + '}';
    }
    
        //Adicionar e remover projetos
    public void adicionarProject(Project project){
        if (!projects.contains(project)) {
            projects.add(project);
            project.adicionarEmployee(this); // garante o vínculo no outro lado
        }
    }

    public void removerProject(Project project){
        if (projects.contains(project)) {
            projects.remove(project);
            project.removerEmployee(this); // remove também no outro lado
        }
    }
    
    public void copiar(Employee outro){
        this.nome = outro.getNome();
        this.Id = outro.getId();
    }

    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    
    
    
}
