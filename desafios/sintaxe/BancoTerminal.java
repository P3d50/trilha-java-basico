import java.util.Scanner;

public class BancoTerminal {
    private static double saldo = 0.0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = cadastrarCliente(scanner);

        System.out.println("Olá " + cliente.getNome() + ", obrigado por criar uma conta em nosso banco,");
        System.out.println("Sua agência é " + cliente.getAgencia() + ", conta " + cliente.getNumero() + " e seu saldo " + cliente.getSaldo() + " já está disponível para saque.");


        System.out.println("Seu novo saldo após o depósito é: " + cliente.getSaldo());

        scanner.close();
    }

    public static Cliente cadastrarCliente(Scanner scanner) {
        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Por favor, digite o número da Conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        // Solicitar o saldo inicial
        System.out.print("Por favor, digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); 

        // Criar e retornar o objeto Cliente com os dados inseridos
        return new Cliente(agencia, numero, nomeCliente, saldoInicial);
    }

    public static void realizarDeposito(Scanner scanner, Cliente cliente) {
        System.out.print("Por favor, digite o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();

        // Verificar se o valor do depósito é válido (não negativo)
        if (valorDeposito >= 0) {
            // Atualizar o saldo
            cliente.setSaldo( saldo += valorDeposito);
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser positivo.");
        }
    }
}

class Cliente {
    private String agencia;
    private int numero;
    private String nome;
    private double saldo;

    public Cliente(String agencia, int numero, String nome, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
}
