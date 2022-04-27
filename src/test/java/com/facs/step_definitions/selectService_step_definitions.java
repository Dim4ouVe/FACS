package com.facs.step_definitions;

import com.facs.pages.LoginPage;
import com.facs.pages.MainPage;
import com.facs.utils.Driver;
import com.facs.utils.WebUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class selectService_step_definitions {

    MainPage mainPage = new MainPage();



    @When("user select Service out of the project")
    public void user_select_service_out_of_the_project() {

        mainPage.serviceBtn.click();


    }
    @Then("user should see services for all projects")
    public void user_should_see_services_for_all_projects() {

        for (WebElement webElement : mainPage.serviceTray) {
            Assert.assertTrue(webElement.isDisplayed());
        }


    }

    // selecting services after you project has been selected

    @When("user select Service")
    public void userSelectService() {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(mainPage.projectName).doubleClick().perform();


        mainPage.serviceBtn.click();


    }

    @Then("user should see all services for the current project")
    public void userShouldSeeAllServicesForTheCurrentProject() {

        for (WebElement webElement : mainPage.serviceTray) {
            Assert.assertTrue(webElement.isDisplayed());
        }

    }

}
