package com.mycompany.businessproject.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Business {
    private String nomeEmpresa;
    private List<Project> projetosDisponiveis;
    private List<Employee> funcionariosContratados;

    public Business() {
        this.nomeEmpresa = "";
        this.projetosDisponiveis = new ArrayList<>();
        this.funcionariosContratados = new ArrayList<>();
    }
    public Business(String nome) {
    this.nomeEmpresa = nome;
    this.projetosDisponiveis = new ArrayList<>();
    this.funcionariosContratados = new ArrayList<>();
}


    public Business(String nomeEmpresa, List<Project> projetosDisponiveis, List<Employee> funcionariosContratados) {
        this.nomeEmpresa = nomeEmpresa;
        this.projetosDisponiveis = projetosDisponiveis;
        this.funcionariosContratados = funcionariosContratados;
    }
    
        // Métodos para adicionar e remover projetos
    public void adicionarProjeto(Project projeto) {
        if (!projetosDisponiveis.contains(projeto)) {
            projetosDisponiveis.add(projeto);
        }
    }

    public void removerProjeto(Project projeto) {
        projetosDisponiveis.remove(projeto);
    }
    
    // Métodos para adicionar e remover funcionários
    public void adicionarFuncionario(Employee funcionario) {
        if (!funcionariosContratados.contains(funcionario)) {
            funcionariosContratados.add(funcionario);
        }
    }

    public void removerFuncionario(Employee funcionario) {
        funcionariosContratados.remove(funcionario);
    }
    
    // Listar todos os projetos
    public void listarProjetos() {
        System.out.println("Projetos disponíveis na empresa " + nomeEmpresa + ":");
        for (Project projeto : projetosDisponiveis) {
            System.out.println(projeto);
        }
    }

    // Listar todos os funcionários
    public void listarFuncionarios() {
        System.out.println("Funcionários contratados na empresa " + nomeEmpresa + ":");
        for (Employee funcionario : funcionariosContratados) {
            System.out.println(funcionario);
        }
    }
    
    // Funcionário mais produtivo (com mais projetos)
    public Employee funcionarioMaisProdutivo() {
        if (funcionariosContratados.isEmpty()) return null;
        Employee maisProdutivo = funcionariosContratados.get(0);

        for (Employee funcionario : funcionariosContratados) {
            if (funcionario.getProjects().size() > maisProdutivo.getProjects().size()) {
                maisProdutivo = funcionario;
            }
        }
        return maisProdutivo;
    }

    // Funcionário menos produtivo (com menos projetos)
    public Employee funcionarioMenosProdutivo() {
        if (funcionariosContratados.isEmpty()) return null;
        Employee menosProdutivo = funcionariosContratados.get(0);

        for (Employee funcionario : funcionariosContratados) {
            if (funcionario.getProjects().size() < menosProdutivo.getProjects().size()) {
                menosProdutivo = funcionario;
            }
        }
        return menosProdutivo;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Project> getProjetosDisponiveis() {
        return this.projetosDisponiveis;
    }

    public void setProjetosDisponiveis(List<Project> projetosDisponiveis) {
        this.projetosDisponiveis = projetosDisponiveis;
    }

    public List<Employee> getFuncionariosContratados() {
        return this.funcionariosContratados;
    }

    public void setFuncionariosContratados(List<Employee> funcionariosContratados) {
        this.funcionariosContratados = funcionariosContratados;
    }
    
    
}
