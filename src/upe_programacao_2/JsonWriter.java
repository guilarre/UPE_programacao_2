package upe_programacao_2;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;


public static class JsonWriter {
	private static Gson gson = new Gson();
			public static void salvarEmArquivo(Object objeto, String caminhoArquivo) {
				private static FileWriter writer = new FileWriter();
		String json = gson.toJson(objeto);
		
	}
}
