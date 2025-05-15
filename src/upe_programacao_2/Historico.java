package upe_programacao_2;

import java.util.ArrayList;

public class Historico {
	private static ArrayList<Compra> historico;
	
	public Historico() {
		this.historico = new ArrayList<Compra>();
	}
	
	// CRUD para historicoVendas
		// Chama toString() de cada objeto Compra
		public void addHistoricoVendas(Compra compra) {
			historicoVendas.add(compra);
		}
		// Getter geral do histórico
		public void getHistoricoVendas() {
			for (Compra compra : historicoVendas) {
				int i = 0;
				System.out.println(String.format("Índice: %d, Compra: %s", i, compra.toString()));
				i += 1;
			}
		}
		// Getter de uma compra específica do histórico
		public void getCompraByIndex(int idx) {
			try {
				System.out.println(String.format("Índice: %d, Compra: %s", idx, historicoVendas.get(idx).toString()));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(String.format("ERRO! Índice '%d' não existe", idx));
			}
		}
		// TO DO: testar esse setter!
		// Na main, seria criado um objeto Compra modificado (usando os setters de Compra),
		// que depois seria passado para setHistoricoVendas
		// VERIFICAR: ver se faz sentido imprimir o histórico completo após modificação, ou apenas o objeto compra.
		// TO DO: mensagem de confirmação para modificar/deletar
		// VERIFICAR: checar se somente pessoas adm podem modificar/deletar
		public void setHistoricoVendas(int idx, Compra compra) {
			try {
				historicoVendas.set(idx, compra);
				System.out.println(String.format("Histórico de vendas foi modificado com sucesso! Histórico novo: %s", historicoVendas.getHistoricoVendas()));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(String.format("ERRO! Índice '%d' não existe", idx));
			}
		}
		public void removeHistoricoVendas(int idx) {
			try {
				historicoVendas.getHis
				System.out.println(String.format("Histórico de vendas foi modificado com sucesso! Histórico novo: %s", historicoVendas.getHistoricoVendas()));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(String.format("ERRO! Índice '%d' não existe", idx));
			}
		}
}
