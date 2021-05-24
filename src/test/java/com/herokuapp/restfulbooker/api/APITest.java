package com.herokuapp.restfulbooker.api;

import com.google.gson.Gson;
import com.herokuapp.restfulbooker.Booking;
import com.herokuapp.restfulbooker.Response;
import com.herokuapp.restfulbooker.data.Files;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static io.restassured.RestAssured.with;


public class APITest extends BaseTest {

    private String token;
    private int id;

    private Booking getRequestAsObject(File file) {
        Booking request = null;
        try {
            request = new Gson().fromJson(new FileReader(file), Booking.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return request;
    }

    @Test(priority = 0)
    public void verifyAuthorizationTest() {
        token = with()
                .contentType(ContentType.JSON)
                .body(Files.CREDENTIALS.getFile())
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("token");
    }

    @Test(priority = 1)
    public void verifyCrateBookingTest() {

        Booking request = getRequestAsObject(Files.REQUEST.getFile());

        String responseString = with()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract().asString();

        Response response = new Gson().fromJson(responseString, Response.class);

        id = response.getBookingid();

        Assert.assertEquals(response.getBooking(), request);
    }

    @Test(priority = 2)
    public void verifyUpdateBookingTest() {

        String newLastName = "Gray";
        int newTotalPrice = 222;

        Booking request = getRequestAsObject(Files.REQUEST.getFile());

        request.setLastname(newLastName);
        request.setTotalprice(newTotalPrice);

        String responseString = with()
                .contentType(ContentType.JSON)
                .header("cookie", "token=" + token)
                .body(request)
                .when()
                .put("/booking/" + id)
                .then()
                .statusCode(200)
                .extract().asString();

        Booking response = new Gson().fromJson(responseString, Booking.class);

        Assert.assertEquals(response.getTotalprice(), newTotalPrice);
        Assert.assertEquals(response.getLastname(), newLastName);
    }

    @Test(priority = 3)
    public void verifyBookingIsInListOfAllBookingsTest() {
        List<Integer> ids = with()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("bookingid");
        Assert.assertTrue(ids.contains(id));
    }

    @Test(priority = 4)
    public void verifyDeleteBookingTest() {
        with()
                .contentType(ContentType.JSON)
                .header("cookie", "token=" + token)
                .when()
                .delete("/booking/" + id)
                .then()
                .statusCode(201);
    }
}