package com.facs.step_definitions;

import com.facs.pages.ErrorPage;
import com.facs.pages.LoginPage;
import com.facs.pages.MainPage;
import com.facs.utils.ConfigurationReader;
import com.facs.utils.Driver;
import com.facs.utils.FacsUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class login_step_definitions {

    Faker faker = new Faker();

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ErrorPage errorPage = new ErrorPage();


    //positive test scenario
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }

    @When("user enter valid portal, username and password")
    public void user_enter_valid_portal_username_and_password() {
        FacsUtils.loginValidCredentials();
    }





    //negative test scenario

    @When("user enter invalid portal, username and password")
    public void user_enter_invalid_portal_username_and_password() {
        FacsUtils.loginInvalidCredentials();

    }

    @Then("user should see error message")
    public void user_should_see_error_message() {

        String errorMessage = "Whoops, looks like something went wrong.";

        Assert.assertEquals(errorMessage, errorPage.errorHeader.getText());


    }

    @When("user login with {string} {string} and {string}")
    public void user_enter_valid_and(String portal, String email, String password) {
        FacsUtils.login(portal, email, password);

    }




    @Then("assert dashboard {string} header is displayed")
    public void assertDashboardHeaderIsDisplayed(String defaultProject) {
        Assert.assertEquals(defaultProject, mainPage.projectsHeader.getText());
    }


    @And("assert select project dropdown is displayed")
    public void assertSelectProjectDropdownIsDisplayed() {
        Assert.assertTrue(mainPage.defaultProject.isDisplayed());
    }

    @And("assert search box is displayed")
    public void assertSearchBoxIsDisplayed() {
        Assert.assertTrue(mainPage.searchInput.isDisplayed());
    }

    @And("assert company name is {string}")
    public void assertCompanyNameIs(String portal) {
        Assert.assertEquals(portal, mainPage.companyName.getText().trim());
    }
}
