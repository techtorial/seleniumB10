package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.data.UserRoles;
import com.test.orangehrm.pages.HomePage;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class AdminSearchTest extends TestBase {

    // TASK: RUN this test annotation with ESS and Admin user roles using DataProvider Annotation.
    @Test(dataProvider = "roles", dataProviderClass = UserRoles.class)
    public void validateSearch(String roleName){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangeUsername"),ConfigReader.readProperty("orangePassword"));
        HomePage homePage=new HomePage(driver);
        homePage.clickAdminButton();
        homePage.selectUserRole(roleName);
        homePage.clickSearchButton();
        Assert.assertTrue(homePage.validateRoleText(roleName));
    }

}
