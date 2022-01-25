package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Event {

    @Id
    @JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
    private String id;

    @JsonProperty("img")
    private String img;

    @JsonProperty("web")
    private String web;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("location")
    private String location;

    @JsonProperty("time")
    private String time;

    @JsonProperty("type")
    private String type;

    @JsonProperty("desc")
    private String desc;
}