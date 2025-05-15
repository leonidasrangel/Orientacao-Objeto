package classes;

public class Ponto {
    private double x;
    private double y;

    public Ponto() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public void imprimir() {
        System.out.println("(x: " + this.x + ", y: " + this.y + ")");
    }

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }

    public double distancia(Ponto outro) {
        double deltaX = outro.getX() - this.x; // calcula a diferença entre as coordenadas x
        double deltaY = outro.getY() - this.y; // calcula a diferença entre as coordenadas y
        deltaX = Math.pow(deltaX, 2); // eleva ao quadrado (Math.pow)
        deltaY = Math.pow(deltaY, 2);
        return Math.sqrt(deltaX + deltaY); // raiz quadrada da soma dos quadrados
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
