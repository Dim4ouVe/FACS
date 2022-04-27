package com.facs.step_definitions;

import com.facs.pages.LoginPage;
import com.facs.pages.MainPage;
import com.facs.utils.ConfigurationReader;
import com.facs.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class selectProject_step_definitions {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();



    @Given("user is login with valid credentials")
    public void user_is_login_with_valid_credentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.portal.sendKeys(ConfigurationReader.getProperty("portal"));
        loginPage.email.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submitBtn.click();

    }
    @When("user select project from the dropdown menu")
    public void user_select_project_from_the_dropdown_menu() {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(mainPage.projectName).doubleClick().perform();



    }
    @Then("user should be able to see reports")
    public void user_should_be_able_to_see_reports() {

        Assert.assertTrue(mainPage.reports.isDisplayed());

    }



    @When("user click on QAQC")
    public void user_click_on_qaqc() {
        mainPage.companyName.click();
    }

    @Then("user should see projects")
    public void user_should_see_projects() {

        Assert.assertTrue(mainPage.projectsHeader.isDisplayed());

    }



}
