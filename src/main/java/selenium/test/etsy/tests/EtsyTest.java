package selenium.test.etsy.tests;

import selenium.test.etsy.TestBase;
import selenium.test.etsy.pages.EtsyHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTest extends TestBase {

    @Parameters("item")
    @Test
    public void etsySearchTest(String item){
        EtsyHomePage homePage=new EtsyHomePage(driver);
        homePage.searchItem(item);
        Assert.assertTrue(homePage.validateTitle());
    }
    // homework: change validateTitle method implementation that will work with all the search values.
    // now it is working only with "java programming mug"
    @Test
    public void test(){
        EtsyHomePage homePage=new EtsyHomePage(driver);
        homePage.searchItem("java programming mug");
        Assert.assertTrue(homePage.validateTitle());
    }


}
