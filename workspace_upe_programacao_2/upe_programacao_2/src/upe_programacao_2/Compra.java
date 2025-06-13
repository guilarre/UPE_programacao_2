package upe_programacao_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import upe_programacao_2.Compra.CompraProduto;

public class Compra {
	// Contador para autoincrementar idCompra
	private static AtomicInteger count = new AtomicInteger(0);
	private final int idCompra;
	private int idCliente;
	private int idFuncionario;
	private LocalDateTime dataHora;
	private ArrayList<CompraProduto> listaProdutos = null;
	private double subtotal = 0;
	private double desconto = 1;
	private double total = 0;
	private int idPagamento;
	private static HashMap<Integer, String> mapaPagamentos;
	private int idStatus;
	private static HashMap<Integer, String> mapaStatus;
	
	// TODO: precisa passar listaProdutos(ArrayList de CompraProduto) ao criar Compra
	public Compra(int idCliente, int idFuncionario, ArrayList<CompraProduto> listaProdutos, double subtotal, double desconto, int idPagamento, int idStatus) {
		idCompra = count.incrementAndGet();
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
		this.dataHora = LocalDateTime.now();
		this.listaProdutos = listaProdutos;
		for (CompraProduto compraProduto : listaProdutos) {
			this.subtotal += compraProduto.getTotal();			
		}
		if (desconto != 0) {			
			this.desconto = Math.abs(desconto - 100)/100;
		}
		this.total = subtotal * desconto;
		this.idPagamento = idPagamento;
		this.idStatus = idStatus;
	}
		
