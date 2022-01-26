import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class NewTest extends APITestClass {
    @Test
    public void getNew(){
        String link = "/api/news";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("limit","abc");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
        Assert.assertTrue(response.readEntity(String.class).length()>0);
    }

    @Test
    public void createNew(){

    }

    @Test
    public void searchNew(){
        String link = "/api/news/search";
        WebTarget requestTarget = client.target(BaseURL + link);
        String json = "{\"what\":\"thu+nhap\"}";
//        ArrayList<Object> news = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).post();
//        Assert.assertTrue(news.size() > 15);

        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(actualResponseCode,expectedResponseCode);
    }

    @Test
    public void deleteNew(){

    }

    @Test
    public void updateNew(){

    }

    @Test
    public void getNewById(){

    }


}
