package Tarefa1;

public class PessoaJuridica extends Pessoa {
    protected int Cnpj;
    protected String Atividade;

    public PessoaJuridica(int id, String nome, String endereco, int cnpj, String atividade) {
        super(id, nome, endereco);
        this.Cnpj = cnpj;
        this.Atividade = atividade;
    }  

    public int getCnpj() {
        return this.Cnpj;
    }
    
    public void setCnpj(int cnpj) {
        this.Cnpj = cnpj;
    }

    public String getAtividade() {
        return this.Atividade;
    }
    
    public void setAtividade(String atividade) {
        this.Atividade = atividade;
    }
}
