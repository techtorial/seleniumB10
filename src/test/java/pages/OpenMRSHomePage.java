package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class OpenMRSHomePage {


    public OpenMRSHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement signInButton;

    @FindBy(id="Inpatient Ward")
    private WebElement inpatientWardLocation;

    public void signIn(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        inpatientWardLocation.click();
        signInButton.click();
    }

}
