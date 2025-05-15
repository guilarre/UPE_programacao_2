package upe_programacao_2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class Funcionario extends Pessoa {
	private static final AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idFuncionario
	private final int idFuncionario;
	private static HashMap<Integer, String> mapaCargos = new HashMap<Integer, String>();
	private int idCargo;
	private float salario;
	
	public Funcionario(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero, int idCargo, float salario) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		this.idFuncionario = count.incrementAndGet();
		this.idCargo = idCargo;
		this.salario = salario;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	// CRUD para mapaCargos
	public static void putCargo(int idCargo, String cargo) {
		mapaCargos.put(idCargo, cargo);
		System.out.println(String.format("Id '%d', Cargo '%s' adicionado com sucesso", idCargo, mapaCargos.get(idCargo)));
	}
	public static void getCargo(int idCargo) {
		if (mapaCargos.containsKey(idCargo)) {
			System.out.println(String.format("Id '%d', Cargo '%s'", idCargo, mapaCargos.get(idCargo)));
		} else {
			System.out.println(String.format("ERRO! Id '%d' não existe!", idCargo));
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
}
