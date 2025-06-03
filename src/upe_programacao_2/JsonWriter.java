package upe_programacao_2;
import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
<<<<<<< HEAD
//import java.util.ArrayList;
=======
import java.util.ArrayList;
>>>>>>> 8dddbc59b25a8b2a1a9b945ce749e0ce176dbf5f

public class JsonWriter {
	// Criando objeto Gson com as opções abaixo
	private static Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.serializeNulls()
			.create();
	
<<<<<<< HEAD
	// Método geral para salvar no .json
	public static void salvarEmArquivo(Object lista, String caminhoArquivo) {
		try (FileWriter fw = new FileWriter(caminhoArquivo)) {
			gson.toJson(lista, fw);
=======
	public static void salvarEmArquivo(ArrayList<Object> lista, String caminhoArquivo) {
		try {
			FileWriter fw = new FileWriter(caminhoArquivo, true);
			gson.toJson(lista, fw);
			fw.close();
>>>>>>> 8dddbc59b25a8b2a1a9b945ce749e0ce176dbf5f
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
<<<<<<< HEAD
	// Métodos específicos (chamados pelo main)
	public static void salvarClientes(Object listaClientes) {
		String caminhoArquivo = "clientes.json";
		JsonWriter.salvarEmArquivo(listaClientes, caminhoArquivo);
	}
	
	public static void salvarFuncionarios(Object listaFuncionarios) {
		String caminhoArquivo = "funcionarios.json";
		JsonWriter.salvarEmArquivo(listaFuncionarios, caminhoArquivo);
	}
	
	// Dando erro pq ainda não integrou o estoque
//	public static void salvarEstoque(Object estoque) {
//		String caminhoArquivo = "estoque.json";
//		JsonWriter.salvarEmArquivo(estoque, caminhoArquivo);
=======
	// NÃO MAIS USADOS:
	
	// Métodos para escrever nos arquivos específicos
//	public static void salvarEmEstoque(Produto produto) {
//		String filepath = "estoque.json";
//		JsonWriter.salvarEmArquivo(produto, filepath);
>>>>>>> 8dddbc59b25a8b2a1a9b945ce749e0ce176dbf5f
//	}
//	
//	public static void salvarHistorico(Object historico) {
//		String caminhoArquivo = "historico.json";
//		JsonWriter.salvarEmArquivo(historico, caminhoArquivo);
//	}
<<<<<<< HEAD
}
=======
	
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
>>>>>>> 8dddbc59b25a8b2a1a9b945ce749e0ce176dbf5f
