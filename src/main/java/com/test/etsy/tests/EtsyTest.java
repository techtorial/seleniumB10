package com.test.etsy.tests;

import com.test.etsy.TestBase;
import com.test.etsy.pages.EtsyHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsyTest extends TestBase {

    @Test
    public void test(){
        EtsyHomePage homePage=new EtsyHomePage(driver);
        homePage.searchItem("java programming mug");
        Assert.assertTrue(homePage.validateTitle());
    }

}
