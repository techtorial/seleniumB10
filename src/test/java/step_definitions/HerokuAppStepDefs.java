package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class HerokuAppStepDefs {
    WebDriver driver = Driver.getDriver();

    @Given("user navigated to HerokuApp home page")
    public void userNavigatedToHerokuAppHomePage() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @When("user clicks on {string}")
    public void userClicksOn(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    @Then("user should see {string}")
    public void userShouldSee(String pageHeader) {
        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(header.getText(), pageHeader);
    }

    @When("user navigates to Checkboxes page")
    public void userNavigatesToCheckboxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Then("user should see checkboxes as follows:")
    public void userShouldSeeCheckboxesAsFollows(io.cucumber.datatable.DataTable dataTable) {
        List<WebElement> checkboxes = driver.findElements(By.id("checkboxes"));
        Map<String, String> checkboxesMap = dataTable.asMap();
        String checkbox1Text = checkboxesMap.get("checkbox1Text");
        String checkbox2Text = checkboxesMap.get("checkbox2Text");
        Assert.assertTrue(checkboxes.get(0).getText().contains(checkbox1Text));
        Assert.assertTrue(checkboxes.get(1).getText().contains(checkbox2Text));

    }


}
