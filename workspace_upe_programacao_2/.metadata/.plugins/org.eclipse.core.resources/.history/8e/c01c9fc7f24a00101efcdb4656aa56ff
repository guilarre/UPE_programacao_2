package upe_programacao_2;
import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
//import java.util.ArrayList;

public class JsonWriter {
	// Criando objeto Gson com as opções abaixo
	private static Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.serializeNulls()
			.create();
	
	// Método geral para salvar no .json
	public static void salvarEmArquivo(Object lista, String caminhoArquivo) {
		try (FileWriter fw = new FileWriter(caminhoArquivo)) {
			gson.toJson(lista, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Métodos específicos (chamados pelo main)
	public static void salvarClientes(Object listaClientes) {
		String caminhoArquivo = "clientes.json";
		JsonWriter.salvarEmArquivo(listaClientes, caminhoArquivo);
	}
	
	public static void salvarFuncionarios(Object listaFuncionarios) {
		String caminhoArquivo = "funcionarios.json";
		JsonWriter.salvarEmArquivo(listaFuncionarios, caminhoArquivo);
	}
	
	public static void salvarEstoque(Object estoque) {
		String caminhoArquivo = "estoque.json";
		JsonWriter.salvarEmArquivo(estoque, caminhoArquivo);
	}

	public static void salvarHistorico(Object historico) {
		String caminhoArquivo = "historico.json";
		JsonWriter.salvarEmArquivo(historico, caminhoArquivo);
	}
}