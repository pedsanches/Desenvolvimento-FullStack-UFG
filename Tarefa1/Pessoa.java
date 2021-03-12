package Tarefa1;

public abstract class Pessoa {
    //private static int IdCounter = 0;
	protected int Id;
	protected String Nome;
	protected String Endereco;
	
    public Pessoa(int id, String nome, String endereco ) {
        this.Id = id;
        this.Nome = nome;
        this.Endereco = endereco;
        //this.Id = Pessoa.IdCounter;
        //Pessoa.IdCounter++;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEndereco() {
        return this.Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    /*public void printId() {
        System.out.println(Pessoa.idCounter);
    }*/
}
