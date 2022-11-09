package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest02 {

    @Test
    public void test02() {

        String url="https://reqres.in/api/users";
        Response response=given().when().get(url);

        //Header Test gönderdiğimiz dönen cevaptaki datalar
        response.then().assertThat()
                .statusLine("HTTP/1.1 200 OK")
                .statusCode(200)
                .contentType(ContentType.JSON);

        //Body Test
        /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

      response.then()
        .body("data[0].id",equalTo(1))
        .body("data[0].email",equalTo("george.bluth@reqres.in"))
        .body("data[0].first_name",equalTo("George"))
        .body("data[0].last_name",equalTo("Bluth"));





    }
}
