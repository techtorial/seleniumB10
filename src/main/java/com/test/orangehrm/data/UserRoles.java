package com.test.orangehrm.data;

import org.testng.annotations.DataProvider;

public class UserRoles {

    @DataProvider(name="roles")
    public Object[][] getRoles(){
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }

}
