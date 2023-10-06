import entities.Cliente;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner scanner = new Scanner(System.in);
        Cliente[] cliente = new Cliente[5];
        cliente[0] = new Cliente("Carlos Henrique Goes da Rocha", 12345, 220396, 15000);


        boolean loginSucesso;
        try {
            do {
                loginSucesso = false;
                System.out.println("Para ter acesso ao menu, digite sua conta e sua senha");
                System.out.print("Conta: ");
                int contaCorreta = scanner.nextInt();
                System.out.print("Senha: ");
                int senhaCorreta = scanner.nextInt();

                for (Cliente value : cliente) {
                    if (value != null) {
                        if (value.getConta() == contaCorreta && value.getSenha() == senhaCorreta) {
                            loginSucesso = true;
                        } else {
                            System.out.println("Conta ou senha incorreto!");
                        }
                    }
                }

            } while (!loginSucesso);
        } catch (NullPointerException e) {

            System.out.println("Ocorreu um erro, tente novamente.");

    }

        System.out.println("RODANDO");
}
}