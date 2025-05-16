package upe_programacao_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Historico {
	private static ArrayList<Compra> historico = new ArrayList<Compra>();
	
	// CRUD para historico
	public static void addToHistorico(Compra compra) {
		historico.add(compra);
		System.out.println("Compra adicionada ao histórico com sucesso!");
	}
	// Getter do histórico geral (chama toString() de cada objeto Compra)
	public static String getHistorico() {
		for (int i = 0; i < historico.size(); i++) {
			return String.format("Índice: %d\nCompra:\n%s\n\n", i, historico.get(i).toString());
		}
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
	public static String getHistoricoCliente(int idCliente) {
		
	}
	// Getter para vendas de um funcionário específico
	
	// TO DO: testar esse setter!
	// Na main, seria criado um objeto Compra modificado (usando os setters de Compra),
	// que depois seria passado para setCompraHistorico
	// VERIFICAR: checar se somente pessoas adm poderão modificar/deletar (se sim,
	// deve haver uma validação de usuário logado nos respectivos métodos).
	public static void setCompraHistorico(int idx, Compra compra) {
		try {
			// Pegar compra a ser deletada para mostrar ao usuário (também já checa se existe ou não)
			String compraADeletar = Historico.getCompraByIndex(idx);
			// Confirmar operação
			Scanner sc = new Scanner(System.in);
			System.out.println(String.format("""
Você tem certeza que deseja modificar a compra a seguir?

Compra:
%s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", compraADeletar));
			char confirmacao = sc.next().charAt(0);
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
}
