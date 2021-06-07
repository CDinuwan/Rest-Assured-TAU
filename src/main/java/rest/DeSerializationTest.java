package rest;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

//import com.github.tomakehurst.wiremock.junit.WireMockRule;
//import dataentities.Location;
//import io.restassured.http.ContentType;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//
//import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.hasSize;

public class DeSerializationTest {

//    @Test
//    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){
//        Location location=
//                given().when().
//                        get("http:api//api.zippopotam.us/us/90210").
//                        as(Location.class);
//
//        Assert.assertEquals(
//                "Beverly Hills",
//                location.getPlaces().get(0).getPlaceName()
//        );
//    }
//
//    @Test
//    public void SendLvZipCode1050_checkStatusCode_expect200(){
//
//        Location location=new Location();
//
//        given().contentType(ContentType.JSON).
//                body(location).
//                log().body().
//                when().
//                post("http://zippopotum.us/us/1050").then().
//                assertThat().statusCode(200);
//    }
}
