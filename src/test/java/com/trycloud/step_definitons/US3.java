package com.trycloud.step_definitons;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilites.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class US3 {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Actions actions = new Actions(Driver.getDriver());

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
         loginPage.login();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules=new ArrayList<>();
        for (WebElement mainModule : basePage.mainModules) {
            actions.moveToElement(mainModule).perform();
            actualModules.add(mainModule.getText());
        }
        Assert.assertEquals(expectedModules,actualModules);

    }


}
