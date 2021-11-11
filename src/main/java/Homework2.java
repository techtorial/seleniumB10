import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework2 {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        // Login page implementation
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        // How many ways you can select with select class

        // Shopping page implementation
        Select productSort = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        productSort.selectByVisibleText("Price (low to high)");
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//*[.=\"Add to cart\"]"));
        List<WebElement> itemNames = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));


        String firstProductName = itemNames.get(0).getText();
        double firstProductPrice=Double.parseDouble(itemPrices.get(0).getText().trim().substring(1));
        String secondProductName = itemNames.get(1).getText();
        double secondProductPrice=Double.parseDouble(itemPrices.get(1).getText().trim().substring(1));
        addToCartButtons.get(0).click();
        addToCartButtons.get(1).click();
        shoppingCartLink.click();
        // cart page implementation
        List<WebElement> productNamesOnCart = driver.findElements(By.xpath("//*[@class=\"inventory_item_name\"]"));
        List<WebElement> productPricesOnCart = driver.findElements(By.xpath("//*[@class=\"inventory_item_price\"]"));

        Map<String, Double> cartMap = new HashMap<>();
        cartMap.put(productNamesOnCart.get(0).getText(), Double.parseDouble(
                productPricesOnCart.get(0).getText().trim().substring(1)));
        cartMap.put(productNamesOnCart.get(1).getText(), Double.parseDouble(
                productPricesOnCart.get(1).getText().trim().substring(1)));
        boolean price1 = cartMap.get(firstProductName)
                == firstProductPrice;
        boolean price2 = cartMap.get(secondProductName)
                == secondProductPrice;
        if (price1&&price2){
            System.out.println("Test passed succesfully");
        }else {
            throw  new AssertionError("Price on cart and price on shopping page is not mathced");
        }
    }

}
