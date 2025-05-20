package com.mycompany.sistemabanco;

import com.mycompany.sistemabanco.classes.Banco;
import com.mycompany.sistemabanco.classes.Conta;
import com.mycompany.sistemabanco.classes.Transacao;

/**
 *
 * @author Rangel
 */
public class SistemaBanco {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Exemplo");

        // Contas com saldos variados
        Conta contaJoao = new Conta(1, "João", 1000);
        Conta contaMaria = new Conta(2, "Maria", -1500);
        Conta contaJose = new Conta(3, "José", 250);
        Conta contaAna = new Conta(4, "Ana", -150);
        Conta contaCarlos = new Conta(5, "Carlos", 0);

        banco.adicionarConta(contaJoao);
        banco.adicionarConta(contaMaria);
        banco.adicionarConta(contaJose);
        banco.adicionarConta(contaAna);
        banco.adicionarConta(contaCarlos);

        // Adicionando uma transação de 500 reais para José (depósito)
        Transacao transacao1 = new Transacao(3, "Depósito", 500.0, "2025-05-20", contaJose);
        banco.adicionarTransacao(transacao1);

        // Atualizando o saldo da conta de José
        contaJose.depositar(500.0); // ou contaJose.setSaldoAtual(contaJose.getSaldoAtual() + 500.0);
        
        contaJoao.transferir(contaCarlos, 100.0);

        // relatórios
        banco.listarContas();

        System.out.println("Conta com maior saldo: " + banco.contaComMaiorSaldo());
        System.out.println("Conta com menor saldo: " + banco.contaComMenorSaldo());

        banco.resumoDevedores();
        banco.resumoCredores();


    }
}
