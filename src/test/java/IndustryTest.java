import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
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
}
