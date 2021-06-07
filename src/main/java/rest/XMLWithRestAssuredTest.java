package rest;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XMLWithRestAssuredTest {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills(){

        given().when().
                get("https://www.zippopotam.us/us/90210").
        then().
                assertThat().body("response.places.place.placeName",equalTo("Beverly Hills"));
    }
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectCustomizedData(){

        given().when().
                get("https://www.zippopotam.us/us/90210").
                then().
                assertThat().body("response.places.place[2].placeName",equalTo("Beverly Hills"));
    }//For last place -1
    //@latitude for treated to numbers as other String or something then we can use methods exactly same like Strings
    @Test
    public void requestUsZipCode90210_checkPlacesWithSH_expect4(){

        given().when().
                get("https://www.zippopotam.us/us/90210").
                then().
                assertThat().body("response.places.place.findAll(it.stateAbbreviation='SH')",empty());
    }
}
