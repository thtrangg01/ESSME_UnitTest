package model.companies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Synonyms {

    @JsonProperty("de")
    private List<String> de;

    @JsonProperty("vi")
    private List<Object> vi;

    @JsonProperty("en")
    private List<String> en;

    @JsonProperty("fr")
    private List<Object> fr;
}