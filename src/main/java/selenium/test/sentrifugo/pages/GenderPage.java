package selenium.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderPage {

    public GenderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id="gendercode")
    WebElement genderCode;

    @FindBy(id="gendername")
    WebElement gender;

    @FindBy(id="submitbutton")
    WebElement saveButton;

    @FindBy(id="errors-gendercode")
    WebElement genderCodeError;

    @FindBy(id="errors-gendername")
    WebElement genderError;


    public void clickAddButton(){
        addButton.click();
    }

    public void sendGenderInfo(String genderCode, String gender){
        this.genderCode.sendKeys(genderCode);
        this.gender.sendKeys(gender);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public String getGenderCodeColor(){
        return genderCodeError.getCssValue("color");
    }

    public String getGenderColor(){
        return genderError.getCssValue("color");
    }

}
