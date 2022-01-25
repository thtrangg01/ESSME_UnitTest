package model.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Names{

	@JsonProperty("vi")

	private String vi;

	@JsonProperty("en")

	private String en;
}