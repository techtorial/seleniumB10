package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice2 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement typos=driver.findElement(By.xpath("//a[.='Typos']"));

        typos.click();

        WebElement pTwo=driver.findElement(By.xpath("//p[contains(text(), 'other' )]"));

        System.out.println(pTwo.getText());

        driver.navigate().back();

    }
}
