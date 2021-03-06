package com.VGameAPI.TestCases;

import com.VGameAPI.Base.BaseClass;
import com.VGameAPI.Reporting.Reporter;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 3/4/2021.
 */
@Listeners(Reporter.class)
public class GETVGame extends BaseClass {
    @BeforeTest
    public void GETSetUp(){
        RestAssured.baseURI="http://localhost:8080/app";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.GET,"/videogames");
        initialization();
    }
    @Test(priority = 0)
    public void testrespbdy(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        logger.info("Response Body implemented");
    }
    @Test(priority = 1)
    public void testrespCode(){
        int statusCode=response.statusCode();
        System.out.println("statusCode "+statusCode);
        Assert.assertEquals(statusCode,200);
        logger.info("Status Code Assertion implemented");
    }
    @Test(priority = 2)
    public void testHeaders(){
        Headers headers=response.headers();
        for (Header header:headers){
            System.out.println("header "+header);
            logger.info("Header iteration implemented");
        }
    }
}
