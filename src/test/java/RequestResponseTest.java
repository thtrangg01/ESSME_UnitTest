import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class RequestResponseTest extends APITest{

    @Test
    public void getRequest(){
        String link = "/api/requests";
        WebTarget requestTarget = client.target(BaseURL + link);
        ArrayList<Object> requests = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<ArrayList<Object>>() {
        });
        Assert.assertTrue(requests.size() > 15);

        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(actualResponseCode,expectedResponseCode);

    }
}
