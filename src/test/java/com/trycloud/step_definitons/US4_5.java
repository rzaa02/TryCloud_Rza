package com.trycloud.step_definitons;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilites.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US4_5 {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    FilesPage filesPage = new FilesPage();
    String fileName;
    String anyFile="Branching Statements";

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login();
        String expected = "dashboard";
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        basePage.module(string).click();
    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.checkboxAllFiles.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        String selected= "";
        for (WebElement allCheckBox : filesPage.allCheckBoxes) {
           selected= allCheckBox.getAttribute("class");
           Assert.assertTrue(selected.contains("selected"));
        }
    }

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        filesPage.threeDots(anyFile).click();



    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        if (filesPage.actionFavoriteText.getText().equals(string)){
            filesPage.actionFavoriteButton.click();
        }else{
            filesPage.actionFavoriteButton.click();
            filesPage.threeDots(anyFile).click();
            filesPage.actionFavoriteButton.click();
        }

    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String subModuleName) {
         filesPage.chosenSubModule(subModuleName);
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        String locator = "//td[@class='filename']//span[.='"+anyFile+"']";
      String actualFile = Driver.getDriver().findElement(By.xpath(locator)).getText();
      Assert.assertEquals(anyFile,actualFile);
    }





}
