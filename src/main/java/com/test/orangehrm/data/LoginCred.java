package com.test.orangehrm.data;

import org.testng.annotations.DataProvider;

public class LoginCred {

    @DataProvider(name = "credentials")
    public Object[][] getCred(){
        return new Object[][]{
                {"Admin","test","Invalid credentials"},
                {"test","admin123","Invalid credentials"},
                {"test","test","Invalid credentials"}
        };
    }

}
