package Tarefa1;


public class ContaPoupanca extends Conta {
    protected double txCorrecao = 0;

    public ContaPoupanca(Pessoa cliente, int nrconta,double saldo, double txcorrecao) {
        super(cliente, nrconta, saldo);
        this.txCorrecao = txcorrecao;
    }

    public double getTxCorrecao() {
        return this.txCorrecao;
    }
    
    public void setTxCorrecao(double txcorrecao) {
        this.txCorrecao = txcorrecao;
    }

    public void AtualizaSaldoRendimento() {
        this.Saldo *= this.txCorrecao;
    }
}
