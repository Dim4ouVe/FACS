package com.facs.step_definitions;

import com.facs.pages.MainPage;
import com.facs.utils.Driver;
import com.facs.utils.WebUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class entryServices_step_definitions {

    MainPage mainPage = new MainPage();


    @And("user select BMP Inspection from Service")
    public void userSelectBMPInspectionFromService() {
        mainPage.serviceBtn.click();
        mainPage.bmpInspectionService.click();
    }


    @When("user select New")
    public void user_select_new() {
        mainPage.newBtn.click();

    }
    @Then("entry ID will appear in the URL")
    public void entry_id_will_appear_in_the_url() {
        WebUtils.verifyURLContains("106");

    }
    @Then("page should load without errors")
    public void page_should_load_without_errors() {


        Assert.assertTrue(mainPage.saveStatus.isDisplayed());

    }
    @Then("entry should exist in the selected project's Service listing")
    public void entry_should_exist_in_the_selected_project_s_service_listing() {

        Driver.getDriver().navigate().back();
        Assert.assertTrue(mainPage.newEntry.isDisplayed());

    }


    @And("user go back to the list and delete his entry")
    public void userGoBackToTheListAndDeleteHisEntry() {
        Driver.getDriver().navigate().back();

    }

    @Then("entry user create should be deleted")
    public void entryUserCreateShouldBeDeleted() {
        mainPage.newEntry.click();
        mainPage.deleteEntry.click();

    }
}
