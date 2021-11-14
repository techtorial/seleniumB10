package com.test.sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://demo.sentrifugo.com/index.php/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
