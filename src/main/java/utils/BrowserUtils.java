package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    /* it will switch window to given target title */
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> ids=driver.getWindowHandles();
        for(String id:ids){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    // implement the method that switch the window by url

    /* it will close all the windows if it is not equals to given window title */
    public static void closeWindowsByTitle(WebDriver driver, String title){
        Set<String> ids=driver.getWindowHandles();
        for(String id: ids){
            driver.switchTo().window(id);
            if(!driver.getTitle().equals(title)){
                driver.close();
            }
        }
    }

    public static void scrollToView(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }


    public static void selectBy(WebElement element, String value, String methodName){
        Select select= new Select(element);
        // method name can be text, index, value
        switch (methodName) {
            case "text" -> select.selectByVisibleText(value);
            case "value" -> select.selectByValue(value);
            case "index" -> select.selectByIndex(Integer.parseInt(value));
            default -> System.out.println("Method name is not available. Use text, value, or index for method name");
        }

    }

    // method will get the text from the webelement and trim it.
    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void getScreenShot(WebDriver driver, String packageName){
        // getScreenShotAs method is taking a screenshot and returning the file of this screen.
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ///Users/techtorial/Downloads/seleniumB10
        String location=System.getProperty("user.dir")+"/src/main/java/screenshot/"+packageName+"/";
        //WINDOWS: String location=System.getProperty("user.dir")+"\\src\\main\\screenshot\\"+packageName+"\\";
        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            System.out.println("Screenshot is not stored.");
            e.printStackTrace();
        }
    }

}
