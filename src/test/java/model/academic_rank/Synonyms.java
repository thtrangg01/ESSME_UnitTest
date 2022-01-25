package model.academic_rank;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Synonyms {

    @JsonProperty("vi")
    private List<String> vi;

    @JsonProperty("en")
    private List<String> en;
}