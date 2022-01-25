import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class QuestionAnswerTest extends  APITestClass{

    @Test
    public void getQuestion(){
        String link = "/api/questions";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(actualResponseCode,expectedResponseCode);
    }
}
