package com.mycompany.sistemabanco;

import com.mycompany.sistemabanco.classes.Banco;
import com.mycompany.sistemabanco.classes.Conta;

/**
 *
 * @author Rangel
 */
public class SistemaBanco {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Exemplo");

        // Criar contas com saldos variados
        banco.adicionarConta(new Conta(1, "João", 1000));
        banco.adicionarConta(new Conta(2, "Maria", -500));
        banco.adicionarConta(new Conta(3, "José", 250));
        banco.adicionarConta(new Conta(4, "Ana", -150));
        banco.adicionarConta(new Conta(5, "Carlos", 0));

        // Mostrar relatórios
        banco.listarContas();

        System.out.println("Conta com maior saldo: " + banco.contaComMaiorSaldo());
        System.out.println("Conta com menor saldo: " + banco.contaComMenorSaldo());

        banco.resumoDevedores();
        banco.resumoCredores();

    }
}
