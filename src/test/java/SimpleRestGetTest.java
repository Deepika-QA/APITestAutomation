import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SimpleRestGetTest {

    @Test
    public void sampleTestOne()
   {
       RestAssured.baseURI = "http://pokeapi.co/api/v2/pokemon/ditto";
       RequestSpecification httpRequest = RestAssured.given();
       Response response = httpRequest.request(Method.GET);
       String responseBody = response.getBody().asString();
   }

   @Test
    public void sampleTestTwo()
   {
       RestAssured.baseURI = "http://bookstore.toolsqa.com";
       RequestSpecification httpRequest = RestAssured.given();
       httpRequest.header("Content-Type","application/json");
       Response response = httpRequest.get("/BookStore/v1/Books");
       String jsonString = response.asString();
       List<Map<String,String>> books = JsonPath.from(jsonString).get("books");
       Assert.assertTrue(books.size() > 0);
   }

}
