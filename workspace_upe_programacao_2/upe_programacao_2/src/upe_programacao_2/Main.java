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
		
		// Menu principal
		Scanner sc = new Scanner(System.in);
		loopMain: while (true) {
			System.out.println(Menu.menuPrincipal);
			int opcao = sc.nextInt();
			switch (opcao) {
				// Menu clientes
				case 1:
					loopCliente: while (true) {
						System.out.println(Menu.menuClientes);
						opcao = sc.nextInt();
						switch (opcao) {
						// Exibir todos os clientes
						case 1:
							System.out.println(Cliente.getClientes());
							break;
						// Exibir histórico de compras de um cliente
						case 2:
							System.out.println("Digite o id do Cliente: ");
							int idCliente = sc.nextInt();
							System.out.println(Historico.getHistoricoCliente(idCliente));
							break;
						// Registrar cliente
						case 3:
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
						// Retornar ao menu principal
						case 0:
							break loopCliente;
						}
					}
				// Menu funcionários
				case 2:
					loopFuncionario: while (true) {
						System.out.println(Menu.menuFuncionarios);
						opcao = sc.nextInt();
						switch (opcao) {
						// Exibir funcionários
						case 1:
							System.out.println(Funcionario.getFuncionarios());
							break;
						// Exibir histórico de vendas de um funcionário
						case 2:
							System.out.println("Digite o id do Funcionário: ");
							int idFuncionario = sc.nextInt();
							System.out.println(Historico.getHistoricoFuncionario(idFuncionario));
							break;
						// Registrar funcionário
						case 3:
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
							double salario = sc.nextDouble();
							new Funcionario(nome, cpf, telefone, email, preferenciaComunicacao, endereco, aniversario, genero, idCargo, salario);
							System.out.println("Funcionário registrado com sucesso!");
							break;
						// Retornar ao menu principal
						case 0:
							break loopFuncionario;
						}
					}
				// TO DO: resolver parte de estoque
				// Menu estoque
				case 3:
					loopEstoque: while (true) {
						System.out.println(Menu.menuEstoque);
						opcao = sc.nextInt();
						switch (opcao) {
							// Pesquisar um produto em estoque
							case 1:
								loopPesquisaEstoque: while (true) {
									System.out.println(Menu.menuPesquisaEstoque);
									opcao = sc.nextInt();
									switch (opcao) {
										// Pesquisar por id do produto
										case 1:
											System.out.println("Digite o id do produto: ");
											int idProduto = sc.nextInt();
											Produto.getProdutoById(idProduto);
											break;
										// Pesquisar pelo nome do produto
										case 2:
											break;
										// Retornar ao menu anterior
										case 0:
											break loopPesquisaEstoque;
									}
								}
							// Exibir uma categoria de produtos
							case 2:
								System.out.println("Digite o id da categoria desejada: ");
								int idCategoria = sc.nextInt();
								System.out.println(String.format("Id '%d', categoria '%s'", idCategoria, Produto.getCategoriaById(idCategoria)));
								break;
							// Exibir todo o estoque
							case 3:
								for (Produto produto : Produto.getListaProdutos()) {
									System.out.println(produto);
								}
								break;
							// Exibir todas as categorias
							case 4:
								System.out.println(Produto.getMapaCategorias());
							// Gerenciar estoque
							case 5:
								loopGerenciarEstoque: while (true) {
									System.out.println(Menu.menuGerenciarEstoque);
									opcao = sc.nextInt();
									switch (opcao) {
										// Adicionar produto novo ao estoque
										case 1:
											System.out.println("Digite o código de estoque (SKU): ");
											String sku = sc.nextLine();
											System.out.println("Digite o nome do produto: ");
											String nomeProduto = sc.nextLine();
											System.out.println("Digite a descrição do produto: ");
											String descricao = sc.nextLine();
											System.out.println("Digite o valor do produto (e.g. 12.00): ");
											double valor = sc.nextDouble();
											System.out.println("Digite o id da categoria do produto: ");
											idCategoria = sc.nextInt();
											System.out.println("Digite a quantidade em estoque do produto: ");
											int qtdEstoque = sc.nextInt();
											Produto produtoNovo = new Produto(sku, nomeProduto, descricao, valor, idCategoria, qtdEstoque);
											System.out.println(String.format("O produto foi adicionado com sucesso!\n\n%s", produtoNovo.toString()));
											break;
										// Excluir produto do estoque
										case 2:
											break;
										// Modificar produto no estoque
										case 3:
											loopModificarProduto: while (true) {
												System.out.println(Menu.menuModificarProduto);
												opcao = sc.nextInt();
												switch (opcao) {
													// SKU
													case 1:
														break;
													// Nome do produto
													case 2:
														break;
													// Descrição
													case 3:
														break;
													// Valor
													case 4:
														break;
													// Categoria
													case 5:
														break;
													// Quantidade em estoque
													case 6:
														break;
													// Retornar ao menu anterior
													case 0:
														break loopModificarProduto;
												}
											}
											break;
										// Retornar ao menu anterior
										case 0:
											break loopGerenciarEstoque;
									}
								}
								break;
							// Retornar ao menu principal
							case 0:
								break loopEstoque;
						}
					}
				// Menu vendas
				case 4:
					break;
				// Sair do sistema
				case 0:
					// TO DO: Salvar tudo em json antes de fechar
					System.out.println("Até logo!");
					sc.close();
					break loopMain;
			}
		}
	}
}