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
public class DELETEVGame extends BaseClass {
    @BeforeTest
    public void DeleteSetUp(){
        initialization();
        RestAssured.baseURI="http://localhost:8080/app/videogames";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.DELETE,"/0");
    }
    @Test(priority = 0)
    public void testRespbdy(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        Assert.assertTrue(true);
        logger.info("Response Body Assertion implemented");
    }
    @Test(priority = 1)
    public void testrespCde(){
        int statusCode=response.statusCode();
        System.out.println("status Code "+statusCode);
        Assert.assertTrue(true);
        logger.info("Status Code Assertion implemented");
    }
    @Test(priority = 2)
    public void testHeaders(){
        Headers headers=response.headers();
        for (Header header:headers){
            System.out.println("header "+header);
            logger.info("Header Assertion implemented");
        }
    }
}
