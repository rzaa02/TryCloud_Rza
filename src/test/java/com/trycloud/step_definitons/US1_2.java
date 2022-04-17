package com.trycloud.step_definitons;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilites.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_2 {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get("http://qa3.trycloud.net/");

    }

    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode_userpass123(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);

    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginBtn.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        String actual = Driver.getDriver().getCurrentUrl();
        String expected = "dashboard";
        Assert.assertTrue(actual.contains(expected));
    }

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);

    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String string) {
        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(string,actual);

    }


}
