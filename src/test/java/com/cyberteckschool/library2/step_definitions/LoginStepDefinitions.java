package com.cyberteckschool.library2.step_definitions;

import com.cyberteckschool.library2.pages.LoginPage;
import com.cyberteckschool.library2.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");

    }

    @When("user logs in as a librarian")
    public void user_logs_in_as_a_librarian() throws InterruptedException {
     loginPage.login();
     Thread.sleep(3000);
    }

    @Then("user should be able to see Dashboard")
    public void user_should_be_able_to_see_dashboard() {
        String expected="Dashboard";
        String actual= loginPage.getPageSubTitleText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        Driver.closeDriver();
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }

    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
       loginPage.login(string,string2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult=loginPage.getWarningMessageText();
        Assert.assertEquals(expected,actualResult);

    }


}
