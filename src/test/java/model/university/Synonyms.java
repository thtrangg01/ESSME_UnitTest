package model.university;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public @Data
class Synonyms{

	@JsonProperty("de")
	private List<Object> de;

	@JsonProperty("vi")
	private List<Object> vi;

	@JsonProperty("en")
	private List<String> en;

	@JsonProperty("fr")
	private List<Object> fr;
}