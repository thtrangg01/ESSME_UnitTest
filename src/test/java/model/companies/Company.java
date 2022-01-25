package model.companies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("companies")
public class Company {
    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("website")
    private String website;

    @Field("last_updated")
    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("ranks")
    private Ranks ranks;

    @JsonProperty("names")
    private Names names;

    @JsonProperty("synonyms")
    private Synonyms synonyms;

    @JsonProperty("industries")
    private List<String> industries;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;
}