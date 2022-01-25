package model.companies_vn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "companies_vn")
@Data
public class CompanyVn{
	@Id
	@JsonProperty("_id")
	private String _id;

	@Field(name = "name_company")
	@JsonProperty("name_company")

	private String nameCompany;

	@Field(name = "tax_code")
	@JsonProperty("tax_code")

	private String taxCode;

	@JsonProperty("website")
	private String website;

	@Field(name = "founded_year")
	@JsonProperty("founded_year")
	private String foundedYear;

	@JsonProperty("location")

	private String location;

	@JsonProperty("tel")

	private String tel;

	@Field(name = "tax")
	@JsonProperty("fax")

	private String fax;

	@JsonProperty("email")

	private String email;

	@JsonProperty("desc")
	private String desc;
}