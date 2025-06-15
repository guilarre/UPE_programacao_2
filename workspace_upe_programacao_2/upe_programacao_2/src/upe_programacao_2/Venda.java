package upe_programacao_2;

import java.util.Scanner;

public class Venda {
	// Vai conectar com Historico, Compra, Produto, Funcionario, Cliente	
	// Retorna true/false e Main gerencia mensagem de erro/sucesso
	public static boolean realizarVenda() {
		Cliente cliente = Cliente.getObjetoCliente();
		Funcionario funcionario = Funcionario.getObjetoFuncionario();
		Compra compra = Compra.getCompraNova(cliente, funcionario);
		if (compra != null) {
			return true;
		}
		return false;
	}
	
	public static String pesquisarVendas() {
		// Setup
		Scanner sc = new Scanner(System.in);
		int opcao;
		// Prompts
		loopPesquisarVendas: while (true) {
			System.out.println(Menu.menuPesquisarVendas);
			opcao = sc.nextInt();
			switch (opcao) {
				// Pesquisar por cliente
				case 1:
					Cliente cliente = null;
					loopSelecionarCliente: while (true) {
						System.out.println(Menu.menuSelecionarCliente);
						opcao = sc.nextInt();
						switch (opcao) {
							case 1:
								System.out.println("Digite o id do cliente: ");
								int idCliente = sc.nextInt();
								cliente = Cliente.getClienteById(idCliente);
								break;
							case 2:
								System.out.println("Digite o nome do cliente: ");
								String nomeCliente = sc.nextLine();
								cliente = Cliente.getClienteByNome(nomeCliente);
								break;
							case 0:
								break loopSelecionarCliente;
						}
						break loopSelecionarCliente;
					}
					if (cliente != null) {
						Historico.getHistoricoCliente(cliente.getIdCliente());
					}
					break loopPesquisarVendas;
				// Pesquisar por funcionário
				case 2:
					Funcionario funcionario = null;
					loopSelecionarFuncionario: while (true) {
						System.out.println(Menu.menuSelecionarFuncionario);
						opcao = sc.nextInt();
						switch (opcao) {
							case 1:
								System.out.println("Digite o id do funcionário: ");
								int idFuncionario = sc.nextInt();
								funcionario = Funcionario.getFuncionarioById(idFuncionario);
								break;
							case 2:
								System.out.println("Digite o nome do funcionário: ");
								String nomeFuncionario = sc.nextLine();
								funcionario = Funcionario.getFuncionarioByNome(nomeFuncionario);
								break;
							case 0:
								break loopSelecionarFuncionario;
						}
						break loopSelecionarFuncionario;
					}
					if (funcionario != null) {
						Historico.getHistoricoFuncionario(funcionario.getIdFuncionario());
					}
					break loopPesquisarVendas;
				// Exibir todas as vendas
				case 3:
					Historico.exibirHistoricoCompleto();
					break loopPesquisarVendas;
				// Retornar ao menu anterior
				case 0:
					break loopPesquisarVendas;
			}
		}
	}
	
	public static boolean cancelarVenda() {
		
	}
}
