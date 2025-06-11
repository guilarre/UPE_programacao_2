package upe_programacao_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TO DO: Falta verificar se tem todos os CRUD na main
		// Carregar arquivos em memória
		JsonReader.carregarClientes();
		JsonReader.carregarFuncionarios();
		JsonReader.carregarEstoque();
		JsonReader.carregarHistorico();
		
		// Iniciar loop do menu principal
		Scanner sc = new Scanner(System.in);
		loopMain: while (true) {
			System.out.println(Menu.menuPrincipal);
			String opcao = sc.nextLine();
			switch (opcao) {
				// Menu clientes
				case "1":
					loopCliente: while (true) {
						System.out.println(Menu.menuClientes);
						opcao = sc.nextLine();
						switch (opcao) {
						case "1":
							System.out.println(Cliente.getClientes());
							break;
						case "2":
							System.out.println("Digite o id do Cliente: ");
							int idCliente = sc.nextInt();
							System.out.println(Historico.getHistoricoCliente(idCliente));
						case "3":
							System.out.println("Digite o nome do cliente: ");
							String nome = sc.nextLine();
							System.out.println("Digite o cpf do cliente: ");
							String cpf = sc.nextLine();
							System.out.println("Digite o telefone do cliente: ");
							String telefone = sc.nextLine();
							System.out.println("Digite o email do cliente: ");
							String email = sc.nextLine();
							System.out.println("Digite a preferência de comunicação do cliente: ");
							String preferenciaComunicacao = sc.nextLine();
							System.out.println("Digite o endereco residencial do cliente: ");
							String endereco = sc.nextLine();
							System.out.println("Digite o aniversário do cliente (e.g. 12/12/2012): ");
							String aniversario = sc.nextLine();
							System.out.println("Digite o gênero do cliente: ");
							String genero = sc.nextLine();
							new Cliente(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero);
							System.out.println("Cliente registrado com sucesso!");
							break;
						case "4":
							break loopCliente;
						}
					}
				case "2":
					loopFuncionario: while (true) {
						System.out.println(Menu.menuFuncionarios);
						opcao = sc.nextLine();
						switch (opcao) {
						case "1":
							System.out.println(Funcionario.getFuncionarios());
							break;
						case "2":
							System.out.println("Digite o id do Funcionário: ");
							int idFuncionario = sc.nextInt();
							System.out.println(Historico.getHistoricoFuncionario(idFuncionario));
						case "3":
							System.out.println("Digite o nome do funcionário: ");
							String nome = sc.nextLine();
							System.out.println("Digite o cpf do funcionário: ");
							String cpf = sc.nextLine();
							System.out.println("Digite o telefone do funcionário: ");
							String telefone = sc.nextLine();
							System.out.println("Digite o email do funcionário: ");
							String email = sc.nextLine();
							System.out.println("Digite a preferência de comunicação do funcionário: ");
							String preferenciaComunicacao = sc.nextLine();
							System.out.println("Digite o endereco residencial do funcionário: ");
							String endereco = sc.nextLine();
							System.out.println("Digite o aniversário do funcionário (e.g. 12/12/2012): ");
							String aniversario = sc.nextLine();
							System.out.println("Digite o gênero do funcionário: ");
							String genero = sc.nextLine();
							int idCargo = sc.nextInt();
							float salario = sc.nextFloat();
							new Funcionario(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero, idCargo, salario);
							System.out.println("Funcionário registrado com sucesso!");
							break;
						case "4":
							break loopFuncionario;
						}
					}
				// TO DO: resolver parte de estoque
				case "3":
					loopEstoque: while (true) {
						System.out.println(Menu.menuEstoque);
						opcao = sc.nextLine();
						switch (opcao) {
							case "1":
								
								break;
							case "2":
								break;
							case "3":
								for (Produto produto : Produto.getListaProdutos()) {
									System.out.println(produto);
								}
								break;
							case "4":
								break;
							case "5":
								break loopEstoque;
						}
					}
				case "4":
					break;
				case "5":
					// TO DO: Salvar tudo em json antes de fechar
					System.out.println("Até logo!");
					sc.close();
					break loopMain;
			}
		}
	}
}