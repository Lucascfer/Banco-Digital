public abstract class Conta implements IConta {
    private static final int AGENCIA_PARDRAO = 1;
    public static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta() {
        agencia = AGENCIA_PARDRAO;
        numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirAtributos(String tipoConta) {
        System.out.println("Extrato da " + tipoConta);
        System.out.println(String.format("Agencia: %d", getAgencia()));
        System.out.println(String.format("Numero: %d", getNumero()));
        System.out.println(String.format("Saldo: %.2f", getSaldo()));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
