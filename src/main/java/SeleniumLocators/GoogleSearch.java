package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 13");
        Thread.sleep(2000);
        WebElement searchButton=driver.findElement(By.name("btnK"));
        searchButton.click();
        //searchBox.sendKeys(Keys.ENTER);
        //searchBox.sendKeys(Keys.RETURN);
        WebElement result=driver.findElement(By.tagName("nobr"));
        String resultStr=result.getText().replaceAll("[^0-9.]",""); //(0.79 seconds)
        double sec=Double.parseDouble(resultStr);
            // Today's date is : 10/25/2020
        if(sec<3){
            System.out.println(true);
        }else{
            System.out.println(false);
        }





    }
}
