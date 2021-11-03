package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HW1 {
    public static void main(String[] args) throws InterruptedException {


    WebDriver driver = new ChromeDriver();
    // How can we navigate to web page?
    // get or navigate?

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);
     WebElement usernameField=
    driver.findElement(By.xpath("//input[@id=\"userName\"]"));
      ////input[@id="userEmail"]

     WebElement emailField=   driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        WebElement currentAddressField = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement permanentAdressField = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        WebElement outPut = driver.findElement(By.xpath("//div[@id='output']"));
        usernameField.sendKeys("Yusuf");
        emailField.sendKeys("yct@gmail.com");
        currentAddressField.sendKeys("Chicago");
        permanentAdressField.sendKeys("Streamwood");
        submitButton.click();
        List<WebElement> outputs = driver.findElements(By.xpath("//p[@class=\"mb-1\"]"));

// First element from this outputs is name
        String actualName= outputs.get(0).getText();
        String actualEmail= outputs.get(1).getText();
        String actualCurrentAddress= outputs.get(2).getText();
        String actualPermanentAddres= outputs.get(3).getText();
       String expectedName="Name:"+"Yusuf";
       String expectedEmail="Email:"+"yct@gmail.com";
       String expectedCurrentAddres="Current Address :"+"Chicago";
       String expectedPermanentAddress="Permananet Address :"+"Streamwood";
      boolean isNameDisplayed=actualName.equals(expectedName);
      if (isNameDisplayed){
          boolean isEmailDisplayed= expectedEmail.equals(actualEmail);
          if (isEmailDisplayed){
             boolean isCurrentAddressDisplayed=expectedCurrentAddres.equals(actualCurrentAddress);
             if (isCurrentAddressDisplayed){
                 if (expectedPermanentAddress.equals(actualPermanentAddres)){
                     System.out.println("Every info has been displayed correctly");
                 }else{
                     System.out.println("Permanent adress display is failed!");
                 }
             }else {
                 System.out.println("Current address display is failed!");

             }          }else {
              System.out.println("Email display is failed!");
          }
      }else {
          System.out.println("Name display is failed!");
      }

driver.navigate().to("https://demoqa.com/radio-button");
      Thread.sleep(5000);
      WebElement yesButton=driver.findElement(By.xpath("//input[@id=\"yesRadio\"]"));
    new Actions(driver).click(yesButton).perform();
      String expected="You have selected Yes";
      WebElement actualText=driver.findElement(By.xpath("//span[.=\"Yes\"]"));
      if (actualText.getText().equalsIgnoreCase("Yes"))
          System.out.println("Test has passed");


}}
