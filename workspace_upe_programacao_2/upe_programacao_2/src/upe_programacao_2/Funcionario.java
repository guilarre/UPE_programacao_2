package upe_programacao_2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	// Contador para autoincrementar idFuncionario
	private static AtomicInteger count = new AtomicInteger(0);
	private final int idFuncionario;
	private static HashMap<Integer, String> mapaCargos = new HashMap<Integer, String>();
	private int idCargo;
	private double salario;
	
	public Funcionario(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero, int idCargo, double salario) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		idFuncionario = count.incrementAndGet();
		this.idCargo = idCargo;
		this.salario = salario;
		listaFuncionarios.add(this);
	}
	
	// Getters/setters
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
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
	
	// Getter para selecionar objeto funcionário
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
		}
		sc.close();
		return null; // TODO: na Main, reconhece se é null e cancela operação
	}
	
	// Usado por JsonReader
	public static ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public static void addToListaFuncionarios(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
		count = new AtomicInteger(listaFuncionarios.size());
	}

	// CRUD para mapaCargos
	public static void putCargo(int idCargo, String cargo) {
		mapaCargos.put(idCargo, cargo);
		System.out.println(String.format("Id '%d', Cargo '%s' adicionado com sucesso", idCargo, mapaCargos.get(idCargo)));
	}
	public static String getMapaCargos() {
		for (int i : mapaCargos.keySet()) {
			return String.format("Id '%d', Cargo '%s'", i, mapaCargos.get(i));
		}
		return "ERRO! Ainda não existem cargos registrados.";
	}
	public static String getCargoById(int idCargo) {
		if (mapaCargos.containsKey(idCargo)) {
			return mapaCargos.get(idCargo);
		} else {
			throw new IllegalArgumentException(String.format("ERRO! Id '%d' não existe!", idCargo));
		}
	}
	public static void modifyCargo(int idCargo, String cargo) {
		if (mapaCargos.containsKey(idCargo)) {
			mapaCargos.put(idCargo, cargo);
			System.out.println(String.format("Id '%d' modificado para Cargo: '%s' com sucesso", idCargo, mapaCargos.get(idCargo)));
		} else {
			System.out.println(String.format("ERRO! Id '%d' não existe!", idCargo));
		}
	}
	public static void removeCargo(int idCargo) {
		if (mapaCargos.containsKey(idCargo)) {
			mapaCargos.remove(idCargo);
			System.out.println(String.format("Id '%d', Cargo '%s' removido com sucesso!", idCargo, mapaCargos.get(idCargo)));
		} else {
			System.out.println(String.format("ERRO! Id '%d' não existe!", idCargo));
		}
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

""", this.getIdFuncionario(), this.getNome(), this.getCpf(), this.getTelefone(), this.getEmail(), this.getPreferenciaComunicacao(), this.getEndereco(), this.getAniversario(), this.getIdade(), this.getGenero(), Funcionario.getCargoById(this.getIdCargo()), this.getSalario());
	}
}
