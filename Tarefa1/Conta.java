package Banco;

public class Conta {
    //private static int contaCounter = 1;
    protected Pessoa Cliente;
    protected int nrConta;
    protected double Saldo;

    public Conta(Pessoa cliente,  int nrconta, double saldo) {
        this.Cliente = cliente;
        this.nrConta = nrconta;
        this.Saldo = saldo;
        /*this.nrConta = Conta.contaCounter;
        Conta.contaCounter++;*/
        
    }

    public Pessoa getCliente() {
        return this.Cliente;
    }
    
    public void setCliente(Pessoa cliente) {
        this.Cliente = cliente;
    }

    public int getNrConta() {
        return this.nrConta;
    }

    public double getSaldo() {
        return this.Saldo;
    }

    public void Sacar(double dinheiro) {
        if( temSaldo(dinheiro) ) {
            Debitar(dinheiro);
            System.out.println("Saque realizado com sucesso!");
        }
        System.out.println("Saldo insuficiente para sacar essa quantia!");
    }

    private void Debitar(double dinheiro) {
        this.Saldo -= dinheiro;
    }

    public boolean temSaldo(double dinheiro) {
        if( this.Saldo<= 0)
            return false;
        return true;
    } 

    public void Depositar(double dinheiro) {
        this.Saldo += dinheiro;
    }

    public void Transferir(double dinheiro, Conta Destino) {
        if( temSaldo(dinheiro) ){
            Debitar(dinheiro);
            Destino.Depositar(dinheiro);
            System.out.println("Transferência realizada com sucesso");
        }
            else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }
}