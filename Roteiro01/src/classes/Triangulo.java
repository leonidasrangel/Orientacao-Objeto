package classes;

public class Triangulo {
    private Ponto p1, p2, p3;

    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void imprimir() {
        p1.imprimir();
        p2.imprimir();
        p3.imprimir();
    }

    public boolean isColinear() {
        return determinante() == 0; // Retorna true se o determinante (calculado pelo método 'determinante') for 0, indicando colinearidade.
    }

    public double area() {
        double det = determinante();
        if (det != 0) { // Verifica se o determinante não é zero (ou seja, os pontos não são colineares).
            return det / 2.0;
        } else { // Caso o determinante seja zero (pontos colineares).
            return 0; // Retorna 0, pois não há área (não forma um triângulo).
        }
    }

    public double perimetro() {
        return p1.distancia(p2) + p2.distancia(p3) + p3.distancia(p1);
    }

    public String tipo() {
        double a = p1.distancia(p2); //Calculando a distância entre p1 e p2 (lado A do triângulo)
        double b = p2.distancia(p3); //                                     (lado B do triângulo)
        double c = p3.distancia(p1); //                                     (lado C do triângulo)

        if (a == b && b == c) { //Verifica se todos os lados são iguais
            return "Equilátero"; // vai retornar a Equilátero se todos os lados forem igual
        } else if (a == b || b == c || a == c) { // verifica se pelo menos dois lados iguais
            return "Isósceles"; // vai retornar a Isósceles se pelo menos dois lados forem iguais
        } else {
            return "Escaleno"; // retorna a Escaleno se todos os lados forem diferentes
        }
    }

    private double determinante() {
        double parcela1 = p1.getX() * p2.getY() * 1 + //primeira parte do determinante x1*y2*1
                          p2.getX() * p3.getY() * 1 + // soma com x2*y3*1
                          p1.getY() * 1 * p3.getX(); // soma com y1*1*x3

        double parcela2 = p3.getX() * p2.getY() * 1 + // segunda parte do determinante x3*y2*1
                          p2.getX() * p1.getY() * 1 + // soma com x2*y1*1
                          p3.getY() * 1 * p1.getX(); // soma com y3*1*x1

        return parcela1 - parcela2; // diferença das parcelas que é o valor do determinante
    }
}
