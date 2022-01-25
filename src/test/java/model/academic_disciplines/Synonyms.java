package model.academic_disciplines;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Synonyms {

    @JsonProperty("vi")
    private List<Object> vi;

    @JsonProperty("en")
    private List<Object> en;
}