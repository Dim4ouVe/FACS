package com.facs.step_definitions;

import com.facs.pages.LoginPage;
import com.facs.pages.MainPage;
import com.facs.utils.ConfigurationReader;
import com.facs.utils.Driver;
import com.facs.utils.FacsUtils;
import com.facs.utils.WebUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectProject_step_definitions {

    MainPage mainPage = new MainPage();


    @Given("user is login with valid credentials")
    public void user_is_login_with_valid_credentials() {
        FacsUtils.loginValidCredentials();
    }


    @When("user select {string} from the dropdown menu")
    public void userSelectFromTheDropdownMenu(String projectName) {
        mainPage.defaultProject.click();
        FacsUtils.selectProject(projectName);

    }

    @Then("user should be able to see {int} in the url")
    public void userShouldBeAbleToSeeInTheUrl(int projectId) {
        WebUtils.verifyURLContains(String.valueOf(projectId));
    }


    @When("user click on company name logo")
    public void user_click_on_qaqc() {
        mainPage.companyName.click();
    }


    @Then("user should see {string} header is displayed")
    public void userShouldSeeHeaderIsDisplayed(String projectHeaderName) {
        Assert.assertEquals(projectHeaderName, mainPage.projectsHeader.getText());
    }

}

