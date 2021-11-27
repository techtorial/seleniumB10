package seleniumpaint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaintPage {

    public PaintPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static int x = 0;
    public static int y = 0;

    @FindBy (xpath =  "//canvas[1]")
    WebElement canvas;

    public void setXandYtoZero (){
        x=0;
        y=0;

    }

    public void paintNine(Actions actions,WebElement canvas) {
        paintLine(actions,canvas,"up",10);
        paintLine(actions,canvas,"up",10);
        paintLine(actions,canvas,"left",10);
        paintLine(actions,canvas,"down",10);
        paintLine(actions,canvas,"right",10);
    }

    public void paintLine(Actions actions,WebElement element,String direction,int distanceInPixel){
        switch (direction) {
            case "up" -> {
                setXandYtoZero();

                actions.clickAndHold().perform();
                for (int i = 0; i < distanceInPixel; i++) {

                    actions.moveByOffset(x,y).perform();
                    y--;

                }
//                actions.release();
           }
            case "down" -> {
                setXandYtoZero();

                actions.clickAndHold().perform();
                for (int i = 0; i < distanceInPixel; i++) {

                    actions.moveByOffset(x,y).perform();
                    y++;

                }
//                actions.release();
            }
            case "left" -> {
                setXandYtoZero();

                actions.clickAndHold().perform();
                for (int i = 0; i < distanceInPixel; i++) {

                    actions.moveByOffset(x,y).perform();
                    x--;

                }
//                actions.release();
            }
            case "right" -> {
                setXandYtoZero();

                actions.clickAndHold().perform();
                for (int i = 0; i < distanceInPixel; i++) {

                    actions.moveByOffset(x,y).perform();
                    x++;

                }
//                actions.release();
            }
        }

    }
}
