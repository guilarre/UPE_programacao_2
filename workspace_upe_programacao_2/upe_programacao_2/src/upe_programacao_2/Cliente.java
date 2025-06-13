package upe_programacao_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Pessoa {
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	// Contador para autoincrementar idCliente
	private static AtomicInteger count = new AtomicInteger(0);
	private final int idCliente;
	
	public Cliente(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		idCliente = count.incrementAndGet();
		listaClientes.add(this);
	}
	
	// Getters/setters
	public int getIdCliente() {
		return idCliente;
	}
	public static String getClientes() {
		StringBuilder clientes = new StringBuilder();
		for (Cliente cliente : listaClientes) {
			clientes.append(cliente.toString() + "\n\n");			
		}
		if (clientes.isEmpty()) {
			return "ERRO! Nenhum cliente foi registrado ainda";
		}
		return String.valueOf(clientes);
	}
	
	// Getter para selecionar objeto cliente
	public static Cliente getClienteById(int idCliente) {
		for (Cliente cliente : Cliente.getListaClientes()) {
			if (cliente.getIdCliente() == idCliente) {
				return cliente;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe cliente de id '%d'", idCliente));
	}
	public static Cliente getClienteByNome(String nomeCliente) {
		for (Cliente cliente : Cliente.getListaClientes()) {
			if (cliente.getNome() == nomeCliente) {
				return cliente;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe cliente de nome '%s'", nomeCliente));
	}
	public static Cliente getObjetoCliente() {
		// TODO: case default???
		// Menu para selecionar modo de busca
		// TEST: espaçamento correto na UI
		String menuSelecionarCliente = """

[1] = Procurar cliente por seu id
[2] = Procurar cliente por seu nome

[0] = Retornar ao menu anterior

""";
		System.out.println(menuSelecionarCliente);
		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
			case 1:
				System.out.println("Digite o id do cliente: ");
				int idCliente = sc.nextInt();
				sc.close();
				System.out.println(String.format("Cliente selecionado:\n\n%s", getClienteById(idCliente)));
				return Cliente.getClienteById(idCliente);
			case 2:
				System.out.println("Digite o nome do cliente: ");
				String nomeCliente = sc.nextLine();
				sc.close();
				System.out.println(String.format("Cliente selecionado:\n\n%s", getClienteByNome(nomeCliente)));
				return Cliente.getClienteByNome(nomeCliente);
			case 0:
				System.out.println("Operação cancelada!");
				break;
		}
		sc.close();
		return null; // TODO: na Main, reconhece se é null e cancela operação
	}
	
	// Usado por JsonReader
	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public static void addToListaClientes(Cliente cliente) {
		listaClientes.add(cliente);
		count = new AtomicInteger(listaClientes.size());
	}
	
	// toString()
	@Override
	public String toString() {
		return String.format("""
Id do cliente: '%d'

Nome: %s
CPF: %s
Telefone: %s
Email: %s
Preferência de comunicação: %s
Endereço: %s
Aniversário: %s
Idade: %d
Gênero: %s
""", this.getIdCliente(), this.getNome(), this.getCpf(), this.getTelefone(), this.getEmail(), this.getPreferenciaComunicacao(), this.getEndereco(), this.getAniversario(), this.getIdade(), this.getGenero());
	}
}