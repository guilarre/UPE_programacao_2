package upe_programacao_2;

import java.lang.reflect.Type;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//TypeAdapter p/ LocalDate (requerimento do Gson)
	public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
		private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		@Override
		public JsonElement serialize(final LocalDate date, final Type typeOfSrc, final JsonSerializationContext context) {
			return new JsonPrimitive(date.format(formatter));
		  }

		@Override
		public LocalDate deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
			return LocalDate.parse(json.getAsString(), formatter);
		}
	}
		
	// TypeAdapter p/ LocalDateTime (requerimento do Gson)
//	public class LocalDateTimeTypeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
//
//		private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");
//
//		@Override
//		public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
//			return new JsonPrimitive(formatter.format(localDateTime));
//		}
//
//		@Override
//		public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//			return LocalDateTime.parse(json.getAsString(), formatter);
//		}
//	}