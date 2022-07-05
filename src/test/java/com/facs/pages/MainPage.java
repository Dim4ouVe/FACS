package com.facs.pages;

import com.facs.utils.Driver;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2")
    public WebElement projectsHeader;

    @FindBy(css = ".custom-select-opener")
    public WebElement defaultProject;

    @FindBy(xpath = "//input[@class='header__search-bar__input']")
    public WebElement searchInput;



    @FindBy(xpath = "(//div[.='Test Project'])[2]")
    public WebElement projectName;

    @FindBy(xpath = "//div[@id='menu4912']")
    public WebElement reports;

    @FindBy(xpath = "//span[@class='header__company-name']")
    public WebElement companyName;

    @FindBy(xpath = "//div[@id='menu1243']")
    public WebElement serviceBtn;

    @FindBy(xpath = "//div[@id='tray-menu1243']/a")
    public List<WebElement> serviceTray;

    @FindBy(linkText = "BMP Inspection")
    public WebElement bmpInspectionService;

    @FindBy(xpath = "//button[@id='new']")
    public WebElement newBtn;

    @FindBy(xpath = "//div[@class='entry-form-service__status-notify']")
    public WebElement statusNotify;

    @FindBy(xpath = "(//div[.='QA Candidate'])[2]")
    public WebElement newEntry;

    @FindBy(xpath = "//button[@id='deleteGridSelection']")
    public WebElement deleteEntry;

    @FindBy(xpath = "//div[@class='header__menu']")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@id='facs-main-column-menu']")
    public WebElement menuColumns;




}
