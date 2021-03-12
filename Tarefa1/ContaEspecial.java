package Tarefa1;


public class ContaEspecial extends Conta {
    protected double Limite = 0; 

    public ContaEspecial(Pessoa cliente, int nrconta, double saldo, double limite) {
        super(cliente, nrconta, saldo);
        this.Limite = limite;
    }

    public double getLimite() {
        return this.Limite;
    }
    
    public void setLimite(double limite) {
        this.Limite = limite;
    }

    public boolean temSaldo(double dinheiro) {
        if( this.Saldo-dinheiro < -this.Limite)
            return false;
        return true;
    }
}
