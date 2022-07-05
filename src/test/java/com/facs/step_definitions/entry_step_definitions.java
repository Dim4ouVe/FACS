package com.facs.step_definitions;

import com.facs.pages.MainPage;
import com.facs.pages.Entry;
import com.facs.pages.ServiceGrid;
import com.facs.utils.Driver;
import com.facs.utils.FacsUtils;
import com.facs.utils.WebUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class entry_step_definitions {

    MainPage mainPage = new MainPage();
    Entry entry = new Entry();
    ServiceGrid serviceGrid = new ServiceGrid();


    Faker faker = new Faker();
    static String RFI_number;



    @And("user press {string} button")
    public void userPressButton(String button) {
        FacsUtils.selectButton(button);

    }



    @Then("entry ID will appear in the URL")
    public void entry_id_will_appear_in_the_url() {
        Assert.assertTrue(FacsUtils.confirmEntryID());

    }


    @Then("assert {string} is empty")
    public void assertIsEmpty(String rfiNo) {
        Assert.assertTrue(entry.rfiNo.getText().isEmpty());
    }


    @And("assert {string} field is empty")
    public void assertFieldIsEmpty(String description) {
        Assert.assertTrue(entry.description.getText().isEmpty());
    }

    @And("user select last created entry")
    public void userSelectLastCreatedEntry() {
        WebUtils.sleep(2);
        serviceGrid.firstServiceFromGrid.click();

    }


    @When("user select {string} and select {string} from Service dropdown menu")
    public void userSelectAndSelectFromServiceDropdownMenu(String project, String service) {
        mainPage.defaultProject.click();
        FacsUtils.selectProject(project);
        mainPage.serviceBtn.click();
        FacsUtils.selectService(service);
    }


    @When("enter information on the fields below")
    public void enter_information_on_the_fields_below(List<String> inputs) {

        RFI_number = faker.number().digits(8);

        //RFI Number
        FacsUtils.inputField(inputs.get(0)).clear();
        FacsUtils.inputField(inputs.get(0), RFI_number);
        //Date Received
        FacsUtils.inputField(inputs.get(1)).clear();
        FacsUtils.inputField(inputs.get(1), FacsUtils.dateFormat(faker.date().birthday()));
        //Description
        FacsUtils.inputField(inputs.get(2), faker.lorem().sentence());
        //Action
        FacsUtils.textAreaField(inputs.get(3), faker.lorem().sentence());
        //Date Response
        FacsUtils.inputField(inputs.get(4)).clear();
        FacsUtils.inputField(inputs.get(4), FacsUtils.dateFormat(faker.date().birthday()));
        //Date to Contractor
        FacsUtils.inputField(inputs.get(5)).clear();
        FacsUtils.inputField(inputs.get(5), FacsUtils.dateFormat(faker.date().birthday()));
        //Description of Response
        FacsUtils.textAreaField(inputs.get(6), faker.lorem().sentence());


    }
    @When("click on {string} dropdown menu and select {string}")
    public void click_on_dropdown_menu_and_select(String fromDropdown, String fromOptions) {

        FacsUtils.selectDropdown(fromDropdown, fromOptions);

    }
    @When("add comments")
    public void add_comments() {

        entry.comments.sendKeys(faker.lorem().sentence());

    }


    @And("attach a file to a reference from the file cabinet")
    public void attachAFileToAReferenceFromTheFileCabinet() {
        entry.fileReference.click();
        entry.fileCabinetBrowse.click();
        entry.privateFileCabinet.click();
        entry.privateFileCabinetFile.click();
        entry.insert.click();
        entry.save.click();
    }


    @Then("assert save-status is {string}")
    public void assertSaveStatusIs(String saveStatus) {
        Assert.assertEquals(saveStatus, entry.saveStatus.getText());
    }

    @Then("assert entry is deleted")
    public void assertEntryIsDeleted() {

        FacsUtils.confirmEntryIsDeleted(RFI_number);

    }

    @And("user select entry from the listing")
    public void userSelectEntryFromTheListing() {
        WebUtils.sleep(2);
        FacsUtils.selectEntryById(RFI_number);
    }
}

