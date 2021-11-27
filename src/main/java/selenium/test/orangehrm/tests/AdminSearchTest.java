package selenium.test.orangehrm.tests;

import selenium.test.orangehrm.TestBase;
import selenium.test.orangehrm.data.UserRoles;
import selenium.test.orangehrm.pages.HomePage;
import selenium.test.orangehrm.pages.LoginPage;
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
