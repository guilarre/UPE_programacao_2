package upe_programacao_2;
import java.time.LocalDate;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String preferenciaComunicacao;
	private String endereco;
	private LocalDate aniversario;
	private int idade;
	private String genero;
	
	// Construtor parametrizado (força subclasse a implementar esse construtor)
	public Pessoa(String nome, String cpf, String telefone, String email, String preferenciaComunicacao,
			String endereco, LocalDate aniversario, String genero) {
		this.nome = nome;
		if (validarCpf(cpf) == false) {
			throw new IllegalArgumentException("ERRO: CPF inválido!");
		}
		this.cpf = cpf;
		if (validarTelefone(telefone) == false) {
			throw new IllegalArgumentException("ERRO: Telefone inválido!");
		}
		this.telefone = telefone;
		if (validarEmail(email) == false) {
			throw new IllegalArgumentException("ERRO: Email inválido!");
		}
		this.email = email;
		this.preferenciaComunicacao = preferenciaComunicacao;
		this.endereco = endereco;
		this.aniversario = aniversario;
		//Calculando idade a partir de aniversario
		int anoNascimento = aniversario.getYear();
		this.idade = LocalDate.now().getYear() - anoNascimento;
		this.genero = genero;
	}
	
	// Getters/setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreferenciaComunicacao() {
		return preferenciaComunicacao;
	}
	public void setPreferenciaComunicacao(String preferenciaComunicacao) {
		this.preferenciaComunicacao = preferenciaComunicacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDate getAniversario() {
		return aniversario;
	}
	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	// Validador básico de CPF (sem validação do DV)
	public boolean validarCpf(String cpf) {
		// Retira tudo que não é dígito
		cpf = cpf.replaceAll("[^0-9]", "");
		
		// Checa se é nulo/vazio, diferente de 11 ou se é uma sequência de números repetidos
		if (cpf == null || cpf.isEmpty() || cpf.length() != 11 || cpf.matches("(.)\\1{10,}")) {
            return false;
        }
        return true;
	}
	
	//Validador de telefone
	public boolean validarTelefone(String telefone) {
		// Retira tudo que não é dígito
		telefone = telefone.replaceAll("[^0-9]", "");
		
		// Checa se telefone contém 8 ou 9 dígitos
		if (telefone.length() == 8 || telefone.length() == 9) {
			return true;
		}
		return false;
	}
	
	//Validador de email
	public boolean validarEmail(String email) {
		// Verifica se é nulo/vazio
		if (email == null || email.isEmpty()) {
			return false;
		}
		// Verifica se contém @
		return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}
	
}
