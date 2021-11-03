package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");

        System.out.println(driver.getCurrentUrl());
        // no matter your code will stop on this line.
        Thread.sleep(1000);

        driver.navigate().to("https://www.techtorialacademy.com/");

        System.out.println(driver.getCurrentUrl());

        driver.navigate().back(); // google

        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();

        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();

        System.out.println(driver.getPageSource()); // returns the html from the page.

    }
}
