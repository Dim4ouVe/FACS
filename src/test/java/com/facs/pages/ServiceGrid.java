package com.facs.pages;

import com.facs.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceGrid {

    public ServiceGrid(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='ng-isolate-scope']/div)[1]")
    public WebElement firstServiceFromGrid;

    @FindBy(xpath = "//span[.='Open']")
    public WebElement openButton;

}
