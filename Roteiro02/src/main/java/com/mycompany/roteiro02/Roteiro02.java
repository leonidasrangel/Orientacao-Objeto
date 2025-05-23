package com.mycompany.roteiro02;

import com.mycompany.roteiro02.classes.Aeroporto;
import com.mycompany.roteiro02.classes.Passageiro;
import com.mycompany.roteiro02.classes.Voo;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Roteiro02 {

    public static void main(String[] args) {
    Aeroporto aeroporto = new Aeroporto("Aeroporto Internacional de Brasília", "Brasília");

    // Criando voos
    Voo voo1 = new Voo("BR123", "Nova York", 100);
    Voo voo2 = new Voo("BR456", "Lisboa", 4); // Vai ter prejuízo se não tiver pelo menos 5
    Voo voo3 = new Voo("BR789", "Tóquio", 50);

    // Adicionando escalas
    voo1.adicionarEscala("Miami");
    voo1.adicionarEscala("Orlando");
    voo2.adicionarEscala("Madrid");
    voo3.adicionarEscala("Dubai");
    voo3.adicionarEscala("Seul");

    // Criando passageiros
    Passageiro p1 = new Passageiro("João Silva", "12345678900");
    Passageiro p2 = new Passageiro("Maria Oliveira", "98765432100");
    Passageiro p3 = new Passageiro("Carlos Souza", "11122233344");
    Passageiro p4 = new Passageiro("Ana Lima", "55566677788");
    Passageiro p5 = new Passageiro("Paula Dias", "99988877766");

    // Adicionando voos ao aeroporto
    aeroporto.adicionarVoo(voo1);
    aeroporto.adicionarVoo(voo2);
    aeroporto.adicionarVoo(voo3);

    // Adicionando passageiros aos voos
    voo1.adicionarPassageiro(p1);
    voo1.adicionarPassageiro(p2);

    voo2.adicionarPassageiro(p3); // Só um passageiro -> prejuízo
    voo3.adicionarPassageiro(p4);
    voo3.adicionarPassageiro(p5);
    voo3.adicionarPassageiro(p1); // João também vai pra Tóquio

    // Iniciar e concluir voos (acúmulo de pontos após conclusão)
    aeroporto.iniciarVoo("BR123");
    voo1.alterarEstado("Concluído");
    for (Passageiro p : voo1.getPassageiros()) {
        p.getFidelidade().adicionarPontos(500);
    }

    aeroporto.iniciarVoo("BR456");
    voo2.alterarEstado("Concluído");
    for (Passageiro p : voo2.getPassageiros()) {
        p.getFidelidade().adicionarPontos(300);
    }

    aeroporto.iniciarVoo("BR789");
    voo3.alterarEstado("Concluído");
    for (Passageiro p : voo3.getPassageiros()) {
        p.getFidelidade().adicionarPontos(800);
    }

    // Verificar voos com prejuízo
    System.out.println("\nVoos com prejuízo:");
    List<Voo> voosPrejuizo = aeroporto.voosComPrejuizo();
    for (Voo v : voosPrejuizo) {
        System.out.println("Voo " + v.getNumeroVoo() + " com apenas " + v.getPassageiros().size() + " passageiros.");
    }

    // Mostrar passageiros e seus pontos
    System.out.println("\nPassageiros e pontos de fidelidade:");
    List<Passageiro> passageiros = Arrays.asList(p1, p2, p3, p4, p5);
    for (Passageiro p : passageiros) {
        System.out.println(p);
    }
}

}
