package upe_programação_2;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Produto {

	public static final AtomicInteger count = new AtomicInteger(0);
	public int idProduto;
	public String sku;
	public String nome;
	public String descricao;
	public float valor;
	public int idCategoria;
	public static HashMap<Integer, String> mapaCategorias;
	public int qtdEstoque;
	
	
	public Produto(int idProduto, String sku, String nome, String descricao, float valor, int idCategoria, int qtdEstoque) {
		this.idProduto = count.incrementAndGet();
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.qtdEstoque = qtdEstoque;
	}

//getters and setters
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}


	public int getQtdEstoque() {
		return qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	//Create
	public void putCategoria (int idCategoria, String categoria) {
		mapaCategorias.put(idCategoria, categoria);
		System.out.println(String.format("Id '%d', Categoria '%s' adicionado com sucesso!", idCategoria, mapaCategorias.get(idCategoria)));
	}
	
	//Read
	public void getCategoria (int idCategoria) {
		if (mapaCategorias.containsKey(idCategoria)){
			System.out.println(mapaCategorias.get(idCategoria));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}
	}
	
	//Update
	public void modifCategorias(int idCategoria, String categoria) {
		if (mapaCategorias.containsKey(idCategoria)){
			mapaCategorias.put(idCategoria, categoria);
			System.out.println(String.format("Id '%d' modificado para Categoria: '%s' com sucesso!", idCategoria, categoria));
		} else { 
			System.out.println("ERRO! Id '%d' não existe!");
		}	
	}
	
	//Delete
			public void removePagamentos(int idCategoria) {
				if (mapaCategorias.containsKey(idCategoria)){
					mapaCategorias.remove(idCategoria);
					System.out.println(String.format("Id '%d', Categoria '%s' removido com sucesso!", idCategoria, mapaCategorias.get(idCategoria)));
				} else { 
					System.out.println("ERRO! Id '%d' não existe!");
				}
			}

}
