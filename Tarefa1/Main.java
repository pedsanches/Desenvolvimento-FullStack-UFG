package Banco;


import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {

		Calendar idadeNeymar = Calendar.getInstance();
		idadeNeymar.set(1992, 2, 5);

        Calendar idadeMessi = Calendar.getInstance();
		idadeMessi.set(1987, 6, 24);

		PessoaFisica NeymarTheBest = new PessoaFisica(1, "Neymar", "Paris", 12345, idadeNeymar, "Masculino");
        PessoaFisica MessiTheGoat = new PessoaFisica( 2, "Messi", "Barcelona", 54321, idadeMessi, "Masculino");

        System.out.println(NeymarTheBest.getIdade());
        System.out.println(MessiTheGoat.getIdade());

		PessoaJuridica KingsmanTheMovie = new PessoaJuridica(1, "Kingsman", "Area51", 10101, "Salvar o mundo");
        PessoaJuridica KimetsuTheAnime = new PessoaJuridica(2, "Kimetsu", "Japão", 01010, "Assistir anime");

        ContaEspecial ceNeymar = new ContaEspecial(NeymarTheBest, 1, 1000.0, 500.0);
        ContaPoupanca cpMessi = new ContaPoupanca(MessiTheGoat, 2, 500.0, 0.02);
        ContaEspecial ceKingsman = new ContaEspecial(KingsmanTheMovie, 3, 100000.0, 10000.0);
        ContaPoupanca cpKimetsu = new ContaPoupanca(KimetsuTheAnime, 4, 1500.0, 0.03);

		System.out.println("----------------------------------------------------");
        System.out.println(ceNeymar.getSaldo());
        ceNeymar.Sacar(100.0);
        System.out.println("----------------------------------------------------");
        System.out.println(cpMessi.getSaldo());
        cpMessi.Depositar(200.0);

        System.out.println("----------------------------------------------------");
        System.out.println(ceKingsman.getSaldo());
        ceKingsman.Transferir(1000.0, cpKimetsu);
        System.out.println("Kingsman: " +ceKingsman.getSaldo());
        System.out.println("Kimetsu: " +cpKimetsu.getSaldo());

        List<Conta> listConta = new ArrayList<Conta>();
        listConta.add(ceNeymar);
        listConta.add(cpMessi);
        listConta.add(ceKingsman);
        listConta.add(cpKimetsu);

        Double total = 0.0;
        for(Conta c:listConta){
            System.out.println("Nome: "+c.getCliente().getNome()+", saldo: R$ "+c.getSaldo());
            total += c.getSaldo();
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Total: R$ "+total);
        
	}
}