package com.trycloud.pages;

import com.trycloud.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement checkboxAllFiles;

    @FindBy(xpath = "//td[@class='selection']/..")
    public List<WebElement> allCheckBoxes;


    public WebElement threeDots(String fileName){
        String locator="//a[@class='name']//span[.='"+fileName+"']/../..//span[@class='fileactions']//a[@class='action action-menu permanent']";

        return Driver.getDriver().findElement(By.xpath(locator));

    }

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']//span[2]")
    public WebElement actionFavoriteText;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement actionFavoriteButton;

    public void chosenSubModule(String moduleName){
        String locator ="//a[.='"+moduleName+"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();

    }

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addIcon;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFile;

    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deleteFolderBtn;











}
