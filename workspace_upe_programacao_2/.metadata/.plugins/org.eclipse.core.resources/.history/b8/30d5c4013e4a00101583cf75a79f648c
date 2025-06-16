package upe_programacao_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO: Falta verificar se tem todos os CRUD na main
		// TODO: configurar os default para os switch/case
		// TODO: verificar breaks
		// TODO: comentar main
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
							Cliente.getClienteNovo();
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
							Funcionario.getFuncionarioNovo();
							break;
						// Retornar ao menu principal
						case 0:
							break loopFuncionario;
						}
					}
				// Menu estoque
				case 3:
					loopEstoque: while (true) {
						System.out.println(Menu.menuEstoque);
						opcao = sc.nextInt();
						switch (opcao) {
							// Pesquisar um produto em estoque
							case 1:
								loopPesquisarEstoque: while (true) {
									System.out.println(Menu.menuPesquisarEstoque);
									opcao = sc.nextInt();
									switch (opcao) {
										// Pesquisar por id do produto
										case 1:
											System.out.println("Digite o id do produto: ");
											int idProduto = sc.nextInt();
											System.out.println(Produto.getProdutoById(idProduto));
											break;
										// Pesquisar pelo nome do produto
										case 2:
											System.out.println("Digite o nome do produto: ");
											String nomeProduto = sc.nextLine();
											System.out.println(Produto.getProdutoByNome(nomeProduto));
											break;
										// Retornar ao menu anterior
										case 0:
											break loopPesquisarEstoque;
									}
								}
							// Exibir todas as categorias
							case 2:
								System.out.println(String.format("""

Categorias disponíveis:

%s

""", Produto.getTodasCategorias()));
								break;
							// Exibir todo o estoque
							case 3:
								for (Produto produto : Produto.getListaProdutos()) {
									System.out.println(produto);
								}
								break;
							// Gerenciar estoque
							case 4:
								loopGerenciarEstoque: while (true) {
									System.out.println(Menu.menuGerenciarEstoque);
									opcao = sc.nextInt();
									switch (opcao) {
										// Adicionar produto novo ao estoque
										// TODO: ajeitar pra usar enum
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
										// Modificar produto no estoque
										case 2:
											Produto produtoModificado = null;
											Produto produtoAModificar = Produto.selecionarProduto();
											if (produtoAModificar != null) {
												loopModificarProduto: while (true) {
													System.out.println(Menu.menuModificarProduto);
													opcao = sc.nextInt();
													switch (opcao) {
														case 1:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 2:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 3:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 4:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 5:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 6:
															produtoModificado = Produto.modificarProduto(produtoAModificar, opcao);
															if (produtoModificado == null) {
																System.out.println("ERRO! Modificação cancelada");
															}
															System.out.println(String.format("""

Produto modificado com sucesso:

%s

""", produtoModificado.toString()));
															break;
														case 0:
															break loopModificarProduto;
														default:
															System.out.println("ERRO! Opção inválida");
													}
												}
											} else {
												System.out.println("ERRO! Produto inexistente");
											}
											break;
										// Excluir produto do estoque
										case 3:
											loopRemoverProduto: while (true) {
												Produto produtoARemover = null;
												// TODO: testar se throw new erro interrompe programa no caso de id/nome não existir.
												loopSelecionarProduto: while (true) {
													System.out.println(Menu.menuRemoverProduto);
													opcao = sc.nextInt();
													switch (opcao) {
														case 1:
															System.out.println("Digite o id do produto: ");
															int idProduto = sc.nextInt();
															produtoARemover = Produto.getProdutoById(idProduto);
															break;
														case 2:
															System.out.println("Digite o nome do produto: ");
															nomeProduto = sc.nextLine();
															produtoARemover = Produto.getProdutoByNome(nomeProduto);
															break;
														case 0:
															break loopRemoverProduto;
													}
													break loopSelecionarProduto;
												}
												if (produtoARemover != null) {
													Produto.removeProduto(produtoARemover);
												}
												break loopRemoverProduto;
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
				// TODO: Menu vendas
				case 4:
					loopMenuVendas: while (true) {
						System.out.println(Menu.menuVendas);
						boolean vendaSucesso = false;
						boolean pesquisaSucesso = false;
						boolean cancelamentoSucesso = false;
						opcao = sc.nextInt();
						switch (opcao) {
							// Realizar venda
							case 1:
								vendaSucesso = Venda.realizarVenda();
								if (vendaSucesso) {
									System.out.println("Venda registrada com sucesso!");
									break;
								}
								System.out.println("ERRO! A venda não foi registrada");
								break;
							// Pesquisar vendas
							case 2:
								pesquisaSucesso = Venda.pesquisarVendas();
								if (pesquisaSucesso == false) {
									System.out.println("A pesquisa falhou!");
								}
								break;
							// Cancelar venda realizada
							case 3:
								cancelamentoSucesso = Venda.cancelarVenda();
								if (cancelamentoSucesso == false) {
									System.out.println("O cancelamento falhou!");
								}
								break;
							case 0:
								break loopMenuVendas;
						}
					}
				// TEST: Gerar relatório mensal
				case 5:
					Historico.gerarRelatorio();
					break;
				// Sair do sistema
				case 0:
					// TODO: Salvar tudo em json antes de fechar
					System.out.println("Até logo!");
					sc.close();
					break loopMain;
			}
		}
	}
}