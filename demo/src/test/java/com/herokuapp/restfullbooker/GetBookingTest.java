package com.herokuapp.restfullbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class GetBookingTest extends BaseTest{
 @Test
    public void GetBookingTest() throws JSONException {
     //Create booking
     Response responseCreate = createBooking();
     responseCreate.print();
     //set path parameters
     spec.pathParam("bookingId", responseCreate.jsonPath().getInt("bookingid"));

      //Get id of the Booking created
      //int bookingid = responseCreate.jsonPath().getInt("bookingid");
      //System.out.println("Shifa's booking id  "+bookingid);
      // Get response with booking
      Response response = RestAssured.given(spec).get("/booking/{bookingId}");
	  response.print();
     //print response
     // Response responseGet = RestAssured.get("https://restful-booker.herokuapp.com/booking/" + bookingid);
     // responseGet.print();



  // Verify response 200
  Assert.assertEquals(responseCreate.getStatusCode(), 200, "Status code should be 200, but it's not");
  //validate data
  SoftAssert softAssert = new SoftAssert();
  String actualFirstName = responseCreate.jsonPath().getString("booking.firstname");
  softAssert.assertEquals(actualFirstName, "Shifa", "firstname in response is not expected");

  String actualLastName = responseCreate.jsonPath().getString("booking.lastname");
  softAssert.assertEquals(actualLastName, "Laxmeshwar", "lastname in response is not expected");

  int price = responseCreate.jsonPath().getInt("booking.totalprice");
  softAssert.assertEquals(price, 786, "totalprice in response is not expected");

  boolean depositpaid = responseCreate.jsonPath().getBoolean("booking.depositpaid");
  softAssert.assertFalse(depositpaid, "depositpaid should be false, but it's not");

  String actualCheckin = responseCreate.jsonPath().getString("booking.bookingdates.checkin");
  softAssert.assertEquals(actualCheckin, "2023-02-07", "checkin in response is not expected");

  String actualCheckout = responseCreate.jsonPath().getString("booking.bookingdates.checkout");
  softAssert.assertEquals(actualCheckout, "2023-02-10", "checkout in response is not expected");

  String actualAdditionalneeds =responseCreate.jsonPath().getString("booking.additionalneeds");
  softAssert.assertEquals(actualAdditionalneeds, "Ice Cream", "additionalneeds in response is not expected");

  softAssert.assertAll();

 }
}
