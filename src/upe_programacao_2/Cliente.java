package upe_programacao_2;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Pessoa {
	private static final AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idCliente
	private final int idCliente;
	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public Cliente(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		idCliente = count.incrementAndGet();
		listaClientes.add(this);
	}
	
	// Getters/setters
	public int getIdCliente() {
		return idCliente;
	}
	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public static void addListaClientes(Cliente cliente) {
		listaClientes.add(cliente);
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