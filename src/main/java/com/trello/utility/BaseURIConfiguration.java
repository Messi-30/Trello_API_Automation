package com.trello.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class BaseURIConfiguration {
        FileInputStream fileInputStream;
        Properties properties;
        public RequestSpecification getRequestSpecification() throws IOException {

            PrintStream printStream= new PrintStream(new FileOutputStream("Logs.txt"));

            RequestSpecification requestSpecification =
                    new RequestSpecBuilder()
                            .setBaseUri("https://api.trello.com")
                            .addQueryParam("key", properties.getProperty("key"))
                            .addQueryParam("token", properties.getProperty("token"))
                            .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                            .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                            .setContentType(ContentType.JSON)
                            .build();
            return requestSpecification;
        }

    public String getGlobalProperties(String key) throws IOException
    {
        Properties property = new Properties();
        FileInputStream fileInputStreamObject = new FileInputStream("C:\\Users\\DEV\\Intellij IDEA projects\\TrelloAPI\\src\\main\\java\\com\\trello\\config\\config.properties");
        property.load(fileInputStreamObject);
        return (String) property.get(key);
    }

    public ResponseSpecification getResponseSpecification()
    {
        ResponseSpecification respobj=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return respobj;
    }
}
