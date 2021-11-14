package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

public class SweetAlert {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
       driver=new ChromeDriver();
       driver.manage().window().maximize();
        System.out.println("It will run Before each test annotation");
        driver.get("https://sweetalert.js.org/");
        Thread.sleep(2000);
    }

    @Test
    public void sweetAlert() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        WebElement swal=driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        swal.click();

        Thread.sleep(1000);
        WebElement popupMessage=driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessage= BrowserUtils.getText(popupMessage);
        softAssert.assertEquals(actualMessage,"Something"); //right

        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
        Thread.sleep(1000);

        softAssert.assertFalse(okButton.isDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void jsAlert() throws InterruptedException {
        WebElement alert=driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        alert.click();
        Thread.sleep(1000);
        Alert alert1=driver.switchTo().alert();
        alert1.accept();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("It will run after each test annotation");
        driver.quit();
    }


}
