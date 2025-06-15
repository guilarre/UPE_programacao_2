package upe_programacao_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import enums.Pagamento;
import enums.Status;

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
	private Pagamento pagamento = null;
	private Status status = Status.EM_PROCESSAMENTO;
	
	// TODO: precisa passar listaProdutos(ArrayList de CompraProduto) ao criar Compra
	public Compra(int idCliente, int idFuncionario, ArrayList<CompraProduto> listaProdutos, double subtotal, double desconto, Pagamento pagamento) {
		idCompra = count.incrementAndGet();
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
		this.dataHora = LocalDateTime.now();
		this.listaProdutos = listaProdutos;
		for (CompraProduto compraProduto : listaProdutos) {
			this.subtotal += compraProduto.getTotal();			
		}
		if (desconto != 0) {
			// Math.abs para deixar positivo
			this.desconto = Math.abs(desconto - 100) / 100;
		}
		this.total = subtotal * desconto;
		this.pagamento = pagamento;
		status = Status.SUCESSO;
		// Salvar compra no histórico
		Historico.addToHistorico(this);
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
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public static String getPagamentoValue(Pagamento pagamento) {
		switch (pagamento) {
			case A_VISTA:
				return "À vista";
			case PIX:
				return "Pix";
			case DEBITO:
				return "Débito";
			case CREDITO:
				return "Crédito";
			case CHEQUE:
				return "Cheque";
			default:
				return "ERRO! Forma de pagamento ainda não registrada";
		}
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public static String getStatusValue(Status status) {
		switch (status) {
			case CANCELADA:
				return "Cancelada";
			case EM_PROCESSAMENTO:
				return "Em processamento";
			case SUCESSO:
				return "Sucesso";
			default:
				return "ERRO! Status ainda não registrado";
		}
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
					System.out.println("Digite o desconto DO PRODUTO em porcentagem, se aplicável (e.g. 12.5).\nSe não houver desconto, digite 0: ");
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
					System.out.println("Digite o desconto DO PRODUTO em porcentagem, se aplicável (e.g. 12.5).\nSe não houver desconto, digite 0: ");
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
	public static Compra getObjetoCompra(Cliente cliente, Funcionario funcionario) {
		// Setup
		ArrayList<CompraProduto> listaProdutos = Compra.getObjetoCompraProduto();
		double subtotal = 0;
		Pagamento pagamento = null;
		//Subtotal
		for (CompraProduto compraProduto : listaProdutos) {
			subtotal += compraProduto.getTotal();
		}
		// Desconto
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o desconto DA COMPRA em porcentagem, se aplicável (e.g. 12.5).\nSe não houver desconto, digite 0: ");
		double desconto = sc.nextDouble();
		// pagemento (forma de pagamento)
		System.out.println("""

Escolha a forma de pagamento:

[1] = À vista
[2] = Pix
[3] = Débito
[4] = Crédito
[5] = Cheque

""");
		int opcaoPagamento = sc.nextInt();
		switch (opcaoPagamento) {
			case 1:
				pagamento = Pagamento.A_VISTA;
				break;
			case 2:
				pagamento = Pagamento.PIX;
				break;
			case 3:
				pagamento = Pagamento.DEBITO;
				break;
			case 4:
				pagamento = Pagamento.CREDITO;
				break;
			case 5:
				pagamento = Pagamento.CHEQUE;
				break;
		}
		sc.close();
		// Retornar objeto compra
		Compra compra = new Compra(cliente.getIdCliente(), funcionario.getIdFuncionario(), listaProdutos, subtotal, desconto, pagamento);
		return compra;
	}
	
	// TODO: resto dos CRUD de listaProdutos
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
Forma de pagamento: '%s'
Status: '%s'

""", this.getIdCliente(), this.getIdFuncionario(), this.getDataHora(), this.getSubtotal(), this.getDesconto(), this.getTotal(), Compra.getPagamentoValue(pagamento), Compra.getStatusValue(status));
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
				// Math.abs para deixar positivo
				this.desconto = Math.abs(desconto - 100) / 100;
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