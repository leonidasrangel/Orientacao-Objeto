package com.mycompany.roteiro02.classes;

/**
 *
 * @author Rangel
 */
import java.util.ArrayList;
import java.util.List;
import com.mycompany.roteiro02.classes.SistemaFidelidade;

public class Aeroporto {
    private String nome;
    private String localizacao;
    private List<Voo> voos;

    public Aeroporto() {
        this.nome = "";
        this.localizacao = "";
        this.voos = new ArrayList<>();
    }

    public Aeroporto(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.voos = new ArrayList<>();
    }

    // Adicionar um voo ao aeroporto
    public void adicionarVoo(Voo voo) {
        if (!voos.contains(voo)) {
            voos.add(voo);
        }
    }

    // Remover um voo do aeroporto
    public boolean removerVoo(Voo voo) {
        return voos.remove(voo);
    }

    // Listar todos os voos
    public void listarVoos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo registrado no aeroporto.");
        } else {
            for (Voo v : voos) {
                System.out.println(v);
            }
        }
    }

    // Verificar quais voos estão abaixo da capacidade mínima e podem dar prejuízo
    public List<Voo> voosComPrejuizo() {
        List<Voo> voosPrejuizo = new ArrayList<>();
        for (Voo v : voos) {
            if (v.estaAbaixoDaCapacidadeMinima()) {
                voosPrejuizo.add(v);
            }
        }
        return voosPrejuizo;
    }

    // Iniciar um voo: altera o estado do voo para "Voando"
    public void iniciarVoo(String numeroVoo) {
        Voo voo = null;
        for (Voo v : voos) {
            if (v.getNumeroVoo().equals(numeroVoo)) {
                voo = v;
                break;
            }
        }
        if (voo != null) {
            voo.alterarEstado("Voando");
            System.out.println("Voo " + voo.getNumeroVoo() + " iniciado.");
        } else {
            System.out.println("Voo não encontrado neste aeroporto.");
        }
    }

    
    public void concluirVoo(Voo voo) {
    if (voos.contains(voo)) {
        voo.alterarEstado("Concluído");
        for (Passageiro p : voo.getPassageiros()) {
            p.getFidelidade().adicionarPontos(100);
        }
        System.out.println("Voo " + voo.getNumeroVoo() + " concluído e pontos adicionados aos passageiros.");
    } else {
        System.out.println("Voo não encontrado neste aeroporto.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
               "nome='" + nome + '\'' +
               ", localizacao='" + localizacao + '\'' +
               ", total de voos=" + voos.size() +
               '}';
    }
}
