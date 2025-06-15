package upe_programacao_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO: Falta verificar se tem todos os CRUD na main
		// TODO: configurar os default para os switch/case
		// TODO: verificar breaks
		// TODO: comentar main
		// TODO: evolução: tentar enxugar main
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
						// TODO: ajeitar pra usar enum
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
						// TODO: ajeitar pra usar enum
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
							// Exibir uma categoria de produtos
							case 2:
								System.out.println("Digite o id da categoria desejada: ");
								int idCategoria = sc.nextInt();
								System.out.println(Produto.getCategoriaById(idCategoria));
								break;
							// Exibir todo o estoque
							case 3:
								for (Produto produto : Produto.getListaProdutos()) {
									System.out.println(produto);
								}
								break;
							// Exibir todas as categorias
							case 4:
								System.out.println(String.format("""

Categorias disponíveis:

%s

""", Produto.getMapaCategorias()));
							// Gerenciar estoque
							case 5:
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
											loopModificarProduto: while (true) {
												Produto produtoAModificar = null;
												// TODO: testar se throw new erro interrompe programa no caso de id/nome não existir.
												loopSelecionarProduto: while (true) {
													System.out.println(Menu.menuSelecionarProduto);
													opcao = sc.nextInt();
													switch (opcao) {
														// TEST: Checar se "break loopSelecionarProduto" no final é suficiente
														case 1:
															System.out.println("Digite o id do produto: ");
															int idProduto = sc.nextInt();
															produtoAModificar = Produto.getProdutoById(idProduto);
															break;
														case 2:
															System.out.println("Digite o nome do produto: ");
															nomeProduto = sc.nextLine();
															produtoAModificar = Produto.getProdutoByNome(nomeProduto);
															break;
														case 0:
															break loopModificarProduto;
													}
													break loopSelecionarProduto;
												}
												if (produtoAModificar != null) {
													System.out.println(Menu.menuModificarProduto);
													opcao = sc.nextInt();
													switch (opcao) {
														// SKU
														case 1:
															String skuAtual = produtoAModificar.getSku();
															System.out.println("Digite o SKU novo: ");
															String skuNovo = sc.nextLine();
															System.out.println(String.format("""
Você tem certeza que deseja modificar o SKU do produto?

Produto:
%s

SKU atual: %s
SKU novo: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, skuAtual, skuNovo));
															char confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setSku(skuNovo);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														// Nome do produto
														case 2:
															String nomeAtual = produtoAModificar.getNomeProduto();
															System.out.println("Digite o nome novo: ");
															String nomeNovo = sc.nextLine();
															System.out.println(String.format("""
Você tem certeza que deseja modificar o nome do produto?

Produto:
%s

Nome atual: %s
Nome novo: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, nomeAtual, nomeNovo));
															confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setNome(nomeNovo);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														// Descrição
														case 3:
															String descricaoAtual = produtoAModificar.getDescricao();
															System.out.println("Digite a descrição nova: ");
															String descricaoNova = sc.nextLine();
															System.out.println(String.format("""
Você tem certeza que deseja modificar a descrição do produto?

Produto:
%s

Descrição atual: %s
Descrição nova: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, descricaoAtual, descricaoNova));
															confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setDescricao(descricaoNova);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														case 4:
															double valorAtual = produtoAModificar.getValor();
															System.out.println("Digite o valor novo: ");
															double valorNovo = sc.nextDouble();
															System.out.println(String.format("""
Você tem certeza que deseja modificar o valor do produto?

Produto:
%s

Valor atual: %s
Valor novo: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, valorAtual, valorNovo));
															confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setValor(valorNovo);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														// Categoria
														// TODO: ajeitar pra usar enum
														case 5:
															int categoriaAtual = produtoAModificar.getIdCategoria();
															System.out.println("Digite o id da categoria nova: ");
															int categoriaNova = sc.nextInt();
															System.out.println(String.format("""
Você tem certeza que deseja modificar a categoria do produto?

Produto:
%s

Id da categoria atual: %s
Id da categoria nova: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, categoriaAtual, categoriaNova));
															confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setIdCategoria(categoriaNova);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														// Quantidade em estoque
														case 6:
															int qtdAtual = produtoAModificar.getQtdEstoque();
															System.out.println("Digite a quantidade nova: ");
															int qtdNova = sc.nextInt();
															System.out.println(String.format("""
Você tem certeza que deseja modificar a quantidade do produto?

Produto:
%s

Quantidade atual: %s
Quantidade nova: %s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produtoAModificar, qtdAtual, qtdNova));
															confirmacao = sc.next().charAt(0);
															if (Character.toLowerCase(confirmacao) == 's') {
																produtoAModificar.setQtdEstoque(qtdNova);
																System.out.println(String.format("Produto foi modificado com sucesso!"));
															} else {
																System.out.println("Operação cancelada!");
																break loopModificarProduto;
															}
															break loopModificarProduto;
														// Retornar ao menu anterior
														case 0:
															break loopModificarProduto;
													}
												} else {
													break loopModificarProduto;
												}
											}
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
						opcao = sc.nextInt();
						switch (opcao) {
							// Realizar venda
							// TODO: alterar status para realizada, algo assim.
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
							// Cancelar venda realizada
							case 3:
								// TODO
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
					// TO DO: Salvar tudo em json antes de fechar
					System.out.println("Até logo!");
					sc.close();
					break loopMain;
			}
		}
	}
}