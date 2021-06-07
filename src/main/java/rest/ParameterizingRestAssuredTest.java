package rest;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class ParameterizingRestAssuredTest {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca","B2R","Waverley"}
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestUsZipCode0200_checkPlaceNameInResponseBody_expectHasSizeAustralianNationalUniversity(String countryCode,String zipCode,String expectedPlaceName){

        given().
                pathParam("countryCode",countryCode).pathParam("zipCode",zipCode).
                when().get("https://www.zippopotam.us/{countryCode}/{zipCode}").then().assertThat().
                body("places[0].'place name'",equalTo(expectedPlaceName));

    }
}
