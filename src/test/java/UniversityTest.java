import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


public class UniversityTest extends APITestClass{

    @Test
    public void getUniversity(){
        String link = "/api/universities";
        WebTarget requestTarget = client.target(BaseURL + link);
        ArrayList<Object> universities = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<ArrayList<Object>>() {
        });
        Assert.assertTrue(universities.size() > 15);

        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(actualResponseCode,expectedResponseCode);
    }

    @Test
    public void createUniversity(){
        String link = "/api/universities";
        String json = "{\n" +
                "  \"country\": \"Viet Nam\",\n" +
                "  \"website\": \"https://www.neu.edu.vn/\",\n" +
                "  \"types\": [\n" +
                "    \"abc\"\n" +
                "  ],\n" +
                "  \"last_updated\": \"abc\",\n" +
                "  \"ranks\": {\n" +
                "    \"the\": 1,\n" +
                "    \"qs\": 0,\n" +
                "    \"arwu\": 0\n" +
                "  },\n" +
                "  \"names\": {\n" +
                "    \"vi\": \"Dai hoc Kinh te Quoc dan\",\n" +
                "    \"en\": \"National Economics University\"\n" +
                "  },\n" +
                "  \"synonyms\": {\n" +
                "    \"de\": [\n" +
                "      {}\n" +
                "    ],\n" +
                "    \"vi\": [\n" +
                "      {}\n" +
                "    ],\n" +
                "    \"en\": [\n" +
                "      \"abc\"\n" +
                "    ],\n" +
                "    \"fr\": [\n" +
                "      {}\n" +
                "    ]\n" +
                "  },\n" +
                "  \"name\": \"NEU\",\n" +
                "  \"id\": \"test01\",\n" +
                "  \"source\": \"https://www.neu.edu.vn/\"\n" +
                "}";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }

    @Test
    public void searchUniversity(){
        String link = "/api/universities/search";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("name","Massachusetts");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);

    }

    @Test
    public void updateUniversity(){
        String link = "/api/universities";
        String json = "{\n" +
                "  \"country\": \"Viet Nam\",\n" +
                "  \"website\": \"https://www.neu.edu.vn/\",\n" +
                "  \"types\": [\n" +
                "    \"abc\"\n" +
                "  ],\n" +
                "  \"last_updated\": \"abc\",\n" +
                "  \"ranks\": {\n" +
                "    \"the\": 1,\n" +
                "    \"qs\": 0,\n" +
                "    \"arwu\": 0\n" +
                "  },\n" +
                "  \"names\": {\n" +
                "    \"vi\": \"Dai hoc Kinh te Quoc dan\",\n" +
                "    \"en\": \"National Economics University\"\n" +
                "  },\n" +
                "  \"synonyms\": {\n" +
                "    \"de\": [\n" +
                "      {}\n" +
                "    ],\n" +
                "    \"vi\": [\n" +
                "      {}\n" +
                "    ],\n" +
                "    \"en\": [\n" +
                "      \"abc\"\n" +
                "    ],\n" +
                "    \"fr\": [\n" +
                "      {}\n" +
                "    ]\n" +
                "  },\n" +
                "  \"name\": \"NEU\",\n" +
                "  \"id\": \"test01\",\n" +
                "  \"source\": \"https://www.neu.edu.vn/\"\n" +
                "}";
        WebTarget requestTarget = client.target(BaseURL + link).path("61e68a9cde266dfc4b84b012");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }

    @Test
    public void deleteUniversity(){
        String link = "/api/universities";
        WebTarget requestTarget = client.target(BaseURL + link).path("61e68a9cde266dfc4b84b00f");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }

    @Test
    public void findUniversityById(){
        String link = "/api/universities";
        WebTarget requestTarget = client.target(BaseURL + link)
                .path("61e68a9cde266dfc4b84b011");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
        Assert.assertTrue(response.readEntity(String.class).length()>0);
    }
}
