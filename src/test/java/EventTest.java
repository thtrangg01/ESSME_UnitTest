import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EventTest extends APITestClass{
    @Test
    public void searchEvents(){
//        String link = "/api/events/search";
////        WebTarget requestTarget = client.target(BaseURL + link).queryParam("what","");
////        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
////        int actualResponseCode = response.getStatus();
////        int expectedResponseCode = 200;
////        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void getEvents(){
        String link = "/api/events";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("page",1).queryParam("size",4);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void getEvent(){
        String link = "/api/events";
        WebTarget requestTarget = client.target(BaseURL + link)
                .path("61cd14c7fbd70f912e5c0198");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
