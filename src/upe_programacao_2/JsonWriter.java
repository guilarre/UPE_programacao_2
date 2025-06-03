package upe_programacao_2;
import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class JsonWriter {
	// Criando objeto Gson com as opções abaixo
	private static Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.serializeNulls()
			.create();
	
	public static void salvarEmArquivo(ArrayList<Object> lista, String caminhoArquivo) {
		try {
			FileWriter fw = new FileWriter(caminhoArquivo, true);
			gson.toJson(lista, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// NÃO MAIS USADOS:
	
	// Métodos para escrever nos arquivos específicos
//	public static void salvarEmEstoque(Produto produto) {
//		String filepath = "estoque.json";
//		JsonWriter.salvarEmArquivo(produto, filepath);
//	}
//	
//	public static void salvarEmHistorico(Compra compra) {
//		String filepath = "historico.json";
//		JsonWriter.salvarEmArquivo(compra, filepath);
//	}
	
//	public static void salvarCliente(Object cliente) {
//		String filepath = "clientes.json";
//		JsonWriter.salvarEmArquivo(listaClientes, filepath);
//	}
//	
//	public static void salvarFuncionario(Funcionario funcionario) {
//		String filepath = "funcionarios.json";
//		JsonWriter.salvarEmArquivo(funcionario, filepath);
//	}
}
