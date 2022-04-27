package com.facs.step_definitions;

import com.facs.pages.ErrorPage;
import com.facs.pages.LoginPage;
import com.facs.pages.MainPage;
import com.facs.utils.ConfigurationReader;
import com.facs.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class login_step_definitions {

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

        loginPage.portal.sendKeys(ConfigurationReader.getProperty("portal"));
        loginPage.email.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submitBtn.click();
    }



    @Then("user should see be directed to main page and see the projects")
    public void user_should_see_be_directed_to_main_page_and_see_the_projects() {

        String expectedHeader = "Projects";

        Assert.assertEquals(expectedHeader,mainPage.projectsHeader.getText());

    }





    //negative test scenario

    @When("user enter invalid portal, username and password")
    public void user_enter_invalid_portal_username_and_password() {

        loginPage.portal.sendKeys("invalid");
        loginPage.email.sendKeys("invalid@email.com");
        loginPage.password.sendKeys("invalid");
        loginPage.submitBtn.click();


    }

    @Then("user should see error message")
    public void user_should_see_error_message() {

        String errorMessage = "Whoops, looks like something went wrong.";

        Assert.assertEquals(errorMessage,errorPage.errorHeader.getText());



    }
}
