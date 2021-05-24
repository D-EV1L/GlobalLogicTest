package com.herokuapp.restfulbooker.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
    }

}
