package upe_programacao_2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Testes {

	public static void main(String[] args) {
		DateTimeFormatter formatter = new DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate aniversario = new LocalDate("2003-03-20");
		int anoNascimento = aniversario.getYear();
		int idade = LocalDate.now().getYear() - anoNascimento;
		
	}

}
