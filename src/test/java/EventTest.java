import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EventTest extends APITestClass{
    @Test
    public void searchEvents(){
        String link = "/api/events/search";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("what","ai");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
        System.out.println(response.readEntity(String.class));
        String res = response.readEntity(String.class);
        Assert.assertTrue(res.substring(res.indexOf("content")+10,res.indexOf("]")).length()>0);
    }
    @Test
    public void getEvents(){
        String link = "/api/events";
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("page",1).queryParam("size",4);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
        Assert.assertTrue(response.readEntity(String.class).length()>0);
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
        Assert.assertTrue(response.readEntity(String.class).length()>0);
    }
    @Test
    public void createEventNoToken(){
        String link = "/api/events";
        String json = "{\n" +
                "        \"geojson\": {\n" +
                "            \"type\": \"Feature\",\n" +
                "            \"geometry\": {\n" +
                "                \"type\": \"Point\",\n" +
                "                \"coordinates\": [\n" +
                "                    106.70106665840808,\n" +
                "                    10.77558105\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        \"img\": \"https://vietsearch.sfo2.digitaloceanspaces.com/images/c95e39d0ff711555397be0228d3fa9c.jpg\",\n" +
                "        \"web\": \"https://www.facebook.com/events/334873751469539\",\n" +
                "        \"name_event\": \"Ng??y h???i du h???c ??c - AUSSIE STUDY DAY\",\n" +
                "        \"location\": \"141 Nguy????n Hu????, B???n Ngh??, Qu???n 1, Th??nh ph??? H??? Ch?? Minh 700000, Vietnam\",\n" +
                "        \"time\": \"Ch??? Nh???t, ng??y 16 th??ng 01 n??m 2022L??c14:00 - 19:00\\n\",\n" +
                "        \"type\": [\n" +
                "            \"H???i thanh ni??n, sinh vi??n\"\n" +
                "        ],\n" +
                "        \"desc\": \"V???i mong mu???n ????a ?????n cho c??c b???n h???c sinh, sinh vi??n Vi???t Nam c??i nh??n to??n c???nh v??? cu???c s???ng du h???c c??ng nh?? l??? tr??nh ph??t tri???n con ???????ng h???p t???p t???i ??c, \uD835\uDC07\uD835\uDC28????\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1E??\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1E????\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC2D\uD835\uDC1A??\uD835\uDC22 \uD835\uDC14??\uD835\uDC1C (\uD835\uDC12\uD835\uDC15\uD835\uDC00\uD835\uDC14) ph???i h???p v???i \uD835\uDC07\uD835\uDC28????\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1E??\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1E????\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC13\uD835\uDC21\uD835\uDC1A??\uD835\uDC27\uD835\uDC21 \uD835\uDC29\uD835\uDC21\uD835\uDC28???? \uD835\uDC07\uD835\uDC28???? \uD835\uDC02\uD835\uDC21\uD835\uDC22?? \uD835\uDC0C\uD835\uDC22\uD835\uDC27\uD835\uDC21 ch??nh th???c t??? ch???c \uD835\uDC0D\uD835\uDC20\uD835\uDC1A??\uD835\uDC32 \uD835\uDC21\uD835\uDC28????\uD835\uDC22 \uD835\uDC03\uD835\uDC2E \uD835\uDC21\uD835\uDC28??\uD835\uDC1C \uD835\uDC14??\uD835\uDC1C, S??? ki???n ???????c t??? ch???c \uD835\uDC26\uD835\uDC22\uD835\uDC1E????\uD835\uDC27 \uD835\uDC29\uD835\uDC21\uD835\uDC22?? theo c??? hai h??nh th???c tham gia tr???c ti???p v?? tr???c tuy???n.\"\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link);
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void deleteNoToken(){
        String link = "/api/events";
        WebTarget requestTarget = client.target(BaseURL + link).path("61cd14c7fbd70f912e5c0198");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
    @Test
    public void updateNoToken(){
        String link = "/api/events";
        String json = "{\n" +
                "        \"geojson\": {\n" +
                "            \"type\": \"Feature\",\n" +
                "            \"geometry\": {\n" +
                "                \"type\": \"Point\",\n" +
                "                \"coordinates\": [\n" +
                "                    106.70106665840808,\n" +
                "                    10.77558105\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        \"img\": \"https://vietsearch.sfo2.digitaloceanspaces.com/images/c95e39d0ff711555397be0228d3fa9c.jpg\",\n" +
                "        \"web\": \"https://www.facebook.com/events/334873751469539\",\n" +
                "        \"name_event\": \"Ng??y h???i du h???c ??c - AUSSIE STUDY DAY\",\n" +
                "        \"location\": \"141 Nguy????n Hu????, B???n Ngh??, Qu???n 1, Th??nh ph??? H??? Ch?? Minh 700000, Vietnam\",\n" +
                "        \"time\": \"Ch??? Nh???t, ng??y 16 th??ng 01 n??m 2022L??c14:00 - 19:00\\n\",\n" +
                "        \"type\": [\n" +
                "            \"H???i thanh ni??n, sinh vi??n\"\n" +
                "        ],\n" +
                "        \"desc\": \"V???i mong mu???n ????a ?????n cho c??c b???n h???c sinh, sinh vi??n Vi???t Nam c??i nh??n to??n c???nh v??? cu???c s???ng du h???c c??ng nh?? l??? tr??nh ph??t tri???n con ???????ng h???p t???p t???i ??c, \uD835\uDC07\uD835\uDC28????\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1E??\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1E????\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC2D\uD835\uDC1A??\uD835\uDC22 \uD835\uDC14??\uD835\uDC1C (\uD835\uDC12\uD835\uDC15\uD835\uDC00\uD835\uDC14) ph???i h???p v???i \uD835\uDC07\uD835\uDC28????\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1E??\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1E????\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC13\uD835\uDC21\uD835\uDC1A??\uD835\uDC27\uD835\uDC21 \uD835\uDC29\uD835\uDC21\uD835\uDC28???? \uD835\uDC07\uD835\uDC28???? \uD835\uDC02\uD835\uDC21\uD835\uDC22?? \uD835\uDC0C\uD835\uDC22\uD835\uDC27\uD835\uDC21 ch??nh th???c t??? ch???c \uD835\uDC0D\uD835\uDC20\uD835\uDC1A??\uD835\uDC32 \uD835\uDC21\uD835\uDC28????\uD835\uDC22 \uD835\uDC03\uD835\uDC2E \uD835\uDC21\uD835\uDC28??\uD835\uDC1C \uD835\uDC14??\uD835\uDC1C, S??? ki???n ???????c t??? ch???c \uD835\uDC26\uD835\uDC22\uD835\uDC1E????\uD835\uDC27 \uD835\uDC29\uD835\uDC21\uD835\uDC22?? theo c??? hai h??nh th???c tham gia tr???c ti???p v?? tr???c tuy???n.\"\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link).path("61cd14c7fbd70f912e5c0198");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
