package upe_programacao_2;

public class Venda {
	// Vai conectar com Historico, Compra, Produto, Funcionario, Cliente
	
	public static void prepararCompra() {
		
	}
	
	// Retorna true/false e Main gerencia mensagem de erro/sucesso
	public static boolean realizarVenda() {
		Cliente cliente = Cliente.getObjetoCliente();
		Funcionario funcionario = Funcionario.getObjetoFuncionario();
		Compra compra = Compra.getObjetoCompra();
		
		return true;
	}
}
