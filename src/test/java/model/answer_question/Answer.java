package model.answer_question;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Data
public class Answer {
	public Answer(){
		this._id=new ObjectId().toString();
		this.createdAt=new Date();
		this.updatedAt=new Date();
		this.vote=0;
	}
	@Id
	@JsonProperty(value = "_id", access = JsonProperty.Access.READ_ONLY)
	private String _id;

	@CreatedDate
	@JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
	private Date createdAt;

	@JsonProperty("answer")
	@Field("answer")
	private String answer;

	@JsonProperty("expert_id")
	@Field("expert_id")
	private String expertId;

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