package upe_programacao_2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Funcionario extends Pessoa {
	private static AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idFuncionario
	private final int idFuncionario;
	private static HashMap<Integer, String> mapaCargos = new HashMap<Integer, String>();
	private int idCargo;
	private float salario;
	private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	
	public Funcionario(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero, int idCargo, float salario) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		idFuncionario = count.incrementAndGet();
		this.idCargo = idCargo;
		this.salario = salario;
		listaFuncionarios.add(this);
	}
	
	// Getters/setters
	// TO DO: getMapaCargos()
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public static ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public static void addListaFuncionarios(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
<<<<<<< HEAD
		count = new AtomicInteger(listaFuncionarios.size());
=======
>>>>>>> 8dddbc59b25a8b2a1a9b945ce749e0ce176dbf5f
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
	public static String getCargo(int idCargo) {
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
			System.out.println(String.format("Id '%d', Cargo '%s' removido com sucesso!", idCargo, mapaCargos.get(idCargo)));
			mapaCargos.remove(idCargo);
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

""", this.getIdFuncionario(), this.getNome(), this.getCpf(), this.getTelefone(), this.getEmail(), this.getPreferenciaComunicacao(), this.getEndereco(), this.getAniversario(), this.getIdade(), this.getGenero(), Funcionario.getCargo(this.getIdCargo()), this.getSalario());
	}
}
