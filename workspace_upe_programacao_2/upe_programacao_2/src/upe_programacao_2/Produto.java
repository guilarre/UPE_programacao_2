package upe_programacao_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Produto {
	private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private static AtomicInteger count = new AtomicInteger(0);
	private int idProduto;
	private String sku;
	private String nomeProduto;
	private String descricao;
	private double valor;
	private int idCategoria;
	private static HashMap<Integer, String> mapaCategorias;
	private int qtdEstoque;
	
	public Produto(String sku, String nomeProduto, String descricao, double valor, int idCategoria, int qtdEstoque) {
		idProduto = count.incrementAndGet();
		this.sku = sku;
		this.nomeProduto= nomeProduto;
		this.descricao = descricao;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.qtdEstoque = qtdEstoque;
		listaProdutos.add(this);
	}

// Getters/setters
	public int getIdProduto() {
		return idProduto;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public static Produto getProdutoById(int idProduto) {
		for (Produto produto : Produto.getListaProdutos()) {
			if (produto.getIdProduto() == idProduto) {
				return produto;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe produto de id '%d'", idProduto));
	}
	public static Produto getProdutoByNome(String nomeProduto) {
		for (Produto produto : Produto.getListaProdutos()) {
			if (produto.getNomeProduto() == nomeProduto) {
				return produto;
			}
		}
		// TEST: esse throw new quebra funcionamento da main?
		throw new IllegalArgumentException(String.format("ERRO! Não existe produto com o nome '%s'", nomeProduto));
	}
	public static void removeProduto(Produto produto) {
		// Confirmar operação
		Scanner sc = new Scanner(System.in);
		System.out.println(String.format("""
Você tem certeza que deseja remover o produto a seguir?

Produto:
%s

Se sim, digite 's', se não digite 'n' (CUIDADO: Essa operação não pode ser revertida):""", produto));
		char confirmacao = sc.next().charAt(0);
		sc.close();
		if (Character.toLowerCase(confirmacao) == 's') {
			listaProdutos.remove(produto.getIdProduto());
			System.out.println("Produto foi removido com sucesso!");
		} else {
			System.out.println("Operação cancelada!");
		}
	}
	
	// listaProdutos
	public static ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public static void addToListaProdutos(Produto produto) {
		listaProdutos.add(produto);
		count = new AtomicInteger(listaProdutos.size());
	}
	
	// CRUD para mapaCategorias
	public static void putCategoria(int idCategoria, String categoria) {
		mapaCategorias.put(idCategoria, categoria);
		System.out.println(String.format("Id '%d', Categoria '%s' adicionado com sucesso!", idCategoria, mapaCategorias.get(idCategoria)));
	}
	public static String getMapaCategorias() {
		for (int i : mapaCategorias.keySet()) {
			return String.format("Id '%d', Categoria '%s'", i, mapaCategorias.get(i)); 
		}
		return "ERRO! Ainda não existem categorias registradas.";
	}
	public static String getCategoriaById(int idCategoria) {
		if (mapaCategorias.containsKey(idCategoria)) {
			return String.format("Id '%d', categoria '%s'", idCategoria, mapaCategorias.get(idCategoria));
		} else {
			throw new IllegalArgumentException(String.format("ERRO! Id '%d' não existe!", idCategoria));
		}
	}
	public static void modifyCategoria(int idCategoria, String categoria) {
		if (mapaCategorias.containsKey(idCategoria)){
			mapaCategorias.put(idCategoria, categoria);
			System.out.println(String.format("Id '%d' modificado para Categoria: '%s' com sucesso!", idCategoria, categoria));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}	
	}
		public static void removeCategoria(int idCategoria) {
			if (mapaCategorias.containsKey(idCategoria)){
				mapaCategorias.remove(idCategoria);
				System.out.println(String.format("Id '%d', Categoria '%s' removido com sucesso!", idCategoria, mapaCategorias.get(idCategoria)));
			} else { 
				System.out.println(String.format("ERRO! Id '%d' não existe!", idCategoria));
			}
		}

	// toString()
	@Override
	public String toString() {
		return String.format("""

Id do produto: '%d'

SKU: %d
Nome: %s
Descrição: %s
Valor: R$ %.2f
Id da categoria: '%d'
Quantidade em estoque: %d.

""", this.getIdProduto(), this.getSku(), this.getNomeProduto(), this.getDescricao(), this.getValor(), Produto.getCategoriaById(this.getIdCategoria()), getQtdEstoque());
	}
}