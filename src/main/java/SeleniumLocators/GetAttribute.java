package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement search=driver.findElement(By.name("btnK"));
        String actualText=search.getAttribute("value");
        String expectedText="Google Search";

        if(actualText.equals(expectedText)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
