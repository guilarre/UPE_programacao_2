package upe_programacao_2;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.*;

public class JsonReader {
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.create();
	
	// Métodos para carregar objetos em memória
	public static void carregarClientes() {
		try (FileReader fr = new FileReader("clientes.json")) {
			Cliente[] clientes = gson.fromJson(fr, Cliente[].class);
			for (Cliente cliente : clientes) {
				Cliente.addListaClientes(cliente);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void carregarFuncionarios() {
		try (FileReader fr = new FileReader("funcionarios.json")) {
			Funcionario[] funcionarios = gson.fromJson(fr, Funcionario[].class);
			for (Funcionario funcionario : funcionarios) {
				Funcionario.addListaFuncionarios(funcionario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void carregarHistorico() {
		try (FileReader fr = new FileReader("historico.json")) {
			Compra[] historico = gson.fromJson(fr, Compra[].class);
			for (Compra compra : historico) {
				Historico.addToHistorico(compra);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TO DO: Lógica para carregar estoque
//	public static void carregarClientes() {
//		try (FileReader fr = new FileReader("clientes.json")) {
//			Cliente[] clientes = gson.fromJson(fr, Cliente[].class);
//			for (Cliente cliente : clientes) {
//				Cliente.addListaClientes(cliente);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
