package SeleniumMentoringAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FacebookCreate {
    /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */

    //SUGGESTIONS :
    //1.ONCE YOU BELIEVE THE PATH IS CORRECT BUT IT IS NOT WORKING. CHECK THE LOCATER(ATTRIBUTE)
    // TO MAKE SURE IT IS NOT DYNAMIC.
    //2. DO NOT TYPE IT MANUALLY ********
    //3.IF YOU ARE GETTING NO SUCH ELEMENT OR INTERACTABLE EXCEPTION **** GO AND CHECK YOUR
    //LOCATER FIRST IF IT IS CORRECT THEN MAXIMIZE YOUR SCREEN IF IT IS STILL FAILING
    //GO AND PUT THREAD SLEEP BEFORE OR AFTER CLICK METHOD

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.fb.com");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.facebook.com/");
        WebElement createbutton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createbutton.click();
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Baldi");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("Baldi@gmail.com");
        WebElement confirmationemail = driver.findElement(By.name("reg_email_confirmation__"));
        confirmationemail.sendKeys("Baldi@gmail.com");
        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("ahmet1234");
        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("Aug");
        WebElement day = driver.findElement(By.id("day"));
        day.sendKeys("13");
        WebElement year = driver.findElement(By.id("year"));
        year.sendKeys("1991");
        WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
        gender.click();
        WebElement signupButton = driver.findElement(By.name("websubmit"));
        signupButton.click();
    }
}
