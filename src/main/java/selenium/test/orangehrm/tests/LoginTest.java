package selenium.test.orangehrm.tests;

import selenium.test.orangehrm.TestBase;
import selenium.test.orangehrm.data.LoginCred;
import selenium.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    /*
    valid username, invalid password
    invalid username, invalid password
    invalid username, valid password
    valid username, valid password (admin, superadmin, employee, hr)
     */
    @Test(dataProvider = "credentials" , dataProviderClass = LoginCred.class)
    public void validateNegativeCredLogin(String username, String password, String expected){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }
}
