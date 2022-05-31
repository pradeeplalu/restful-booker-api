package com.herokuapp.booker.restful.bookinginfo;

import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingDeleteTest extends TestBase {
    @Test
    public void deleteBookingById() {

        Response response = given()
                .header("Authorization", "6d13ad6eacb4cc2d126a1abd97b929b8d61a4a87c83b66b37e40e176ceb5e47e")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=28528346102147d")
                .pathParam("id", 2117)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}


