package rest;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {


    //Check Output with our value
    @Test
    public void requestUsZipCode0200_checkPlaceNameInResponseBody_expectAustralianNationalUniversity(){

        given().when().get("https://www.zippopotam.us/AU/0200").then().assertThat().
                body("places[0].'state'",equalTo("Australian Capital Territory"));

    }

    //Check status code
    @Test
    public void requestUsZipCode0200_checkStatusCode_expectHttp200(){

        given().when().get("https://www.zippopotam.us/AU/0200").then().assertThat().
                statusCode(200);

    }

    //Check Content type
    @Test
    public void requestUsZipCode0200_checkContentType_expectApplicationJson(){

        given().when().get("https://www.zippopotam.us/AU/0200").then().assertThat().
                contentType("application/json");

    }

    //Get response body
    @Test
    public void requestUsZipCode0200_loginRequestAndResponseDetails(){

        given().when().get("https://www.zippopotam.us/AU/0200").then().assertThat().
                log().body();
    }

    @Test
    public void requestUsZipCode0200_checkPlaceNameInResponseBody_expectHasAustralianNationalUniversity(){

        given().when().get("https://www.zippopotam.us/AU/0200").then().assertThat().
                body("places[0].'place name'",not(hasItem("Australian National University")));

    }

}
