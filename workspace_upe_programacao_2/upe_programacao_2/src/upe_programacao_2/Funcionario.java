package upe_programacao_2;

import java.util.concurrent.atomic.AtomicInteger;

import enums.Cargo;
import enums.Pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	// Contador para autoincrementar idFuncionario
	private static AtomicInteger count = new AtomicInteger(0);
	private final int idFuncionario;
	private Cargo cargo = null;
	private double salario;
	
	public Funcionario(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero, Cargo cargo, double salario) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		idFuncionario = count.incrementAndGet();
		this.cargo = cargo;
		this.salario = salario;
		listaFuncionarios.add(this);
	}
	
	// Getters/setters
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public static String getCargoValue(Cargo cargo) {
		switch (cargo) {
			case VENDEDOR:
				return "Vendedor";
			case CAIXA:
				return "Caixa";
			case ESTOQUISTA:
				return "Estoquista";
			case SOCIO:
				return "Sócio";
			default:
				return "ERRO! Cargo ainda não registrado";
		}
	}
	// TODO: Checar se precisa mesmo disso
	public static String getTodosCargos() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Cargo cargo : Cargo.values()) {
			stringBuilder.append(Funcionario.getCargoValue(cargo));
		}
		return String.valueOf(stringBuilder);
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public static String getFuncionarios() {
		StringBuilder funcionarios = new StringBuilder();
		for (Funcionario funcionario: listaFuncionarios) {
			funcionarios.append(funcionario.toString());
		}
		if (funcionarios.isEmpty()) {
			return "ERRO! Nenhum funcionário foi registrado ainda";
		}
		return String.valueOf(funcionarios);
	}
	
	// Getter para selecionar objeto Funcionario
	public static Funcionario getFuncionarioById(int idFuncionario) {
		for (Funcionario funcionario : Funcionario.getListaFuncionarios()) {
			if (funcionario.getIdFuncionario() == idFuncionario) {
				return funcionario;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe funcionário de id '%d'", idFuncionario));
	}
	public static Funcionario getFuncionarioByNome(String nomeFuncionario) {
		for (Funcionario funcionario : Funcionario.getListaFuncionarios()) {
			if (funcionario.getNome() == nomeFuncionario) {
				return funcionario;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe funcionário de nome '%s'", nomeFuncionario));
	}
	public static Funcionario getObjetoFuncionario() {
		// TODO: case default???
		// Menu para selecionar modo de busca
		// TEST: espaçamento correto na UI
		String menuSelecionarFuncionario = """

[1] = Procurar funcionário por seu id
[2] = Procurar funcionário por seu nome

[0] = Retornar ao menu anterior

""";
		System.out.println(menuSelecionarFuncionario);
		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
			case 1:
				System.out.println("Digite o id do funcionário: ");
				int idFuncionario = sc.nextInt();
				sc.close();
				System.out.println(String.format("Funcionário selecionado:\n\n%s", getFuncionarioById(idFuncionario)));
				return Funcionario.getFuncionarioById(idFuncionario);
			case 2:
				System.out.println("Digite o nome do funcionário: ");
				String nomeFuncionario = sc.nextLine();
				sc.close();
				System.out.println(String.format("Funcionário selecionado:\n\n%s", getFuncionarioByNome(nomeFuncionario)));
				return Funcionario.getFuncionarioByNome(nomeFuncionario);
			case 0:
				System.out.println("Operação cancelada!");
				break;
			default:
				System.out.println("ERRO! Opção inválida");
				break;
		}
		sc.close();
		return null; // TODO: na Main, reconhece se é null e cancela operação
	}
	
	// Getter para CRIAR e retornar objeto Funcionario novo
	public static Funcionario getFuncionarioNovo() {
		// Setup
		Scanner sc = new Scanner(System.in);
		Cargo cargo = null;
		// Prompts
		System.out.println("Digite o nome do funcionário: ");
		String nome = sc.nextLine();
		System.out.println("Digite o cpf do funcionário: ");
		String cpf = sc.nextLine();
		System.out.println("Digite o telefone do funcionário: ");
		String telefone = sc.nextLine();
		System.out.println("Digite o email do funcionário: ");
		String email = sc.nextLine();
		System.out.println("Digite a preferência de comunicação do funcionário: ");
		String preferenciaComunicacao = sc.nextLine();
		System.out.println("Digite o endereco residencial do funcionário: ");
		String endereco = sc.nextLine();
		System.out.println("Digite o aniversário do funcionário (e.g. 12/12/2012): ");
		String aniversario = sc.nextLine();
		System.out.println("Digite o gênero do funcionário: ");
		String genero = sc.nextLine();
		System.out.println("""

Escolha o cargo do funcionário:

[1] = Vendedor
[2] = Caixa
[3] = Estoquista
[4] = Sócio

""");
		int opcaoCargo = sc.nextInt();
		switch (opcaoCargo) {
			case 1:
				cargo = Cargo.VENDEDOR;
				break;
			case 2:
				cargo = Cargo.CAIXA;
				break;
			case 3:
				cargo = Cargo.ESTOQUISTA;
				break;
			case 4:
				cargo = Cargo.SOCIO;
				break;
		}
		System.out.println("Digite o salário do funcionário (e.g. 1459.90: ");
		double salario = sc.nextDouble();
		sc.close();
		Funcionario funcionario = new Funcionario(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero, cargo, salario);
		System.out.println("Funcionário registrado com sucesso!");
		return funcionario;
	}
	
	// Usado por JsonReader
	public static ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public static void addToListaFuncionarios(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
		count = new AtomicInteger(listaFuncionarios.size());
	}
	
	// toString()
	@Override
	public String toString() {
		return String.format("""
				
Id do funcionário: '%d'

Nome: %s
CPF: %s
Telefone: %s
Email: %s
Preferência de comunicação: %s
Endereço: %s
Aniversário: %s
Idade: %d
Gênero: %s
Cargo: '%s'
Salário: 'R$ %.2f'

""", this.getIdFuncionario(), this.getNome(), this.getCpf(), this.getTelefone(), this.getEmail(), this.getPreferenciaComunicacao(), this.getEndereco(), this.getAniversario(), this.getIdade(), this.getGenero(), Funcionario.getCargoValue(cargo), this.getSalario());
	}
}
