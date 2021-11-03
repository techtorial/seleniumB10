package SeleniumMentoringAhmet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1Godaddy {
//    Assignment Level - Beginner
//    Test Case 1 - Open Godaddy.com and maximize browser window.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Close browser.
public static void main(String[] args) throws InterruptedException {
    //POSSIBLE INTERVIEW QUESTION:
    //WHAT IS THE FUNCTION OF WEBDRIVER?
    // WEBDRIVER IS A WAY OF MANIPULATING(CHANGING) THE WEB BROWSER
    //WHAT IS THE FIREFOX DRIVER >?
    //FIREFOX DRIVER IS GECHKO DRIVER>
    //WHAT IS THE DIFFERENCE BETWEEN NAVIGATE TO AND GET?
    //GET : IT WAITS FOR ALL ELEMENTS TO BE LOADED ON THE WEBSITE
    //GET : IT DOESN'T HAVE METHODS
    //NAVIGATE TO : IT WILL WAIT FOR THE SPECIFIC ELEMENT THAT YOU ARE LOOKING FOR
    //IT HAS ALSO SOME METHODS LIKE FORWARD, REFRESH, BACK...
    //WHAT IS THE DIFFERENCE BETWEEN CLOSE AND QUIT?
    //CLOSE WILL CLOSE THE CURRENT WEB BROWSER(TAB)
    //QUIT WILL CLOSE THE DRIVER(IT MEANS ALL OF THE WEB BROWSERS(TABS)
    WebDriver driver= new ChromeDriver();

    driver.navigate().to("https://www.godaddy.com/");
    //SUGGESTION : IF YOU PUT ALL THE ELEMENTS LOCATION CORRECT AND STILL THEY ARE NOT WORKING. MAKE THE WEB BROWSER FULL SCREEN
    //2.SUGGESTION : PUT THE THREAD.SLEEP(3000)
    //driver.manage().window().maximize();
   Thread.sleep(3000);
    driver.quit();



}
}
