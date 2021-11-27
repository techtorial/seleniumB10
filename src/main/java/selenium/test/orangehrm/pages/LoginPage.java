package selenium.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="txtUsername")
    WebElement username;

    @FindBy(id="txtPassword")
    WebElement password;

    @FindBy(id="btnLogin")
    WebElement loginButton;

    @FindBy(id="spanMessage")
    WebElement errorMessage;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
