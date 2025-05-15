package upe_programação_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Compra {

	//Id cliente
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int idCompra;
	
	
	private int idCliente;
	private int idFuncionario;
	private LocalDateTime dataHora;
	private ArrayList<CompraProduto> listaProdutos;
	private float subtotal;
	private float desconto;
	private float total;
	private int idPagamento;
	private static HashMap<Integer, String> mapaPagamentos;
	private int idStatus;
	private static HashMap<Integer, String> mapaStatus;
	
	public Compra(int idCliente, int idCompra, int idFuncionario, float subtotal, float desconto, float total, int idPagamento, int idStatus) {
		this.idCliente = idCliente;
		this.idCompra = count.incrementAndGet();
		this.idFuncionario = idFuncionario;
		this.dataHora = LocalDateTime.now();
		this.subtotal = subtotal;
		this.desconto = desconto;
		this.total = total;
		this.idPagamento = idPagamento;
		this.idStatus = idStatus;
	}
		
	//getters and setters
	
	public float getSubtotal() {
		return subtotal;
	}
	
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public float getDesconto() {
		return desconto;
	}
	
	
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	
	public float getTotal() {
		return total;
	}
	
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	//Create
	public void putPagamentos(int idPagamento, String pagamento) {
		mapaPagamentos.put(idPagamento, pagamento);
		System.out.println(String.format("Id '%d', Pagamento '%s' adicionado com sucesso!", idPagamento, mapaPagamentos.get(idPagamento)));
	}
	public void putStatus(int idStatus, String status) {
		mapaStatus.put(idStatus, status);
		System.out.println(String.format("Id '%d', Status '%s' adicionado com sucesso!", idStatus, mapaPagamentos.get(idStatus)));
	}
	//Delete
	public void removePagamentos(int idPagamento) {
		if (mapaPagamentos.containsKey(idPagamento)){
			mapaPagamentos.remove(idPagamento);
		} else { 
			System.out.println("ERRO! idPagamento não existe!");
		}
	}
	
	public void removeStatus(int idStatus) {
		if (mapaStatus.containsKey(idStatus)){
			mapaStatus.remove(idStatus);
		} else { 
			System.out.println("ERRO! idStatus não existe!");
		}
	}
	//Read
	public void getPagamento (int idPagamento) {
		if (mapaPagamentos.containsKey(idPagamento)){
			System.out.println(mapaPagamentos.get(idPagamento));
		} else { 
			System.out.println("ERRO! idPagamento não existe!");
		}
	}
	
	public void getStatus (int idStatus) {
		if (mapaPagamentos.containsKey(idStatus)){
			System.out.println(mapaPagamentos.get(idStatus));
		} else { 
			System.out.println("ERRO! idStatus não existe!");
		}
	}
	//Update
	public void modifyPagamentos(int idPagamento, String pagamento) {
		mapaPagamentos.put(idPagamento, pagamento);
	}
	
	public void modifyStatus(int idStatus, String status) {
		mapaStatus.put(idStatus, status);
	}
	
	public void getListaProdutos(Produto produto) {
		for (Produto produto : listaProdutos) {
			System.out.println(produto.toString());
		}
	}
	

	
	
}
