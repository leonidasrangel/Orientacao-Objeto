package com.mycompany.businessproject;

import com.mycompany.businessproject.classes.Business;
import com.mycompany.businessproject.classes.Employee;
import com.mycompany.businessproject.classes.Project;
import java.util.ArrayList;

/**
 *
 * @author Rangel
 */
public class BusinessProject {

    public static void main(String[] args) {
        // Criar a empresa
        Business empresa = new Business("Tech Solutions");

        // Criar funcionários
        Employee emp1 = new Employee("Ana", 1, new ArrayList<>());
        Employee emp2 = new Employee("Carlos", 2, new ArrayList<>());
        Employee emp3 = new Employee("João", 3, new ArrayList<>());

        // Adicionar funcionários à empresa
        empresa.adicionarFuncionario(emp1);
        empresa.adicionarFuncionario(emp2);
        empresa.adicionarFuncionario(emp3);

        // Criar projetos
        Project proj1 = new Project("Sistema Bancário", 101, "Desenvolvimento de sistema para banco", new ArrayList<>());
        Project proj2 = new Project("E-commerce", 102, "Plataforma de vendas online", new ArrayList<>());
        Project proj3 = new Project("App Mobile", 103, "Aplicativo de produtividade", new ArrayList<>());

        // Adicionar projetos à empresa
        empresa.adicionarProjeto(proj1);
        empresa.adicionarProjeto(proj2);
        empresa.adicionarProjeto(proj3);

        // Alocar funcionários em projetos (relacionamento bidirecional)
        emp1.adicionarProject(proj1);
        proj1.adicionarEmployee(emp1);

        emp1.adicionarProject(proj2);
        proj2.adicionarEmployee(emp1);

        emp2.adicionarProject(proj2);
        proj2.adicionarEmployee(emp2);

        emp3.adicionarProject(proj3);
        proj3.adicionarEmployee(emp3);

        // Listar todos os funcionários e projetos
        empresa.listarFuncionarios();
        System.out.println();
        empresa.listarProjetos();
        System.out.println();

        // Mostrar o funcionário mais e menos produtivo
        Employee maisProdutivo = empresa.funcionarioMaisProdutivo();
        Employee menosProdutivo = empresa.funcionarioMenosProdutivo();

        System.out.println("Funcionário mais produtivo: " + maisProdutivo.getNome());
        System.out.println("Funcionário menos produtivo: " + menosProdutivo.getNome());
    }
}
