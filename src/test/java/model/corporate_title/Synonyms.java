package model.corporate_title;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Synonyms {

    @JsonProperty("vi")
    private List<String> vi;

    @JsonProperty("en")
    private List<String> en;
}