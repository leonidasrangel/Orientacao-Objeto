package classes;

public class Quadrado {
    private Ponto p1, p2, p3, p4;

    public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public void imprimir() {
        System.out.println("Vértices do quadrado:");
        p1.imprimir();
        p2.imprimir();
        p3.imprimir();
        p4.imprimir();
    }

    public double lado(Ponto a, Ponto b) {
        return a.distancia(b);
    }

    public double area() {
        double lado = lado(p1, p2); // Considerando que p1-p2 é um lado do quadrado
        return lado * lado;
    }

    public double perimetro() {
        double lado = lado(p1, p2);
        return 4 * lado;
    }

    public String tipo() {
        double l1 = lado(p1, p2);
        double l2 = lado(p2, p3);
        double l3 = lado(p3, p4);
        double l4 = lado(p4, p1);

        double d1 = lado(p1, p3); // diagonal
        double d2 = lado(p2, p4); // diagonal

        boolean ladosIguais = l1 == l2 && l2 == l3 && l3 == l4; // condição para ser um quadrado lados iguais
        boolean diagonaisIguais = d1 == d2; // condição para um quadrado perfeito (diagonais iguais)

        if (ladosIguais && diagonaisIguais) { // Verifica se os lados são iguais e as diagonais são iguais.
            return "Quadrado Perfeito";
        } else if (l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0) { // Verifica se algum lado tem comprimento zero (pontos coincidentes).
            return "Quadrado Degenerado (linha)";
        } else {
            return "Não é um quadrado perfeito";
        }
    }
}
