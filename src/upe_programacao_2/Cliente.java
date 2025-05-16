package upe_programacao_2;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Pessoa {
	private static final AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idCliente
	private final int idCliente;
	
	public Cliente(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		this.idCliente = count.incrementAndGet();
	}
	
	// Getters/setters
	public int getIdCliente() {
		return idCliente;
	}
	
	// toString()
	@Override
	public String toString() {
		return String.format("""
Cliente id: '%d'

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