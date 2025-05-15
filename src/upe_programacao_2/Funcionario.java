package upe_programacao_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class Funcionario extends Pessoa {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String preferenciaComunicacao;
	private String endereco;
	private LocalDate aniversario;
	private String genero;
	private static final AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idFuncionario
	private final int idFuncionario;
	private ArrayList<Compra> historicoVendas;
	private static HashMap<Integer, String> mapaCargos = new HashMap<Integer, String>();
	private int idCargo;
	private float salario;
	
	public Funcionario(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero, int idCargo, float salario) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		this.idFuncionario = count.incrementAndGet();
		this.historicoVendas = new ArrayList<Compra>();
		this.idCargo = idCargo;
		this.salario = salario;
	}
	
	// Getters/setters
	public int getIdFuncionario() {
		return idFuncionario;
	}
//	public int getIdCargo() {
//		return idCargo;
//	}
//	public void setIdCargo(int idCargo) {
//		this.idCargo = idCargo;
//	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	// Chama toString() de cada objeto Compra
	public void getHistoricoVendas() {
		for (Compra compra : historicoVendas) {
			System.out.println(compra.toString());
		}
	}
	
	// Função para adicionar compra em historicoVendas
	public void addHistoricoVendas(Compra compra) {
		historicoVendas.add(compra);
	}
	
	// Função para adicionar cargo em mapaCargos
	public void putCargo(int idCargo, String cargo) {
		mapaCargos.put(idCargo, cargo);
		System.out.println(String.format("Id '%d', Cargo '%s' adicionado com sucesso", idCargo, mapaCargos.get(idCargo)));
	}
	
	// Função para remover cargo de mapaCargos
	public void removeCargo(int idCargo) {
		if (mapaCargos.containsKey(idCargo)) {
			mapaCargos.remove(idCargo);
			System.out.println("Cargo removido com sucesso!");
		} else {
			System.out.println("ERRO! idCargo não existe!");
		}
	}
	
	// Função para ler cargo de mapaCargos
	public void getCargo(int idCargo) {
		if (mapaCargos.containsKey(idCargo)) {
			System.out.println(mapaCargos.get(idCargo));
		} else {
			System.out.println("ERRO! idCargo não existe!");
		}
	}
	
	// Função para modificar cargo de mapaCargos
	public void modifyCargo(int idCargo, String cargo) {
		mapaCargos.put(idCargo, cargo);
		System.out.println(String.format("Id '%d' modificado para Cargo: '%s' com sucesso", idCargo, mapaCargos.get(idCargo)));
	}
	
}
