package com.herokuapp.booker.restful.bookinginfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingPatchTest extends TestBase {
    @Test
    public void partiallyUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Mahi");
        bookingPojo.setLastname("Mirawa");

        Response response = given()
                .header("Authorization", "Bearer 0c90e41203eca75")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=28528346102147d")
                .pathParam("id", 648)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        //response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}





