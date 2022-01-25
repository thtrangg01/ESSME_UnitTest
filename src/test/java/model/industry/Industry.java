package model.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Industry{

	@Id
	@JsonProperty(value= "_id", access = JsonProperty.Access.READ_ONLY)
	private String _id;

	@JsonProperty("types")
	private List<String> types;

	@JsonProperty("names")

	private Names names;

	@JsonProperty("level")
	private int level;

	@Field("parent_id")
	@JsonProperty("parent_id")
	private String parentId;

	@JsonProperty("synonyms")
	private Synonyms synonyms;

	@JsonProperty("name")

	private String name;

	@Field("source_parent_id")
	@JsonProperty("source_parent_id")
	private String sourceParentId;

	@JsonProperty("id")

	private String id;

	@Field("source_id")
	@JsonProperty("source_id")
	private String sourceId;

	@JsonProperty("source")
	private String source;

	@Field("source_url")
	@JsonProperty("source_url")
	private String sourceUrl;
}