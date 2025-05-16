package upe_programacao_2;

public class Testes {

	public static void main(String[] args) {
//		Cliente cliente = new Cliente("Gui", "123.321.123-43", "(81)996212351", "guilherme@gmail.com", "email", "R. Pereira Simões, 475", "20/07/1996", "masculino");
//		System.out.println(cliente.toString());
//		
		Funcionario.putCargo(1, "CEO");
		Funcionario funcionario = new Funcionario("Gui", "123.321.123-43", "(81)996212351", "guilherme@gmail.com", "email", "R. Pereira Simões, 475", "20/07/1996", "masculino", 1, 300000f);
		System.out.println(funcionario.toString());
	}

}
