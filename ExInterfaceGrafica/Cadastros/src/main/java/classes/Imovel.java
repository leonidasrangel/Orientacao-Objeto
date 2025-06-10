package classes;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Imovel {
    private String tipoImovel;
    private int qtdQuartos;
    private int qtdBanheiros;
    private double tamArea;
    private double preco;

    public Imovel() {
        this.tipoImovel = "";
        this.qtdQuartos = 0;
        this.qtdBanheiros = 0;
        this.tamArea = 0.0;
        this.preco = 0.0;
    }

    public Imovel(String tipoImovel, int qtdQuartos, int qtdBanheiros, double tamArea, double preco) {
        this.tipoImovel = tipoImovel;
        this.qtdQuartos = qtdQuartos;
        this.qtdBanheiros = qtdBanheiros;
        this.tamArea = tamArea;
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.tipoImovel);
        hash = 79 * hash + this.qtdQuartos;
        hash = 79 * hash + this.qtdBanheiros;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.tamArea) ^ (Double.doubleToLongBits(this.tamArea) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imovel other = (Imovel) obj;
        if (this.qtdQuartos != other.qtdQuartos) {
            return false;
        }
        if (this.qtdBanheiros != other.qtdBanheiros) {
            return false;
        }
        if (Double.doubleToLongBits(this.tamArea) != Double.doubleToLongBits(other.tamArea)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        return Objects.equals(this.tipoImovel, other.tipoImovel);
    }

    @Override
    public String toString() {
        return " ------ Dados Cadastrados dos Imóveis ----- " 
                + "\nTipo de Imóvel: " + tipoImovel 
                + "\nQuantidade quartos: " + qtdQuartos 
                + "\nQuantidade de banheiros: " + qtdBanheiros 
                + "\nTamanho da área: " + tamArea
                + "\nValor do imóvel: " + preco
                + "\n--------------------------------------------------------------";
    }
    

    public String getTipoImovel() {
        return this.tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public int getQtdQuartos() {
        return this.qtdQuartos;
    }

    public void setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public int getQtdBanheiros() {
        return this.qtdBanheiros;
    }

    public void setQtdBanheiros(int qtdBanheiros) {
        this.qtdBanheiros = qtdBanheiros;
    }

    public double getTamArea() {
        return this.tamArea;
    }

    public void setTamArea(double tamArea) {
        this.tamArea = tamArea;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
