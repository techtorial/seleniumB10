package selenium.fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class FileUploadPractice {

    @Test
    public void validateFileUpload(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/techtorial/Desktop/usa.png");

        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.submit();

        WebElement fileName=driver.findElement(By.id("uploaded-files"));
        String actualName= BrowserUtils.getText(fileName);
        Assert.assertEquals(actualName, "usa.png");



    }
}
