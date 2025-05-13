package upe_programacao_2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Testes {

	public static void main(String[] args) {
		String formatterString = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterString);
		LocalDate aniversario = LocalDate.parse("20/07/1996", formatter);
		int anoNascimento = aniversario.getYear();
		int idade = LocalDate.now().getYear() - anoNascimento;
		System.out.println(formatterString);
	}

}
