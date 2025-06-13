package upe_programacao_2;

public class Menu {
	// TO DO: falta crud para clientes, funcionários, estoque, e falta opção para gerar relatório de vendas
	public static String menuPrincipal = """
###### Sistema de gerenciamento LasCa ######

Selecione a opção desejada:

[1] = Clientes
[2] = Funcionários
[3] = Estoque
[4] = Vendas

[0] = Sair do sistema

-> """;
	
	public static String menuClientes = """

[1] = Exibir todos os clientes
[2] = Exibir histórico de compras de um cliente
[3] = Registrar cliente

[0] = Retornar ao menu principal

-> """;
	
	public static String menuFuncionarios = """

[1] = Exibir funcionários
[2] = Exibir histórico de vendas de um funcionário
[3] = Registrar funcionário

[0] = Retornar ao menu principal

-> """;
	
	public static String menuEstoque = """

[1] = Pesquisar um produto em estoque
[2] = Exibir uma categoria de produtos
[3] = Exibir todo o estoque
[4] = Exibir todas as categorias
[5] = Gerenciar estoque

[0] = Retornar ao menu principal

-> """;
	
	public static String menuPesquisaEstoque = """

[1] = Pesquisar por id do produto
[2] = Pesquisar pelo nome do produto

[0] = Retornar ao menu anterior

""";
	
	public static String menuGerenciarEstoque = """

[1] = Adicionar produto novo ao estoque
[2] = Modificar produto no estoque
[3] = Excluir produto do estoque

[0] = Retornar ao menu anterior

""";
	
	public static String menuSelecionarProduto = """

Qual produto deseja modificar?

[1] = Procurar produto por seu id
[2] = Procurar produto por seu nome

[0] = Retornar ao menu anterior

""";
	
	public static String menuRemoverProduto = """

Qual produto deseja remover?

[1] = Procurar produto por seu id
[2] = Procurar produto por seu nome

[0] = Retornar ao menu anterior

""";
	
	public static String menuModificarProduto = """

O que deseja alterar?

[1] = SKU
[2] = Nome do produto
[3] = Descrição
[4] = Valor
[5] = Categoria
[6] = Quantidade em estoque

[0] = Retornar ao menu anterior


""";
	
	public static String menuModificarCategoria = String.format("""

Categorias disponíveis:

%s

""", Produto.getMapaCategorias());
	
	// TO DO: MENU PRA REALIZAR VENDA
	
}