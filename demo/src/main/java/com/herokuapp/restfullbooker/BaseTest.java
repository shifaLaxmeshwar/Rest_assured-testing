package com.herokuapp.restfullbooker;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class BaseTest {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }



    protected Response createBooking() throws JSONException {
        // Create JSON body
        JSONObject body = new JSONObject();
        body.put("firstname", "Shifa");
        body.put("lastname", "Laxmeshwar");
        body.put("totalprice", 786);
        body.put("depositpaid", false);



        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2023-02-07");
        bookingdates.put("checkout", "2023-02-10");
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Ice Cream");

        // Get response
        Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(body.toString())
                .post("/booking");

        return response;
    }





}

