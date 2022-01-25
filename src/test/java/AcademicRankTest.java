import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AcademicRankTest extends APITestClass{
    @Test
    public void getAcademicRank(){
        String link = "/api/academic-rank";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("_id", "61965f211440add5d12283fe");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void getAcademicRanks(){
        String link = "/api/academic-rank";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("page", 1)
                .queryParam("size", 20)
                .queryParam("asc", "true");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void searchAcademicRanks(){
        String link = "/api/academic-rank/search";
        WebTarget requestTarget = client.target(BaseURL + link)
                .queryParam("text", "giáo sư");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
