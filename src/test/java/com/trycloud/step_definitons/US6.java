package com.trycloud.step_definitons;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilites.BrowserUtils;
import com.trycloud.utilites.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;

public class US6 {
    String anyFile = "Branching Statements";
    FilesPage filesPage = new FilesPage();
    String filename = "SeleniumPill.jpeg";

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {

        try {
            String locator = "//td[@class='filename']//span[.='" + anyFile + "']";
            String actualFile = Driver.getDriver().findElement(By.xpath(locator)).getText();
            Assert.assertTrue(!actualFile.equals(anyFile));
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();
    }

    @When("user uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        String path = System.getProperty("user.dir")+"/src/test/resources/files/evidence 2.PNG";
        String path2 = "C:/Users/rzaal/Desktop/SeleniumPill.jpeg";

        BrowserUtils.highlight(filesPage.uploadFile);
        filesPage.uploadFile.sendKeys(path2);


    }

    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
       String locator = "//span[.='"+filename+"']";
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath(locator)).isDisplayed());
       filesPage.threeDots(filename).click();
       filesPage.deleteFolderBtn.click();
    }


}
