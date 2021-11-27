package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class GoogleStepDefs {
    WebDriver driver;

    @Given("I navigated to google.com")
    public void i_navigated_to_google_com() {
        System.out.println("Navigating to google.com");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @When("I search for Techtorial Academy")
    public void i_search_for_techtorial_academy() {
        System.out.println("Searching for Techtorial academy");
        WebElement googleSearchBar = driver.findElement(By.name("q"));
        googleSearchBar.sendKeys("Techtorial academy" + Keys.ENTER);

    }

    @Then("I get more than {int} results")
    public void i_get_more_than_results(Integer expectedLinks) {
        System.out.println("Validating the result");
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        Assert.assertTrue(linkList.size() > expectedLinks);
    }


}
