package selenium.test.sentrifugo.tests;

import selenium.test.sentrifugo.TestBase;
import selenium.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validateSuperAdmin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        Assert.assertEquals(driver.getTitle(),"Sentrifugo - Open Source HRMS");

    }

    @Test
    public void validateManagement(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM02","sentrifugo");
        Assert.assertEquals(driver.getTitle(),"Sentrifugo - Open Source HRMS");

    }

    @Test
    public void validateManager(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM03","sentrifugo");
        Assert.assertEquals(driver.getTitle(),"Sentrifugo - Open Source HRMS");

    }

}
