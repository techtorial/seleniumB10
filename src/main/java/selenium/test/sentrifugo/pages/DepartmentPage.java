package selenium.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id = "deptname")
    WebElement departmentName;

    @FindBy(id="deptcode")
    WebElement departmentCode;

    @FindBy(id="submitbutton")
    WebElement submitButton;

    @FindBy(className = "ml-selenium.alert-1-success")
    WebElement successMessage;

    public void clickAddButton(){
        addButton.click();
    }

    public void sendDepartmentInfo(String deptName, String deptCode){
        departmentName.sendKeys(deptName);
        departmentCode.sendKeys(deptCode);
    }

    public void clickSubmit(){
        submitButton.submit();
    }

    public String getSuccessMessage(){
        return BrowserUtils.getText(successMessage);
    }
}
