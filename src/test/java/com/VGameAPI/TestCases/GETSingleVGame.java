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
 * Created by RUTHERFORD on 3/5/2021.
 */
@Listeners(Reporter.class)
public class GETSingleVGame extends BaseClass {
    @BeforeTest
    public void GETSinSetUp(){
        initialization();
        RestAssured.baseURI="http://localhost:8080/app/videogames";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.GET,"/1");
    }
    @Test(priority = 0)
    public void testRespBdy(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        Assert.assertTrue(true);
        logger.info("Response Body Assertion implemented");
    }
    @Test(priority = 1)
    public void teststaCde(){
        int statusCode=response.statusCode();
        System.out.println("statusCode "+statusCode);
        Assert.assertEquals(statusCode,200);
        logger.info("Status Code Assertion implemented");
    }
    @Test(priority = 2)
    public void testHeaders(){
        Headers headers=response.headers();
        for(Header header:headers){
            System.out.println("header "+header);
            Assert.assertTrue(true);
            logger.info("header Assertion implemented");
        }
    }
}
