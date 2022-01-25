package model.request_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document("request_response")
public class Request {
    @Id
    @JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
    private String _id;

    @CreatedDate
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @LastModifiedDate
    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    @JsonProperty("topic")
    @Field("topic")
    private List<String> topic;

    @JsonProperty("Title")
    @Field("Title")
    private String title;

    @JsonProperty("content")
    @Field("content")

    private String content;

    @JsonProperty("response")
    private List<Response> responses;

    @JsonProperty("customer_id")
    @Field("customer_id")

    private String customerId;

    @JsonProperty("uid")
    @Field("uid")
    private String uid;
}
