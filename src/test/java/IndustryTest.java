import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class IndustryTest extends APITestClass{
    @Test
    public void searchIndustries() throws IOException {
        String link = "/api/industries/search";
//        String params = "?name=Advertising";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("name","Advertising");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
//        ArrayList<Object> industries =
//        requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<ArrayList<Object>>(){});
//        System.out.println(response.readEntity(new GenericType<ArrayList<Object>>(){}));
//        Assert.assertTrue(industries.size() > 0);
    }
    @Test
    public void getIndustries(){
        String link = "/api/industries";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("page","1")
                .queryParam("size","4")
                .queryParam("sortBy","name")
                .queryParam("asc","false");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void createIndustry() throws JsonProcessingException {
        String link = "/api/industries";
        String json = "{\n" +
                "        \"types\": [\n" +
                "            \"gics\",\n" +
                "            \"sub_industry\"\n" +
                "        ],\n" +
                "        \"names\": {\n" +
                "            \"vi\": \"quảng cáo\",\n" +
                "            \"en\": \"Advertising\"\n" +
                "        },\n" +
                "        \"level\": 3,\n" +
                "        \"parent_id\": \"Media\",\n" +
                "        \"synonyms\": {\n" +
                "            \"vi\": [],\n" +
                "            \"en\": []\n" +
                "        },\n" +
                "        \"name\": \"Advertising\",\n" +
                "        \"source_parent_id\": \"502010\",\n" +
                "        \"id\": \"advertising\",\n" +
                "        \"source_id\": \"50201010\",\n" +
                "        \"source\": \"wikipedia\",\n" +
                "        \"source_url\": \"https://en.wikipedia.org/wiki/Global_Industry_Classification_Standard\"\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
