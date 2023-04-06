package com.herokuapp.restfullbooker;

import com.herokuapp.restfullbooker.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingTest() throws JSONException {
        Response response = createBooking();
        response.print();

        // Verifications
        // Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        // Verify All fields
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Shifa", "firstname in response is not expected");

        String actualLastName = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName, "Laxmeshwar", "lastname in response is not expected");

        int price = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(price, 786, "totalprice in response is not expected");

        boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertFalse(depositpaid, "depositpaid should be false, but it's not");

        String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2023-02-07", "checkin in response is not expected");

        String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2023-02-10", "checkout in response is not expected");

        String actualAdditionalneeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualAdditionalneeds, "Ice Cream", "additionalneeds in response is not expected");

        softAssert.assertAll();
    }


}