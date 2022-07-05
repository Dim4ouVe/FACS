package com.facs.step_definitions;

import com.facs.pages.MainPage;
import com.facs.pages.ServiceGrid;
import com.facs.utils.FacsUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class selectService_step_definitions {

    MainPage mainPage = new MainPage();
    ServiceGrid testProjectRFI = new ServiceGrid();


    @Then("user should see services for all projects")
    public void user_should_see_services_for_all_projects() {

        for (WebElement webElement : mainPage.serviceTray) {
            Assert.assertTrue(webElement.isDisplayed());
        }


    }


    @And("user select {string} from Service dropdown menu")
    public void userSelectFromServiceDropdownMenu(String service) {
        mainPage.serviceBtn.click();
        FacsUtils.selectService(service);
    }

    @Then("user should see {string} service page page")
    public void userShouldSeeServicePagePage(String serviceHeader) {
        Assert.assertEquals(serviceHeader, mainPage.projectsHeader.getText());
    }


    @Then("assert services dropdown contains services from the datatable")
    public void assert_services_dropdown_contains_services_from_the_datatable(List<String> expectedServiceTray) {

        mainPage.serviceBtn.click();

        List<String> actualServiceTray = new ArrayList<>();

        for (WebElement webElement : mainPage.serviceTray) {
            actualServiceTray.add(webElement.getText());
        }

        Assert.assertEquals(expectedServiceTray, actualServiceTray);

    }


}
