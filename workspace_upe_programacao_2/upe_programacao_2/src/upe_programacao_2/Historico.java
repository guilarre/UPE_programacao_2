package upe_programacao_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import upe_programacao_2.Compra.CompraProduto;

public class Historico {
	private static ArrayList<Compra> historico = new ArrayList<Compra>();
	
	// CRUD para historico
	public static void addToHistorico(Compra compra) {
		historico.add(compra);
		System.out.println("Compra adicionada ao histórico com sucesso!");
	}
	public static ArrayList<Compra> getHistorico() {
		return historico;
	}
	
	// Getter do histórico geral (chama toString() de cada objeto Compra)
	public static String exibirHistoricoCompleto() {
		if (historico.isEmpty()) {
			return "O histórico ainda não foi registrado";
		}
		StringBuilder historicoCompleto = new StringBuilder();
		for (int i = 0; i < historico.size(); i++) {
			historicoCompleto.append(String.format("Índice: %d\nCompra:\n%s\n\n", i, historico.get(i).toString()));
		}
		return String.valueOf(historicoCompleto);
	}
	
	// Getter de uma compra específica do histórico
	public static String getCompraByIndex(int idx) {
		try {
			return String.format("Índice: %d\nCompra:\n%s", idx, historico.get(idx).toString());
		} catch (IndexOutOfBoundsException e) {
			return String.format("ERRO! Índice '%d' não existe", idx);
		}
	}
	
	// Getter para compras de um cliente específico
	// TODO: quando tiver json dos clientes e funcionarios,
	// extrair NOME do cliente/funcionário para mostrar no return em vez do idCliente???
	public static String getHistoricoCliente(int idCliente) {
		// Verificar primeiro se idCliente existe
		ArrayList<Integer> idsDisponiveis = new ArrayList<Integer>();
		for (Cliente cliente : Cliente.getListaClientes()) {
			idsDisponiveis.add(cliente.getIdCliente());
		}
		if (idsDisponiveis.contains(idCliente) == false) {
			return String.format("ERRO! A id '%d' não foi registrada ainda", idCliente);
		}
		// Pegar histórico do cliente
		StringBuilder historicoCliente = new StringBuilder();
		for (Compra compra : historico) {
			if (compra.getIdCliente() == idCliente) {
				historicoCliente.append(compra.toString() + "\n\n");
			}
		}
		if (historicoCliente.isEmpty()) {
			return String.format("ERRO! O cliente de id '%d' ainda não possui compras registradas", idCliente);
		}
		return String.format("""
Compras do cliente de id '%d':

%s
""", idCliente, historicoCliente);
	}
	
	// Getter para vendas de um funcionário específico
	// TODO: Opção para mostrar apenas as do mês especificado
	public static String getHistoricoFuncionario(int idFuncionario) {
		// Verificar primeiro se idFuncionario existe
		ArrayList<Integer> idsDisponiveis = new ArrayList<Integer>(); 
		for (Funcionario funcionario : Funcionario.getListaFuncionarios()) {
			idsDisponiveis.add(funcionario.getIdFuncionario());
		}
		if (idsDisponiveis.contains(idFuncionario) == false) {
			return String.format("ERRO! A id '%d' não foi registrada ainda", idFuncionario); 
		}
		// Pegar histórico do funcionário
		StringBuilder historicoFuncionario = new StringBuilder();
		for (Compra compra : historico) {
			if (compra.getIdFuncionario() == idFuncionario) {
				historicoFuncionario.append(compra.toString() + "\n\n");
			}
			if (historicoFuncionario.isEmpty()) {
				return String.format("ERRO! O funcionário de id '%d' ainda não possui vendas registradas", idFuncionario);
			}
		}
		return String.format("""
Vendas do funcionário de id '%d':

%s
""", idFuncionario, historicoFuncionario);
	}
	
	// TODO: testar esse setter!
	// Na main, seria criado um objeto Compra modificado (usando os setters de Compra),
	// que depois seria passado para setCompraHistorico
	// VERIFICAR: checar se somente pessoas adm poderão modificar/deletar (se sim,
	// deve haver uma validação de usuário logado nos respectivos métodos).
	public static void setCompraHistorico(int idx, Compra compra) {
		try {
			// Pegar compra a ser modificada para mostrar ao usuário (também já checa se existe ou não)
			String compraADeletar = Historico.getCompraByIndex(idx);
			// Confirmar operação
			Scanner sc = new Scanner(System.in);
			System.out.println(String.format("""
Você tem certeza que deseja modificar a compra a seguir?

Compra:
%s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", compraADeletar));
			char confirmacao = sc.next().charAt(0);
			sc.close();
			if (Character.toLowerCase(confirmacao) == 's') {
				historico.set(idx, compra);
				System.out.println(String.format("Histórico foi modificado com sucesso!\n\nId: '%d'\nCompra modificada:\n%s", idx, Historico.getCompraByIndex(idx)));
			} else {
				System.out.println("Operação cancelada!");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(String.format("ERRO! Índice '%d' não existe", idx));
		}
	}
	
	public static void removeCompraHistorico(int idx) {
		try {
			// Pegar compra a ser deletada para mostrar ao usuário (também já checa se existe ou não)
			String compraADeletar = Historico.getCompraByIndex(idx);
			// Confirmar operação
			Scanner sc = new Scanner(System.in);
			System.out.println(String.format("""
Você tem certeza que deseja remover a compra a seguir?

Compra:
%s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", compraADeletar));
			char confirmacao = sc.next().charAt(0);
			sc.close();
			if (Character.toLowerCase(confirmacao) == 's') {
				historico.remove(idx);
				System.out.println(String.format("Compra foi removida com sucesso!"));
			} else {
				System.out.println("Operação cancelada!");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(String.format("ERRO! Índice '%d' não existe", idx));
		}
	}
	
	//Gerar Relatório
	public static String gerarRelatorio() {
		ArrayList<Compra> comprasMes = new ArrayList<Compra>();
		for (Compra compra : historico) {
			if (compra.getObjetoDataHora().getMonth() == LocalDate.now().getMonth()) {
				comprasMes.add(compra);
			}
		}
		
		int qtdCompradaMes = 0;
		double totalCompradoMes = 0;
		for (Compra compra : comprasMes) {
			for (CompraProduto compraProduto : compra.getListaProdutos()) {
				qtdCompradaMes += compraProduto.getQtdComprada();
			}
			totalCompradoMes += compra.getTotal();
		}
		return String.format("""

############ Relatório do mês ############

Foram realizadas %d compras neste mês,
Totalizando R$ %.2f.

""", qtdCompradaMes, totalCompradoMes);
	}
}
