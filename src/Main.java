import entities.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner scanner = new Scanner(System.in);
        Cliente[] cliente = new Cliente[5];
        cliente[0] = new Cliente("Carlos Henrique Goes da Rocha", 12345, 220396, 15000);
        cliente[1] = new Cliente("Maria Eduarda Holanda", 23051, 200702, 12000);

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
                            System.out.println("Logado com sucesso");
                            break;
                        }

                    }
                }
                if (!loginSucesso) {
                    System.out.println("Conta ou senha incorretos");
                }

            } while (!loginSucesso);
        } catch (InputMismatchException e) {

            System.out.println("Conta e senha devem ser números inteiros.");
            System.exit(1);
    }


}
}