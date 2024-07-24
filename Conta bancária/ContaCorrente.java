public class ContaCorrente {

    private String titular;
    private int numero;
    private double saldo;
    private final double limite = 100;

    public ContaCorrente(String titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getTitular() {
        return this.titular;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void clacularRendimento() {
        this.saldo = saldo + saldo * 0.005;
    }

    public void saque(double saque) {
        this.saldo -= saque;
        if (saldo < 0 && (saldo * -1) <= this.limite) {
            System.out.println("Essa operação irá resultar em uso de limite");
        } else if (saldo < 0 && (saldo * -1) > this.limite) {
            System.out.println("Operação cancelada, sem limite");
            this.saldo += saque;
        }
    }

    public void deposito(double saque) {
        this.saldo += saque;
    }

}