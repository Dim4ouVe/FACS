package com.facs.utils;

import com.facs.pages.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


public class FacsUtils {


    public static void selectProject(String projectName) {
        WebElement project = Driver.getDriver().findElement(By.xpath("//div[@class='custom-select-panel']/div[. ='" + projectName + "']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(project).perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(project));

        project.click();
    }

    public static void loginValidCredentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().findElement(By.xpath("//input[@id='portal']")).sendKeys(ConfigurationReader.getProperty("portal"));
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(ConfigurationReader.getProperty("email"));
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigurationReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void login(String portal, String email, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().findElement(By.xpath("//input[@id='portal']")).sendKeys(portal);
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void loginInvalidCredentials() {
        Faker faker = new Faker();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().findElement(By.xpath("//input[@id='portal']")).sendKeys(faker.internet().domainWord());
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void selectService(String service) {
        WebElement serviceElement = Driver.getDriver().findElement(By.xpath("//a[.='" + service + "']"));
        serviceElement.click();
    }

    public static void selectButton(String button) {
        WebElement buttonElement = Driver.getDriver().findElement(By.xpath("//span[.='" + button + "']"));
        buttonElement.click();
    }

    public static Boolean confirmEntryID() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String entryID = currentUrl.substring(currentUrl.lastIndexOf("/") + 1);

        return entryID.matches("[0-9]+");
    }

    public static Boolean confirmEntryIsDeleted(String entryID) {
        WebElement entry = Driver.getDriver().findElement(By.xpath("//div[@role='gridcell']/div[.='" + entryID + "']"));

        try {
            entry.isDisplayed();
            return false;
        }catch (NoSuchElementException e){
            return true;
        }
    }

    public static void selectEntryById(String entryID) {
        WebElement entry = Driver.getDriver().findElement(By.xpath("//div[@role='gridcell']/div[.='" + entryID + "']"));
        entry.click();
    }

    public static void inputField(String field, String value) {
        WebElement fieldElement = Driver.getDriver().findElement(By.xpath("//input[@data-label='" + field + "']"));
        fieldElement.sendKeys(value);
    }

    public static void textAreaField(String field, String value) {
        WebElement fieldElement = Driver.getDriver().findElement(By.xpath("//textarea[@data-label='" + field + "']"));
        fieldElement.sendKeys(value);
    }

    public static WebElement inputField(String field) {
        return Driver.getDriver().findElement(By.xpath("//input[@data-label='" + field + "']"));
    }


    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    public static void selectDropdown(String dropdown, String value) {
        Actions actions = new Actions(Driver.getDriver());
        WebElement dropdownElement = Driver.getDriver().findElement(By.xpath("//label[.='"+dropdown+"']/following-sibling::div"));
        actions.moveToElement(dropdownElement).perform();
        dropdownElement.click();
        WebElement dropdownValue = Driver.getDriver().findElement(By.xpath("//div[.='"+value+"']"));

        actions.moveToElement(dropdownValue).perform();
        dropdownValue.click();

    }

    public static void waitToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }



}


