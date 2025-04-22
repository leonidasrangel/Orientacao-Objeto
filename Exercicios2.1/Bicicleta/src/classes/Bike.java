/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Bike {
    private String marca;
    private String modelo;
    private double tamanhoQuadro;
    private double preco;
    
    public Bike(){
        this.marca = "";
        this.modelo = "";
        this.tamanhoQuadro = 0;
        this.preco = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados da bicicleta  -----------------");
        System.out.print("Infome a marca: ");
        this.marca = leitor.next();
        System.out.print("Informe o modelo: ");
        this.modelo = leitor.next();
        System.out.print("Informe o tamanho do quadro: ");
        this.tamanhoQuadro = leitor.nextDouble();
        System.out.print("Informe o preço: ");
        this.preco = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Marca: "+ this.marca);
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Tamanho quadro: "+ this.tamanhoQuadro);
        System.out.println("Preço: "+ this.preco);
    }
        public void copiar(Bike outro){
        this.marca = outro.getMarca();
        this.modelo = outro.getModelo();
        this.tamanhoQuadro = outro.getTamanhoQuadro();
        this.preco = outro.getPreco();
    }
        public void setMarca(String marca){
            this.marca = marca;
        }
        public String getMarca(){
            return this.marca;
        }
        public void setModelo(String modelo){
            this.modelo = modelo;
        }
        public String getModelo(){
            return this.modelo;
        }
        public void setTamanhoQuadro(double tamanhoQuadro){
            this.tamanhoQuadro = tamanhoQuadro;
        }
        public double getTamanhoQuadro(){
            return this.tamanhoQuadro;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public double getPreco(){
            return this.preco;
        }
    
}
