package Tarefa2;

import java.util.Calendar;
import java.util.Scanner;

import Tarefa1.Conta;
import Tarefa1.ContaEspecial;
import Tarefa1.ContaPoupanca;
import Tarefa1.Pessoa;
import Tarefa1.PessoaFisica;
import Tarefa1.PessoaJuridica;

public class Menu {

	public void menuPrincipal(Scanner sc) {

		Conta conta;
        Integer escolha;

		do {
			this.showMenuPrincipal();

			try {
				escolha = sc.nextInt();

				switch (escolha) {
				case 1:
					this.novaConta(sc);
					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadastrarCliente(sc);
					break;

				case 4:
					this.Relatorios(sc);
					break;

				case 5:
					System.out.println("5 - Sair");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}

		} while (escolha != 5);

	}

	private void novaConta(Scanner sc) {


		System.out.println("----- Nova Conta -----");
		System.out.println("Selecione o tipo de Conta");
		System.out.println("1 - Conta Poupança");
		System.out.println("2 - Conta Especial");

		Integer tipo = sc.nextInt();
		
        Pessoa pessoa = this.buscarPessoa(sc);
		Integer id = pessoa.getId();

		System.out.println("Informe o número da conta: ");
		Integer nr = sc.nextInt();
		
		if( tipo==1 ){
			System.out.println("Informe a taxa de correção: ");
			Double tx = sc.nextDouble();

            Main.contas.add(new ContaPoupanca(pessoa, nr, 0, tx));
        
		}
			else{
				System.out.println("Informe o limite: ");
				Double limite = sc.nextDouble();

				Main.contas.add(new ContaEspecial(pessoa, nr, 0, limite));

			}
	}

	private void cadastrarCliente(Scanner sc) {

		System.out.println("----- Novo Cliente -----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");
		
		Integer tipo = sc.nextInt();
		
		
		System.out.println("Informe o ID: ");
		Integer id = sc.nextInt();

		System.out.println("Informe o Nome: ");
        String bufferr = sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.println("Informe o Endereço: ");
		String endereco = sc.nextLine();
		
		if(tipo == 1) {
			System.out.println("Informe o CPF: ");
			Integer cpf = sc.nextInt();
			
			System.out.println("Informe a Data de Nascimento: ");
			
			System.out.println("Informe o ano de Nascimento: ");
			Integer ano = sc.nextInt();
			System.out.println("Informe o mês de Nascimento: ");
			Integer mes = sc.nextInt();
			System.out.println("Informe o dia de Nascimento: ");
			Integer dia = sc.nextInt();

			Calendar idade = Calendar.getInstance();
			idade.set(ano, mes, dia);
			
					
			System.out.println("Informe o Gênero: ");
			String genero = sc.next();
			
			Main.clientes.add(new PessoaFisica(id, nome, endereco, cpf, idade, genero));
			
		}else {
			System.out.println("Informe o CNPJ: ");
			Integer cnpj = sc.nextInt();
			
			System.out.println("Informe a atividade: ");
            bufferr = sc.nextLine();
			String atividade = sc.nextLine();
			
			Main.clientes.add(new PessoaJuridica(id, nome, endereco, id, atividade));
		}

	}

	private void menuConta(Scanner sc, Conta conta) {

        Integer escolha;
        Conta c;
		
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				Double valor;
				switch (escolha) {
				case 1:
                    c = this.buscarConta(sc);
                    this.menuConta(sc, c);
					break;

				case 2: 
					System.out.println("Informe o Valor do Depósito");
					valor = sc.nextDouble();
					conta.Depositar(valor);
					break;

				case 3: 
					System.out.println("Informe o Valor para Saque");
					valor = sc.nextDouble();
					conta.Sacar(valor);
					break;

				case 4: 
					Conta dest = this.buscarConta(sc);
					System.out.println("Informe o Valor para Transferência");
					valor = sc.nextDouble();
					conta.Transferir(valor, dest);
					break;

				case 5:
					System.out.println("------------------------------------");
					System.out.println("--- SALDO: R$ "+conta.getSaldo()+"---");
					System.out.println("------------------------------------");
					
					break;
				}

			}  catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 6;
			}
		}while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("--- Selecione uma Opção(Número) ---");
		System.out.println("-------------------------");
		System.out.println("1 - Abrir Nova Conta");
		System.out.println("2 - Selecionar Conta");
		System.out.println("3 - Cadastrar Cliente");
		System.out.println("4 - Relatórios");
		System.out.println("5 - Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("------------------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Número da Conta: " + conta.getNrConta());
		System.out.println("------------------------------------");
		System.out.println("--- Selecione uma Opção (Número) ---");
		System.out.println("------------------------------------");
		System.out.println("1 - Alterar Conta");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Saldo");
		System.out.println("6 - Sair");
		System.out.println("------------------------------------");
	}

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------------");
			System.out.println("--- Digite o número da Conta ---");
			System.out.println("------------------------------------");
			Integer escolha = sc.nextInt();

			for (Conta c : Main.contas) {

				if ( c.getNrConta() == escolha ) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("---- Conta Não Encontrada ----");
				System.out.println("------------------------------");				
			}

		} while (conta == null);

		return conta;
	}

	public Pessoa buscarPessoa(Scanner sc) {

		Pessoa pessoa = null;
		do {
			
			System.out.println("Informe o Id da Pessoa: ");
			Integer escolha = sc.nextInt();

			for (Pessoa p : Main.clientes) {

				if (p.getId() == escolha ) {
					pessoa = p;
					break;
				}
			}
			if (pessoa == null) {
				System.out.println("-------------------------------");
				System.out.println("---- Pessoa Não Encontrada ----");
				System.out.println("-------------------------------");				
			}

		} while (pessoa == null);

		return pessoa;
	}

    public void Relatorios( Scanner sc){
        Double total = 0.0;
        for(Conta c: Main.contas){
            System.out.println("Nome: "+c.getCliente().getNome()+", saldo: R$ "+c.getSaldo());
            total += c.getSaldo();
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Total: R$ "+total);
    }
}
