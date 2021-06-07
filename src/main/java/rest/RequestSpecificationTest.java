package rest;
import com.tngtech.java.junit.dataprovider.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestSpecificationTest {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createRequestSpecification(){

        requestSpecification=new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us").build();
    }

    @BeforeClass
    public static void createResponseSpecification(){

        responseSpecification=new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeveryHills(){
        given().
                spec(requestSpecification).
                when().get("us/90210").then().
                assertThat().
                statusCode(200);
    }
    @Test
    public void checkResponseZipCode90210_checkPlaceNameInResponseBody_expectBeveryHills(){
        given().
                spec(requestSpecification).
                when().get("http://zippopotam.us/us/90210").then().
                spec(responseSpecification).
                and().assertThat().
                body("places[0].'place name'",equalTo("Beverly Hills"));
    }
}
