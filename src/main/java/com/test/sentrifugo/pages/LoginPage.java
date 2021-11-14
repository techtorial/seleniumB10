package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        // It will initialize the elements that we stored inside this class.
    }

    @FindBy(id="username")
    public WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    // driver.findElement(By.id(""));

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
