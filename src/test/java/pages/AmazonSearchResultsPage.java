package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchResultsPage {

    public AmazonSearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "a")
    private List<WebElement> resultsLinks;

    public int getResultsCount() {
        return resultsLinks.size();
    }
}
