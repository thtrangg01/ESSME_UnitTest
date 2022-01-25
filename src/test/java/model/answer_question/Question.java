package model.answer_question;

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
@Document("answer_question")
public class Question {
	public Question(){
		this.vote=0;
	}

	@CreatedDate
	@JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
	private Date createdAt;

	@JsonProperty("Description")
	@Field("Description")

	private String description;

	@JsonProperty("Customer_id")
	@Field("Customer_id")

	private String customerId;

	@JsonProperty("Admin_id")
	@Field("Admin_id")

	private String adminId;

	@JsonProperty("answers")
	private List<Answer> answers;

	@JsonProperty("Title")
	@Field("Title")

	private String title;

	@Id
	@JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
	private String _id;

	@JsonProperty("Topic")
	@Field("Topic")
	private List<String> topic;

	@JsonProperty("vote")
	@Field("vote")
	private int vote;

	@LastModifiedDate
	@JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
	private Date updatedAt;

	@JsonProperty("uid")
	@Field("uid")
	private String uid;
}