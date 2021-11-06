package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {

    // we will create our reusable methods related with browser
    // inside the BrowserUtils class.

    /*
    Method that accepts three param - WebElement and Value and MethodName
    SelectByVisibleText
     */
    public static void selectBy(WebElement element, String value, String methodName){
        Select select= new Select(element);
        // method name can be text, index, value
        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use text, value, or index for method name");
        }

    }

    // method will get the text from the webelement and trim it.
    public static String getText(WebElement element){
        return element.getText().trim();
    }

}
