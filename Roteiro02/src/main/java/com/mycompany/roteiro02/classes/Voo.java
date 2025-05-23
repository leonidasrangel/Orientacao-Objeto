package com.mycompany.roteiro02.classes;

/**
 *
 * @author Rangel
 */
import java.util.ArrayList;
import java.util.List;

public class Voo {
    private String numeroVoo;
    private String destino;
    private int capacidadeMaxima;
    private List<Passageiro> passageiros;
    private List<String> escalas;
    private String estadoVoo;

    public Voo() {
        this.numeroVoo = "";
        this.destino = "";
        this.capacidadeMaxima = 0;
        this.passageiros = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.estadoVoo = "Aguardando decolagem";
    }

    public Voo(String numeroVoo, String destino, int capacidadeMaxima) {
        this.numeroVoo = numeroVoo;
        this.destino = destino;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageiros = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.estadoVoo = "Aguardando decolagem";
    }

    // Adicionar/remover passageiros
    public boolean adicionarPassageiro(Passageiro passageiro) {
        if (passageiros.size() < capacidadeMaxima && !passageiros.contains(passageiro)) {
            passageiros.add(passageiro);
            return true;
        }
        return false;
    }

    public boolean removerPassageiro(Passageiro passageiro) {
        return passageiros.remove(passageiro);
    }

    // Adicionar/remover escalas
    public void adicionarEscala(String escala) {
        if(!escalas.contains(escala)){
        escalas.add(escala);
        }
    }

    public boolean removerEscala(String escala) {
        return escalas.remove(escala);
    }

    // Alterar estado do voo
    public void alterarEstado(String novoEstado) {
        this.estadoVoo = novoEstado;
    }

    // Verifica se está abaixo da capacidade mínima
    public boolean estaAbaixoDaCapacidadeMinima() {
        return passageiros.size() < 5;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public List<String> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<String> escalas) {
        this.escalas = escalas;
    }

    public String getEstadoVoo() {
        return estadoVoo;
    }

    public void setEstadoVoo(String estadoVoo) {
        this.estadoVoo = estadoVoo;
    }

    @Override
    public String toString() {
        StringBuilder nomesPassageiros = new StringBuilder();
        for (Passageiro p : passageiros) {
            nomesPassageiros.append(p.getNome()).append(", ");
        }
        if (nomesPassageiros.length() > 0) nomesPassageiros.setLength(nomesPassageiros.length() - 2);

        return "Voo{" +
               "numeroVoo='" + numeroVoo + '\'' +
               ", destino='" + destino + '\'' +
               ", capacidadeMaxima=" + capacidadeMaxima +
               ", passageiros=[" + nomesPassageiros + "]" +
               ", escalas=" + escalas +
               ", estadoVoo='" + estadoVoo + '\'' +
               '}';
    }
}
