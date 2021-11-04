package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement homeCheck=driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        homeCheck.click();

        WebElement arrowHome=driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']"));
        arrowHome.click();

        WebElement arrowDesktop=driver.findElement(By.xpath("//li[.='Desktop']//button"));

        arrowDesktop.click();

        WebElement arrowDownload=driver.findElement(By.xpath("//li[.='Downloads']//button"));
        arrowDownload.click();

        WebElement arrowDocument=driver.findElement(By.xpath("//li[.='Documents']//button"));
        arrowDocument.click();

        WebElement officeText=driver.findElement(By.xpath("//span[.='Office']"));

        System.out.println(officeText.getText());

    }
}
