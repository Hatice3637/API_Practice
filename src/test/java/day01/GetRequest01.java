package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        //given().when().get(url) -> end point'e göndermek için request oluşturmuş olduk.
        //Response response -> api tarafından bana dönen response (cevap)

        // Response response = given().auth().basic("username", "password" ).when().get(url)
        // basic auth ile request göndermek için

        //response.prettyPrint();     //response'taki body'i yazdırır

        //response.prettyPeek();         //response taki herşeyi yazdırır.

        //response.peek();

        //response.print();     //string olarak dataye verir
        // [{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747}, ...]

        // response.print(); // sadce bodyi string olarak yazdırır
// response.peek(); // tüm veriyi string olarak verir.

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        //junıt ile apı testi yapabiliriz
        Assert.assertEquals(200,response.getStatusCode() );
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());

        //2)assertthat ile hard assert
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");




    }
}