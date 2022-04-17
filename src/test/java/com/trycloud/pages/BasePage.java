package com.trycloud.pages;

import com.trycloud.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@tabindex='-1']//span")
    public List<WebElement> mainModules;

    @FindBy(xpath = "(//li[@data-id='files'])[1]")
    public List<WebElement> filesModule;

    public WebElement module(String moduleName){
        moduleName = moduleName.toLowerCase();
        WebElement locator;
        if (moduleName.equals("talk")){
            locator=  Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu'] //li[@data-id='spreed'] "));
        }else {
            locator=Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu'] //li[@data-id='"+moduleName+"'] "));
        }

      return locator;
    }


}
