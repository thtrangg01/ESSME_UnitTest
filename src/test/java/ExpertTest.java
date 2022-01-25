import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExpertTest extends APITestClass{
    @Test
    public void getWithLimit(){
        String link = "/api/experts";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("limit",30);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void searchExperts(){
        String link = "/api/experts/search";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("what","CNTT");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void getExperts(){
        String link = "/api/experts/page";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("page","1")
                .queryParam("size","3")
                .queryParam("desc","true");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void findById(){
        String link = "/api/experts";
        WebTarget requestTarget = client.target(BaseURL + link)
                .path("61db03af640545e22cadfbef");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void getNumberOfExpertsInEachField(){
        String link = "/api/experts/field";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void updateNoToken(){
        String link = "/api/experts";
        String json = "{\n" +
                "        \"score\": 8.0,\n" +
                "        \"image\": null,\n" +
                "        \"other_link\": \"\",\n" +
                "        \"address\": \"\",\n" +
                "        \"gender\": 0,\n" +
                "        \"degree\": \"PGS.TS\",\n" +
                "        \"birth\": \"\",\n" +
                "        \"phone\": \"\",\n" +
                "        \"name\": \"Phan Xuân Hiếu\",\n" +
                "        \"research_area\": \"CNTT\",\n" +
                "        \"company\": \"ĐH Công nghệ\",\n" +
                "        \"location\": {\n" +
                "            \"features\": [\n" +
                "                {\n" +
                "                    \"geometry\": {\n" +
                "                        \"coordinates\": [\n" +
                "                            105.78328728675842,\n" +
                "                            21.03772343859052\n" +
                "                        ],\n" +
                "                        \"type\": \"Point\"\n" +
                "                    },\n" +
                "                    \"type\": \"Feature\",\n" +
                "                    \"properties\": {\n" +
                "                        \"street\": null\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"type\": \"FeatureCollection\"\n" +
                "        },\n" +
                "        \"email\": \"Hieupx@vnu.edu.vn\",\n" +
                "        \"link_profile\": \"http://uet.vnu.edu.vn/~hieupx\",\n" +
                "        \"uid\": null\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link).path("61db03af640545e22cadfbee");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void createUserNoToken(){
        String link = "/api/experts";
        String json = "{\n" +
                "        \"score\": 8.0,\n" +
                "        \"image\": null,\n" +
                "        \"other_link\": \"\",\n" +
                "        \"address\": \"\",\n" +
                "        \"gender\": 0,\n" +
                "        \"degree\": \"PGS.TS\",\n" +
                "        \"birth\": \"\",\n" +
                "        \"phone\": \"\",\n" +
                "        \"name\": \"Phan Xuân Hiếu\",\n" +
                "        \"research_area\": \"CNTT\",\n" +
                "        \"company\": \"ĐH Công nghệ\",\n" +
                "        \"location\": {\n" +
                "            \"features\": [\n" +
                "                {\n" +
                "                    \"geometry\": {\n" +
                "                        \"coordinates\": [\n" +
                "                            105.78328728675842,\n" +
                "                            21.03772343859052\n" +
                "                        ],\n" +
                "                        \"type\": \"Point\"\n" +
                "                    },\n" +
                "                    \"type\": \"Feature\",\n" +
                "                    \"properties\": {\n" +
                "                        \"street\": null\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"type\": \"FeatureCollection\"\n" +
                "        },\n" +
                "        \"email\": \"Hieupx@vnu.edu.vn\",\n" +
                "        \"link_profile\": \"http://uet.vnu.edu.vn/~hieupx\",\n" +
                "        \"uid\": null\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void deleteNoToken(){
        String link = "/api/experts";
        WebTarget requestTarget = client.target(BaseURL + link).path("61db03af640545e22cadfbee");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
