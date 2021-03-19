package Tarefa2;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import java.time.Instant;
//import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Tarefa1.Conta;
import Tarefa1.ContaEspecial;
import Tarefa1.ContaPoupanca;
import Tarefa1.Pessoa;
import Tarefa1.PessoaFisica;
import Tarefa1.PessoaJuridica;


public class Main {

    static List<Conta> contas = new ArrayList<Conta>();
	static List<Pessoa> clientes = new ArrayList<Pessoa>();
	public static void main(String[] args) {

        
        Calendar idadeNeymar = Calendar.getInstance();
		idadeNeymar.set(1992, 2, 5);

        Calendar idadeMessi = Calendar.getInstance();
		idadeMessi.set(1987, 6, 24);

		PessoaFisica NeymarTheBest = new PessoaFisica(1, "Neymar", "Paris", 12345, idadeNeymar, "Masculino");
        PessoaFisica MessiTheGoat = new PessoaFisica( 2, "Messi", "Barcelona", 54321, idadeMessi, "Masculino");


		PessoaJuridica KingsmanTheMovie = new PessoaJuridica(1, "Kingsman", "Area51", 10101, "Salvar o mundo");
        PessoaJuridica KimetsuTheAnime = new PessoaJuridica(2, "Kimetsu", "Japão", 01010, "Assistir anime");

        ContaEspecial ceNeymar = new ContaEspecial(NeymarTheBest, 1, 1000.0, 500.0);
        ContaPoupanca cpMessi = new ContaPoupanca(MessiTheGoat, 2, 500.0, 0.02);
        ContaEspecial ceKingsman = new ContaEspecial(KingsmanTheMovie, 3, 100000.0, 10000.0);
        ContaPoupanca cpKimetsu = new ContaPoupanca(KimetsuTheAnime, 4, 1500.0, 0.03);

		/*System.out.println("----------------------------------------------------");
        System.out.println(ceNeymar.getSaldo());
        ceNeymar.Sacar(100.0);
        System.out.println("----------------------------------------------------");
        System.out.println(cpMessi.getSaldo());
        cpMessi.Depositar(200.0);

        System.out.println("----------------------------------------------------");
        System.out.println(ceKingsman.getSaldo());
        ceKingsman.Transferir(1000.0, cpKimetsu);
        System.out.println("Kingsman: " +ceKingsman.getSaldo());
        System.out.println("Kimetsu: " +cpKimetsu.getSaldo());*/

        //List<Conta> listConta = new ArrayList<Conta>();
        
        contas.add(ceNeymar);
        contas.add(cpMessi);
        contas.add(ceKingsman);
        contas.add(cpKimetsu);


        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
		System.out.println("-------------------------");
		System.out.println("---- Seja Bem Vindo!-----");
		System.out.println("-------------------------");
		menu.menuPrincipal(sc);
		System.out.println("-------------------------");
		System.out.println("-- Programa encerrado! --");
		System.out.println("------- Até Mais!--------");
		System.out.println("-------------------------");
		
		sc.close();
        
	}
}