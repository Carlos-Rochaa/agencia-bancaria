import entities.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[6];
        clientes[0] = new Cliente("Carlos Henrique Goes da Rocha", 12345, 220396, 15000);
        clientes[1] = new Cliente("Maria Eduarda Holanda", 23051, 200702, 12000);
        clientes[2] = new Cliente("Maria Vitória", 45698, 142321, 24580);
        clientes[3] = new Cliente("Lucas Eduardo", 96521, 336699, 16890);
        clientes[4] = new Cliente("Luiz Reis", 34569, 879896, 56400);
        clientes[5] = new Cliente("Leandro Marques", 21213, 251211, 18300);


        boolean sair = false;
        while (!sair) {
            boolean loginSucesso;
            Cliente clienteLogado = null;
            int limiteTentativas = 3;
            try {
                do {
                    loginSucesso = false;
                    System.out.println("Para ter acesso ao menu, digite sua conta e sua senha");
                    System.out.print("Conta: ");
                    int contaCorreta = scanner.nextInt();
                    System.out.print("Senha: ");
                    int senhaCorreta = scanner.nextInt();

                    for (Cliente cliente : clientes) {
                        if (cliente != null) {
                            if (cliente.getConta() == contaCorreta && cliente.getSenha() == senhaCorreta) {
                                loginSucesso = true;
                                clienteLogado = cliente;
                                System.out.println("Logado com sucesso");
                                System.out.println("Seja bem vindo(a): " + cliente.getNome());
                                break;
                            }

                        }
                    }
                    if (!loginSucesso) {
                        System.out.println("Conta ou senha incorretos");
                        System.out.println("Quantidade de tentativas restantes: " + (limiteTentativas - 1));
                        limiteTentativas--;
                    }
                    if (limiteTentativas == 0) {
                        System.out.println("O sistema será encerrado por questões de segurança. Tente novamente mais tarde!");
                        System.exit(1);
                    }

                } while (!loginSucesso);
            } catch (InputMismatchException e) {

                System.out.println("Conta e senha devem ser números inteiros.");
                System.exit(1);
            }
            int option = 0;
            programa:
            while (option != 6) {
                System.out.println("Menu\n1- Depositar\n2- Sacar\n3- Transferir dinheiro para outra conta\n4- Ver saldo\n5- Sair da sua conta\n6- Encerrar sistema");
                System.out.print("Sua escolha: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Digite o valor que deseja depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        clienteLogado.depositar(valorDeposito);
                        System.out.println("Você depositou " + valorDeposito + " R$, seu novo saldo é: " + clienteLogado.getSaldo() + " R$");
                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valorSaque = scanner.nextDouble();
                        clienteLogado.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.println("Digite o valor para transferir");
                        double valorTransferir = scanner.nextDouble();
                        System.out.println("Digite o número da conta do destinatário");
                        int contaDestino = scanner.nextInt();

                        Cliente destinatario = null;

                        for (Cliente cliente : clientes) {
                            if (cliente != null && cliente.getConta() == contaDestino) {
                                destinatario = cliente;
                                break;
                            }
                        }
                        if (destinatario != null) {
                            clienteLogado.transferir(destinatario, valorTransferir);
                            break;
                        } else {
                            System.out.println("Conta do destinatário inválida");
                        }
                        break;
                    case 4:
                        System.out.println("O seu saldo atual é: " + clienteLogado.getSaldo() + " R$");
                        break;
                    case 5:
                        System.out.println("Deseja sair da sua conta?\n1- Sim\n2- Não");
                        int confirmacao = scanner.nextInt();
                        if (confirmacao == 1) {
                            System.out.println("Saindo...");
                            break programa;


                        } else {
                            System.out.println("Retornando ao menu");
                        }
                        break;
                    case 6:
                        sair = true;
                        System.out.println("Encerrando o sistema");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        }
    }
}