package com.yahya.steps;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import com.yahya.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import java.time.Duration;

public class Hooks {

    @Before("@database")
    public void setupDBConnection() {

        System.out.println("FROM SET UP DB HOOK");
        String url = ConfigReader.read("sp.database.url");
        String username =  ConfigReader.read("sp.database.username");
        String password = ConfigReader.read("sp.database.password");
        DB_Util.createConnection(url, username, password);

    }

    @After("database")
    public void teardownDBConnection() {
        DB_Util.destroy();
    }

    @After
    public void resetRestAssured() {
        RestAssured.reset();
    }

    @Before("@ui")
    public void setupDriver(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@ui")
    public void tearDown(){

        Driver.closeBrowser();
    }
}
