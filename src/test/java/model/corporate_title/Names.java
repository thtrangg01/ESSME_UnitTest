package model.corporate_title;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Names {

    @JsonProperty("vi")

    private String vi;

    @JsonProperty("en")

    private String en;

    @JsonProperty("fr")
    private String fr;
}