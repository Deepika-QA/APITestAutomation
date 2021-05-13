import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class SimpleRestGetTest {

   @Test
    public void getWeatherDetails()
   {
       RestAssured.baseURI = "http://pokeapi.co/api/v2/pokemon/ditto";
       RequestSpecification httpRequest = RestAssured.given();
       Response response = httpRequest.request(Method.GET);
       String responseBody = response.getBody().asString();
       System.out.println("Response Body is=>>" + responseBody);
   }

}
