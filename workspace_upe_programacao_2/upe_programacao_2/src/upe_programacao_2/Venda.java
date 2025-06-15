package upe_programacao_2;

public class Venda {
	// Vai conectar com Historico, Compra, Produto, Funcionario, Cliente	
	// Retorna true/false e Main gerencia mensagem de erro/sucesso
	public static boolean realizarVenda() {
		Cliente cliente = Cliente.getObjetoCliente();
		Funcionario funcionario = Funcionario.getObjetoFuncionario();
		Compra compra = Compra.getObjetoCompra(cliente, funcionario);
		if (compra != null) {
			return true;
		}
		return false;
	}
//	public static pesquisarVenda() {
//		
//	}
}
