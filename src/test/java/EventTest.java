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
        WebTarget requestTarget = client.target(BaseURL + link).queryParam("what","Ngày hội du học Úc").queryParam("where","Nguyễn Huệ");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 200;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
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
                "        \"name_event\": \"Ngày hội du học Úc - AUSSIE STUDY DAY\",\n" +
                "        \"location\": \"141 Nguyễn Huệ, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh 700000, Vietnam\",\n" +
                "        \"time\": \"Chủ Nhật, ngày 16 tháng 01 năm 2022Lúc14:00 - 19:00\\n\",\n" +
                "        \"type\": [\n" +
                "            \"Hội thanh niên, sinh viên\"\n" +
                "        ],\n" +
                "        \"desc\": \"Với mong muốn đưa đến cho các bạn học sinh, sinh viên Việt Nam cái nhìn toàn cảnh về cuộc sống du học cũng như lộ trình phát triển con đường họp tập tại Úc, \uD835\uDC07\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1Ê\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1Ệ\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC2D\uD835\uDC1Ạ\uD835\uDC22 \uD835\uDC14́\uD835\uDC1C (\uD835\uDC12\uD835\uDC15\uD835\uDC00\uD835\uDC14) phối hợp với \uD835\uDC07\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1Ê\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1Ệ\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC13\uD835\uDC21\uD835\uDC1À\uD835\uDC27\uD835\uDC21 \uD835\uDC29\uD835\uDC21\uD835\uDC28̂́ \uD835\uDC07\uD835\uDC28̂̀ \uD835\uDC02\uD835\uDC21\uD835\uDC22́ \uD835\uDC0C\uD835\uDC22\uD835\uDC27\uD835\uDC21 chính thức tổ chức \uD835\uDC0D\uD835\uDC20\uD835\uDC1À\uD835\uDC32 \uD835\uDC21\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC03\uD835\uDC2E \uD835\uDC21\uD835\uDC28̣\uD835\uDC1C \uD835\uDC14́\uD835\uDC1C, Sự kiện được tổ chức \uD835\uDC26\uD835\uDC22\uD835\uDC1Ễ\uD835\uDC27 \uD835\uDC29\uD835\uDC21\uD835\uDC22́ theo cả hai hình thức tham gia trực tiếp và trực tuyến.\"\n" +
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
                "        \"name_event\": \"Ngày hội du học Úc - AUSSIE STUDY DAY\",\n" +
                "        \"location\": \"141 Nguyễn Huệ, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh 700000, Vietnam\",\n" +
                "        \"time\": \"Chủ Nhật, ngày 16 tháng 01 năm 2022Lúc14:00 - 19:00\\n\",\n" +
                "        \"type\": [\n" +
                "            \"Hội thanh niên, sinh viên\"\n" +
                "        ],\n" +
                "        \"desc\": \"Với mong muốn đưa đến cho các bạn học sinh, sinh viên Việt Nam cái nhìn toàn cảnh về cuộc sống du học cũng như lộ trình phát triển con đường họp tập tại Úc, \uD835\uDC07\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1Ê\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1Ệ\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC2D\uD835\uDC1Ạ\uD835\uDC22 \uD835\uDC14́\uD835\uDC1C (\uD835\uDC12\uD835\uDC15\uD835\uDC00\uD835\uDC14) phối hợp với \uD835\uDC07\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC12\uD835\uDC22\uD835\uDC27\uD835\uDC21 \uD835\uDC2F\uD835\uDC22\uD835\uDC1Ê\uD835\uDC27 \uD835\uDC15\uD835\uDC22\uD835\uDC1Ệ\uD835\uDC2D \uD835\uDC0D\uD835\uDC1A\uD835\uDC26 \uD835\uDC13\uD835\uDC21\uD835\uDC1À\uD835\uDC27\uD835\uDC21 \uD835\uDC29\uD835\uDC21\uD835\uDC28̂́ \uD835\uDC07\uD835\uDC28̂̀ \uD835\uDC02\uD835\uDC21\uD835\uDC22́ \uD835\uDC0C\uD835\uDC22\uD835\uDC27\uD835\uDC21 chính thức tổ chức \uD835\uDC0D\uD835\uDC20\uD835\uDC1À\uD835\uDC32 \uD835\uDC21\uD835\uDC28̣̂\uD835\uDC22 \uD835\uDC03\uD835\uDC2E \uD835\uDC21\uD835\uDC28̣\uD835\uDC1C \uD835\uDC14́\uD835\uDC1C, Sự kiện được tổ chức \uD835\uDC26\uD835\uDC22\uD835\uDC1Ễ\uD835\uDC27 \uD835\uDC29\uD835\uDC21\uD835\uDC22́ theo cả hai hình thức tham gia trực tiếp và trực tuyến.\"\n" +
                "    }";
        WebTarget requestTarget = client.target(BaseURL + link).path("61cd14c7fbd70f912e5c0198");
        Response response = requestTarget.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.json(json));
        int actualResponseCode = response.getStatus();
        int expectedResponseCode = 401;
        Assert.assertEquals(expectedResponseCode,actualResponseCode);
    }
}
