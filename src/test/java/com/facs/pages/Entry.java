package com.facs.pages;

import com.facs.utils.Driver;
import io.cucumber.java.ja.但し;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Entry {

    public Entry(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@data-label='RFI No']")
    public WebElement rfiNo;

    @FindBy(xpath = "//input[@class='input Text Description ']")
    public WebElement description;

    @FindBy(xpath = "//select[@data-label='From']")
    public WebElement from;

    @FindBy(xpath = "//textarea[@class='Textarea entry_form_comments_newcomment_content_textarea']")
    public WebElement comments;

    @FindBy(id = "carousel-new-FileReference")
    public WebElement fileReference;

    @FindBy(id = "fileCabinetModalBtn")
    public WebElement fileCabinetBrowse;

    @FindBy(xpath = "(//div[@class='elfinder-navbar-wrapper elfinder-navbar-wrapper-root elfinder-navbar-wrapper-pastable elfinder-navbar-wrapper-uploadable'])[2]")
    public WebElement privateFileCabinet;

    @FindBy(id = "fls3_NDY1OC9Ib21lUGFnZS5wbmc")
    public WebElement privateFileCabinetFile;

    @FindBy(xpath = "//button[.='Insert']")
    public WebElement insert;

    @FindBy(id = "buttonSaveEntry")
    public WebElement save;

    @FindBy(xpath = "(//span[@data-id='save_status'])[2]")
    public WebElement saveStatus;


}
