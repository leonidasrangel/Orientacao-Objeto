package classes;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class ContaAPagar {
    private int id;
    private String codigoBarras;
    private double valor;

    public ContaAPagar() {
        this.id = 0;
        this.codigoBarras = "";
        this.valor = 0.0;
    }

    public ContaAPagar(int id, String codigoBarras, double valor) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ContaAPagar{" + "id=" + id 
                + ", codigoBarras=" + codigoBarras 
                + ", valor=" + valor 
                + '}';
    }
    public void imprimir(){
        System.out.println(this.toString());
    }
    public void copiar(ContaAPagar outra){
        this.id = outra.getId();
        this.codigoBarras = outra.getCodigoBarras();
        this.valor = outra.getValor();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.codigoBarras);
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
        final ContaAPagar other = (ContaAPagar) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        return Objects.equals(this.codigoBarras, other.codigoBarras);
    }
    

    public int getId() {
        return this.id;
    }

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public double getValor() {
        return this.valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
