package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    private GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static GoogleSearchPage instanciateGoogleSearchPage(WebDriver driver) {
        return new GoogleSearchPage(driver);
    }

    @FindBy(name = "q")
    private WebElement searchField;

    public void googleSearch(String searchText) {
        searchField.sendKeys(searchText + Keys.ENTER);
    }

}
