package com.yahya.steps;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("database")
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
}
