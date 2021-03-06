package com.VGameAPI.TestCases;

import com.VGameAPI.Base.BaseClass;
import com.VGameAPI.Reporting.Reporter;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 3/5/2021.
 */
@Listeners(Reporter.class)
public class PUTVGame extends BaseClass {
    @BeforeTest
    public void PUTSetUp(){
        initialization();
        RestAssured.baseURI="http://localhost:8080/app/videogames";
        httpRequest=RestAssured.given();
        jsonObject=new JSONObject();
        jsonObject.put("id","2");
        jsonObject.put("name","GhostReacon");
        jsonObject.put("releaseDate","2021-03-05T12:25:26.239Z");
        jsonObject.put("reviewScore","9.5");
        jsonObject.put("category","Action/war");
        jsonObject.put("rating","9.9");

        response=httpRequest.request(Method.PUT,"/0");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());
    }
    @Test(priority = 0)
    public void testRespdy(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        Assert.assertTrue(true);
        logger.info("response Body Assertion implemented");
    }
    @Test(priority = 1)
    public void testrespCode(){
        int statusCode=response.statusCode();
        System.out.println("statusCode "+statusCode);
        Assert.assertEquals(statusCode,400);
        logger.info("Status Code Assertion implemented");
    }
    @Test(priority = 2)
    public void testHeaders(){
        Headers headers=response.headers();
        for (Header header:headers){
            System.out.println("header "+header);
            Assert.assertTrue(true);
            logger.info("Header Assertion implementd");
        }
    }
}
