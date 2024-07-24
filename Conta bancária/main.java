import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "\n" + "Digite as opções 1, 2 ou 3 para selecionar os dados das respectivas contas: Conta Bancária, Conta Corrente ou Conta Poupança: ");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.println("\nDados da sua conta Bancária");
            ContaBancaria c = new ContaBancaria("Cecilia\n", 123456, 400);
            System.out.println("Titular: " + c.getTitular() + "Número da conta: "
                    + c.getNumero() + "\nSaldo: " + c.getSaldo());

                    Scanner pergunta = new Scanner(System.in);
                    System.out.println("\n" + "Escolha a operação que deseja realizar: ");
                    System.out.println("-----------");
                    System.out.println("1 - Saque");
                    System.out.println("2 - Depósito");
                    System.out.println("3 - Verificar rendimento");
                    int operacao = sc.nextInt();

            if (operacao == 1){
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja sacar: ");
                int valor = sc.nextInt();
                c.saque(valor);
                System.out.println("Seu saldo final é de: " + c.getSaldo());
            } else if (operacao == 2) {
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja depositar: ");
                int valor = sc.nextInt();
                c.deposito(valor);
                System.out.println("Seu saldo final é de: " + c.getSaldo());
            } else if (operacao == 3){
            c.clacularRendimento();
            System.out.println("O Saldo final com o rendimento é: " + c.getSaldo());
            }
        }

        else if (opcao == 2) {
            System.out.println("\nDados da sua conta Corrente");
            ContaCorrente c1 = new ContaCorrente("Cecilia\n", 12356, 400);
            System.out.println("Titular: " + c1.getTitular() + "Número da conta: " +
                    c1.getNumero() + "\nSaldo: " + c1.getSaldo());

                    Scanner pergunta = new Scanner(System.in);
                    System.out.println("\n" + "Escolha a operação que deseja realizar: ");
                    System.out.println("-----------");
                    System.out.println("1 - Saque");
                    System.out.println("2 - Depósito");
                    System.out.println("3 - Verificar rendimento");
                    int operacao = sc.nextInt();

            if (operacao == 1){
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja sacar: ");
                int valor = sc.nextInt();
                c1.saque(valor);
                System.out.println("Seu saldo final é de: " + c1.getSaldo());
            } else if (operacao == 2) {
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja depositar: ");
                int valor = sc.nextInt();
                c1.deposito(valor);
                System.out.println("Seu saldo final é de: " + c1.getSaldo());
            } else if (operacao == 3){
            c1.clacularRendimento();
            System.out.println("O Saldo final com o rendimento do cdb é: " + c1.getSaldo());
            }
        
        }

        else if (opcao == 3) {
            System.out.println("\nDados da conta Poupança");
            ContaPoupanca c2 = new ContaPoupanca("Cecilia", 123455, 400);
            System.out.println("Titular: " + c2.getTitular() + "\nNúmero da conta: "
                    + c2.getNumero() + "\nSaldo: " + c2.getSaldo());

                    Scanner pergunta = new Scanner(System.in);
                    System.out.println("\n" + "Escolha a operação que deseja realizar: ");
                    System.out.println("-----------");
                    System.out.println("1 - Saque");
                    System.out.println("2 - Depósito");
                    System.out.println("3 - Verificar rendimento");
                    int operacao = sc.nextInt();

            if (operacao == 1){
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja sacar: ");
                int valor = sc.nextInt();
                c2.saque(valor);
                System.out.println("Seu saldo final é de: " + c2.getSaldo());
            } else if (operacao == 2) {
                Scanner vl = new Scanner(System.in);
                System.out.println("\n" + "Digite o valor que deseja depositar: ");
                int valor = sc.nextInt();
                c2.deposito(valor);
                System.out.println("Seu saldo final é de: " + c2.getSaldo());
            } else if (operacao == 3){
            c2.clacularRendimento();
            System.out.println("O Saldo final com o rendimento do cdb é: " + c2.getSaldo());
            }
            

        }

    }
}