	//getters and setters
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getDataHora() {
		String formatterString = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterString);
		return dataHora.format(formatter);
	}
	public LocalDateTime getObjetoDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	// Getter para objeto Compra
	public static ArrayList<CompraProduto> getObjetoCompraProduto() {
		// TODO: case default???
		// Menu para selecionar modo de busca
		// TEST: espaçamento correto na UI
		// TODO: falta passar o desconto para cada produto e para total da compra
		ArrayList<CompraProduto> listaProdutos = new ArrayList<CompraProduto>();
		Produto produtoSelecionado = null;
		double desconto = 1;
		int qtdComprada = 0;
		CompraProduto compraProduto = null;
		
		Scanner sc = new Scanner(System.in);
		loopSelecaoProdutos: while (true) {
			String menuSelecionarProduto = """

Selecione o(s) produto(s):

[1] = Procurar produto por seu id
[2] = Procurar produto por seu nome
[3] = Terminar seleção de produtos

[0] = Retornar ao menu anterior

""";
			System.out.println(menuSelecionarProduto);
			int opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					// Selecionando o produto pelo id
					System.out.println("Digite o id do produto: ");
					int idProduto = sc.nextInt();
					produtoSelecionado = Produto.getProdutoById(idProduto);
					System.out.println(String.format("Produto selecionado:\n\n%s", produtoSelecionado));
					// Desconto
					System.out.println("Digite o desconto em porcentagem, se aplicável (e.g. 12.5), se não houver desconto, digite 0: ");
					desconto = sc.nextDouble();
					// Qtd comprada
					System.out.println("Digite a quantidade que será comprada: ");
					qtdComprada = sc.nextInt();
					compraProduto = new Compra.CompraProduto(produtoSelecionado, qtdComprada, desconto);
					listaProdutos.add(compraProduto);
					break;
				case 2:
					// Selecionando o produto pelo nome
					System.out.println("Digite o nome do produto: ");
					String nomeProduto = sc.nextLine();
					produtoSelecionado = Produto.getProdutoByNome(nomeProduto);
					System.out.println(String.format("Produto selecionado:\n\n%s", produtoSelecionado));
					// Desconto
					System.out.println("Digite o desconto em porcentagem, se aplicável (e.g. 12.5), se não houver desconto, digite 0: ");
					desconto = sc.nextDouble();
					// Qtd comprada
					System.out.println("Digite a quantidade que será comprada: ");
					qtdComprada = sc.nextInt();
					compraProduto = new Compra.CompraProduto(produtoSelecionado, qtdComprada, desconto);
					listaProdutos.add(compraProduto);
					break;
				case 3:
					sc.close();
					return listaProdutos;
				case 0:
					System.out.println("Operação cancelada!");
					break loopSelecaoProdutos;
			}
		}
		sc.close();
		return null; // TODO: em getObjetoCompra, reconhece se é null e cancela operação
	}
	public static Compra getObjetoCompra() {
		
	}
	
	// CRUD para mapaPagamentos, mapaStatus e listaProdutos
	public static void putPagamentos(int idPagamento, String pagamento) {
		mapaPagamentos.put(idPagamento, pagamento);
		System.out.println(String.format("Id '%d', Pagamento '%s' adicionado com sucesso!", idPagamento, mapaPagamentos.get(idPagamento)));
	}
	public static String getMapaPagamentos() {
		for (int i : mapaPagamentos.keySet()) {
			return String.format("Id '%d', Forma de pagamento '%s'", i, mapaPagamentos.get(i)); 
		}
		return "ERRO! Ainda não existem formas de pagamento registradas.";
	}
	public static String getPagamentoById(int idPagamento) {
		if (mapaPagamentos.containsKey(idPagamento)){
			return mapaPagamentos.get(idPagamento);
		} else { 
			throw new IllegalArgumentException(String.format("ERRO! Id '%d' não existe!", idPagamento));
		}
	}
	public static void modifyPagamentos(int idPagamento, String pagamento) {
		if (mapaPagamentos.containsKey(idPagamento)){
			mapaPagamentos.put(idPagamento, pagamento);
			System.out.println(String.format("Id '%d' modificado para forma de pagamento: '%s' com sucesso!", idPagamento, pagamento));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}
	}
	public static void removePagamentos(int idPagamento) {
		if (mapaPagamentos.containsKey(idPagamento)){
			mapaPagamentos.remove(idPagamento);
			System.out.println(String.format("Id '%d', Pagamento '%s' removido com sucesso!", idPagamento, mapaPagamentos.get(idPagamento)));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}
	}
	public static void putStatus(int idStatus, String status) {
		mapaStatus.put(idStatus, status);
		System.out.println(String.format("Id '%d', Status '%s' adicionado com sucesso!", idStatus, mapaStatus.get(idStatus)));
	}
	public static String getMapaStatus() {
		for (int i : mapaStatus.keySet()) {
			return String.format("Id '%d', Status de compra '%s'", i, mapaStatus.get(i)); 
		}
		return "ERRO! Ainda não existem status de compra registrados.";
	}
	public static String getStatusById(int idStatus) {
		if (mapaStatus.containsKey(idStatus)){
			return mapaStatus.get(idStatus);
		} else { 
			throw new IllegalArgumentException(String.format("ERRO! Id '%d' não existe!", idStatus));
		}
	}
	public static void modifyStatus(int idStatus, String status) {
		if (mapaStatus.containsKey(idStatus)){
			mapaStatus.put(idStatus, status);
			System.out.println(String.format("Id '%d' modificado para status de compra: '%s' com sucesso!", idStatus, status));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}
	}
	public static void removeStatus(int idStatus) {
		if (mapaStatus.containsKey(idStatus)){
			mapaStatus.remove(idStatus);
			System.out.println(String.format("Id '%d', Status '%s' removido com sucesso!", idStatus, mapaStatus.get(idStatus)));
		} else { 
			System.out.println(String.format("ERRO! Id '%d' não existe!", idStatus));
		}
	}
	
	public ArrayList<CompraProduto> getListaProdutos() {
		return listaProdutos;
	}
	public double getTotalListaProdutos() {
		double total = 0;
		for (CompraProduto compraProduto : listaProdutos) {
			total += compraProduto.getTotal();
		}
		return total;
	}
	
	// TODO: resto do crud de listaProdutos
	
	@Override 
	public String toString() {
		return String.format("""

Id da compra: '%d'

Id do cliente: '%d'
Id do Funcionário: '%d'
Data e hora da compra: '%s'
Subtotal: '%d'
Desconto: '%d'
Total: R$ %.2f
Id do Pagamento: '%d'
Id do Status: '%d'

""", this.getIdCliente(), this.getIdFuncionario(), this.getDataHora(), this.getSubtotal(), this.getDesconto(), this.getTotal(), Compra.getPagamentoById(this.getIdPagamento()), Compra.getStatusById(this.getIdStatus()));
	}
	
	public static class CompraProduto {
		private Produto produto;
		private int qtdComprada = 0;
		private double desconto = 1;
		private double total = 0;
		
		public CompraProduto(Produto produto, int qtdComprada, double desconto) {
			this.produto = produto;
			this.qtdComprada = qtdComprada;
			if (desconto != 0) {			
				this.desconto = Math.abs(desconto - 100)/100;
			}
			this.total = (produto.getValor() * qtdComprada) * desconto;
		}
		
		//Getters and Setters
		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		public int getQtdComprada() {
			return qtdComprada;
		}
		public void setQtdComprada(int qtdComprada) {
			this.qtdComprada = qtdComprada;
		}
		public double getDesconto() {
			return desconto;
		}
		public void setDesconto(int desconto) {
			this.desconto = desconto;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}

		@Override
		public String toString () {
			return String.format("""
					
Id do Produto: '%d'
Nome do Produto: '%s'
Quantidade: '%d'
Desconto: '%f'
Total: R$ %.2f

""", this.getProduto().getIdProduto(), this.getProduto().getNomeProduto(), this.getQtdComprada(), this.getDesconto(), this.getTotal());
		}
	}
}