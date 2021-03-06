package com.VGameAPI.Base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import java.util.logging.Logger;

/**
 * Created by RUTHERFORD on 3/4/2021.
 */
public class BaseClass {
    public static Logger logger;
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject jsonObject;

    public void initialization(){
        PropertyConfigurator.configure("Log4j.properties");
        logger=Logger.getLogger("VGameAPI Project");
    }
}
