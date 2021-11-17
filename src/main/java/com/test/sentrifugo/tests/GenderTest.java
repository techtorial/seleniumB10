package com.test.sentrifugo.tests;

import com.test.sentrifugo.TestBase;
import com.test.sentrifugo.pages.GenderPage;
import com.test.sentrifugo.pages.HomePage;
import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GenderTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    GenderPage genderPage;

    @BeforeMethod
    public void initializePages(){
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        genderPage=new GenderPage(driver);
    }

    @Test
    public void validateGenderError(){
        loginPage.login("EM01","sentrifugo");
        homePage.clickGender();
        genderPage.clickAddButton();
        genderPage.sendGenderInfo("F","Female");
        genderPage.clickSaveButton();
        String genderCodeColor=genderPage.getGenderCodeColor();
        String genderColor=genderPage.getGenderColor();
        Assert.assertEquals(genderCodeColor, "rgba(255, 0, 0, 1)");
        Assert.assertEquals(genderColor, "rgba(255, 0, 0, 1)");
    }
}
