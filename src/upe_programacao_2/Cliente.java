package upe_programacao_2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Pessoa {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String preferenciaComunicacao;
	private String endereco;
	private LocalDate aniversario;
	private String genero;
	private static final AtomicInteger count = new AtomicInteger(0); // Contador para autoincrementar idCliente
	private final int idCliente;
	private ArrayList<Compra> historicoCompras;
	
	public Cliente(String nome, String cpf, String telefone, String email, String preferenciaComunicacao, String endereco, String aniversario, String genero) {
		super(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
		this.idCliente = count.incrementAndGet();
		this.historicoCompras = new ArrayList<Compra>();
	}
	
	// Getters/setters
	public int getIdCliente() {
		return idCliente;
	}
	
	// Chama toString() de cada objeto Compra
	public String getHistoricoCompras() {
		for (Compra compra : historicoCompras) {
			return compra.toString();
		}
	}
	
	// Função para adicionar compra em historicoCompras
	public void addHistoricoCompras(Compra compra) {
		historicoCompras.add(compra);
	}
	
}