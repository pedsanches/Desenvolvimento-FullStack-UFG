package Banco;

import java.util.Calendar;

public class PessoaFisica extends Pessoa{
    private int Cpf;
    private Calendar dtNascimento;
    private String Genero;

    public PessoaFisica (int id, String nome, String endereco, int cpf, Calendar dtnascimento, String genero) {
        super(id, nome, endereco);
        this.Cpf = cpf;
        this.dtNascimento = dtnascimento;
        this.Genero = genero;
        
    }  

    public int getCpf() {
        return this.Cpf;
    }
    
    public void setCpf(int cpf) {
        this.Cpf = cpf;
    }

    public Calendar getDtNascimento() {
        return this.dtNascimento;
    }
    
    public void setDtNascimento(Calendar dtnascimento) {
        this.dtNascimento = dtnascimento;
    }

    public String getGenero() {
        return this.Genero;
    }
    
    public void setGenero(String genero) {
        this.Genero = genero;
    }

    public int getIdade() {
        Calendar calendar = Calendar.getInstance();
        
        int AnoHoje = calendar.get(Calendar.YEAR);
        int AnoPessoa = this.dtNascimento.get(Calendar.YEAR);

        int idade = AnoHoje - AnoPessoa;
        return idade;
    }
}