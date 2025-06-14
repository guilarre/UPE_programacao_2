package upe_programacao_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Estoque {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	//Criar
    public static void salvarProdutos(String caminhoArquivo, List<Produto> produtos) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gson.toJson(produtos, writer);
            System.out.println("Estoque salvo com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    //Ler
    public static List<Produto> carregarProdutos(String caminhoArquivo) {
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            Produto[] produtosArray = gson.fromJson(reader, Produto[].class);
            return Arrays.asList(produtosArray);
        } catch (IOException e) {
            System.err.println("Erro ao carregar estoque: " + e.getMessage());
            return null;
        }
    }
	    
	 //Atualizar
    public static void atualizarProduto(String caminho, String nomeAlvo, Produto novoProduto) {
        List<Produto> produtos = carregarProdutos(caminho);
        boolean encontrado = false;

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNomeProduto().equalsIgnoreCase(nomeAlvo)) {
                produtos.set(i, novoProduto);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            salvarProdutos(caminho, produtos);
            System.out.println("Produto atualizado.");
        } else {
            System.err.println("Produto não encontrado.");
        }
    }

    //Deletar
    public static void deletarProduto(String caminho, String nomeAlvo) {
        List<Produto> produtos = carregarProdutos(caminho);
        boolean removido = produtos.removeIf(p -> p.getNomeProduto().equalsIgnoreCase(nomeAlvo));

        if (removido) {
            salvarProdutos(caminho, produtos);
            System.out.println("Produto removido.");
        } else {
            System.err.println("Produto não encontrado.");
        }
    }
}
