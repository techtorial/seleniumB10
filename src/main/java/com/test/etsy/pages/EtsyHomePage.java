package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.Locale;

public class EtsyHomePage {

    public EtsyHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    WebElement searchBox;

    @FindBy(xpath = "//li//h3")
    List<WebElement> searchTitle;

    public void searchItem(String searchValue){
        searchBox.sendKeys(searchValue, Keys.ENTER);
    }

    public boolean validateTitle(){
        boolean hasKey=false;
        for (WebElement title: searchTitle){
            String titleName=BrowserUtils.getText(title).toLowerCase();
            if(titleName.contains("java") || titleName.contains("programming") || titleName.contains("mug")){
                hasKey=true;
            }else{
                System.out.println(titleName);
                return false;
            }
        }
        return hasKey;
    }


}
