package entities;

import java.text.DecimalFormat;

public class Cliente {
    private String nome;
    private int conta;

    private int senha;

    private double saldo;

    public Cliente(String nome, int conta, int senha, double saldo) {
        this.nome = nome;
        this.conta = conta;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        DecimalFormat df = new DecimalFormat("#.00");
        saldo += valor;
    }

    public void sacar(double valor) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Você realizou um saque de: " + df.format(valor) + " R$, seu novo saldo é: " + df.format(saldo) + " R$.");
        } else {
            System.out.println("Você não possui saldo suficiente para saque.");
        }
    }

    public void transferir(Cliente destinatario, double valor) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (valor <= saldo) {
            saldo -= valor;
            destinatario.depositar(valor);
            System.out.println("Transferência de " + df.format(valor) +   " R$ realizada com sucesso, seu novo saldo é: " + df.format(saldo) + " R$");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }


    public String getNome() {
        return nome;
    }


    public int getConta() {
        return conta;
    }


    public int getSenha() {
        return senha;
    }


    public String getSaldo() {
        DecimalFormat df = new DecimalFormat("#.00");
        return  df.format(saldo);
    }


}

