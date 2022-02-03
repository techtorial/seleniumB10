//package seleniumpaint;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class PaintTest {
//    WebDriver driver;
//
//
//    @Test
//    public  void test(){
//        driver = new ChromeDriver();
//        driver.get("https://kleki.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        PaintPage paintPage= new PaintPage(driver);
//        Actions actions = new Actions(driver);
//        WebElement canvas = paintPage.canvas;
//
//        actions.moveToElement(canvas).perform();
//
////        paintPage.paintLine(actions,canvas,"up",10);
////        paintPage.paintLine(actions,canvas,"up",10);
////        paintPage.paintLine(actions,canvas,"left",10);
////        paintPage.paintLine(actions,canvas,"down",10);
////        paintPage.paintLine(actions,canvas,"right",10);
//        paintPage.paintNine(actions,canvas);
//
//
//
//
//    }
//}
