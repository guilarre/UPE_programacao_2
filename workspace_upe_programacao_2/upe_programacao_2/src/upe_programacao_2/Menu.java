package upe_programacao_2;

public class Menu {
	// Falta nome da loja
	public static String menuPrincipal = """
###### Sistema de gerenciamento ___ ######

Selecione a opção desejada:

[c] = Clientes
[f] = Funcionários
[e] = Estoque
[v] = Vendas
[s] = Sair

-> """;
	
	public static String menuClientes = """

[e] = Exibir clientes
[h] = Exibir histórico de compras de um cliente
[r] = Registrar cliente
[s] = Sair e retornar ao menu principal

-> """;
	
	public static String menuFuncionarios = """

[e] = Exibir funcionários
[h] = Exibir histórico de vendas de um funcionário
[r] = Registrar funcionário
[s] = Sair e retornar ao menu principal

-> """;
	
	public static String menuEstoque = """

[p] = Pesquisar produto em estoque
[r] = Registrar produto em estoque
[g] = Gerenciar estoque
[s] = Sair e retornar ao menu principal

-> """;
	
	
	
}