package entities;

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



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
