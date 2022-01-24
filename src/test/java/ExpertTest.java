import org.junit.Assert;
import org.junit.Test;

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

}
