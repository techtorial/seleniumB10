package selenium.test.sentrifugo.tests;

import selenium.test.sentrifugo.TestBase;
import selenium.test.sentrifugo.pages.DepartmentPage;
import selenium.test.sentrifugo.pages.HomePage;
import selenium.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {

    DepartmentPage departmentPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initializePages(){
        departmentPage=new DepartmentPage(driver);
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
    }

    @Test
    public void validateNewDepartment() throws InterruptedException {

        loginPage.login("EM01","sentrifugo");
        homePage.clickDepartments();
        departmentPage.clickAddButton();
        departmentPage.sendDepartmentInfo("Finance","1234");
        departmentPage.clickSubmit();
        Thread.sleep(500);
        String actualMessage=departmentPage.getSuccessMessage();
        Assert.assertEquals(actualMessage,"Department added successfully.");
    }


}
