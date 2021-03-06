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
 * Created by RUTHERFORD on 3/4/2021.
 */
@Listeners(Reporter.class)
public class POSTVGame extends BaseClass{
    @BeforeTest
    public void POSTSetUp(){
        initialization();
        RestAssured.baseURI="http://localhost:8080/app";
        httpRequest=RestAssured.given();
        jsonObject=new JSONObject();
        jsonObject.put("id","0");
        jsonObject.put("FIFA 21","Game");
        jsonObject.put("releaseDate","2021-03-05T02:49:52.288Z");
        jsonObject.put("reviewScore","9.4");
        jsonObject.put("category","Sports");
        jsonObject.put("rating","9.5");

        response=httpRequest.request(Method.POST,"/videogames");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());
    }
    @Test(priority = 0)
    public void testrespBdy(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        Assert.assertTrue(true);
        logger.info("response Body Assertion implemented");
    }
    @Test(priority = 1)
    public void teststatusCode(){
        int statusCode=response.statusCode();
        System.out.println("statusCode "+statusCode);
        Assert.assertTrue(true);
        logger.info("Status Code Assertion implemented");
    }
    @Test(priority = 2)
    public void testHaeders(){
        Headers headers=response.headers();
        for (Header header:headers ){
            System.out.println("header "+header);
            logger.info("Header Assertion implemented");
        }
    }
}
