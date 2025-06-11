package upe_programacao_2;

public class Menu {
	// TO DO: colocar números em vez de letras nas opções
	public static String menuPrincipal = """
###### Sistema de gerenciamento LasCa ######

Selecione a opção desejada:

[1] = Clientes
[2] = Funcionários
[3] = Estoque
[4] = Vendas
[5] = Sair

-> """;
	
	public static String menuClientes = """

[1] = Exibir clientes
[2] = Exibir histórico de compras de um cliente
[3] = Registrar cliente
[4] = Sair e retornar ao menu principal

-> """;
	
	public static String menuFuncionarios = """

[1] = Exibir funcionários
[2] = Exibir histórico de vendas de um funcionário
[3] = Registrar funcionário
[4] = Sair e retornar ao menu principal

-> """;
	
	public static String menuEstoque = """

[1] = Pesquisar um produto em estoque
[2] = Exibir uma categoria de produtos
[3] = Exibir todo o estoque
[4] = Gerenciar estoque
[5] = Sair e retornar ao menu principal

-> """;
	
	public static String menuPesquisaEstoque = """

[1] = Pesquisar por id do produto
[2] = Pesquisar pelo nome do produto

""";
	
	public static String menuGerenciarEstoque = """

[1] = Adicionar produto ao estoque
[2] = Excluir produto do estoque
[3] = Modificar produto no estoque

""";
	
	public static String menuModificarProduto = """

O que deseja alterar?

[1] = SKU
[2] = Nome do produto
[3] = Descrição
[4] = Valor
[5] = Categoria
[6] = Quantidade em estoque

""";
	
	public static String menuModificarCategoria = String.format("""

Categorias disponíveis:

%s

""", Produto.getMapaCategorias());
	
	// TO DO: MENU PRA REALIZAR VENDA
	
}