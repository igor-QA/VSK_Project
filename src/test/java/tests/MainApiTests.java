package tests;

import model.DataList;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spec.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Tag("api")
public class MainApiTests {

    @Test
    public void checkLandingPage() {
    // @formatter:off
        given()
                .spec(Request.spec())
                .get("content/landing")
                .then()
                .statusCode(200)
                .body("data.auto.identity", is("auto"));
    // @formatter:on
    }

    @Test
    public void checkProducts (){
    // @formatter:off
        DataList dataList = given()
                .spec(Request.spec())
                .get("products")
                .then()
                .statusCode(200)
                .extract()
                .as(DataList.class);

        assertThat(dataList.getData().get(0).getName(), is("Под ключ"));
        assertThat(dataList.getData().get(0).getPage(), is("estate"));
        assertThat(dataList.getData().get(0).getCategory().getName(), is("Имущество"));
        assertThat(dataList.getData().get(0).getCategory().getPrefix(), is("estate"));
    // @formatter:on
    }

    @Test
    public void checkLandingKasko(){
        given()
                .spec(Request.spec())
                .get("content/landing/kasko")
                .then()
                .statusCode(200)
                .body("data.identity", is("kasko"));
    }
}