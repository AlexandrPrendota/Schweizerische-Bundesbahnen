package com.schweizerischebundesbahnen.automationtest.admin;

import com.schweizerischebundesbahnen.SwissrailwaysApplicationAutomationTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aleksandrprendota on 09.05.17.
 */
public class AutomationCheckNewDialogInAdminPageOnStation {

    private WebDriver driver = null;

    @Before
    public void createDriver() {
        driver = new SafariDriver();
        driver.get(SwissrailwaysApplicationAutomationTests.ADMIN_URL);
    }

    @Test
    public void automaticCheckDiadlogStation() {

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("password")))
                .sendKeys("123");

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("email")))
                .sendKeys("Prendota@mail.ru");

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@type = 'submit']")))
                .click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("addattr")))
                .click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("newstation")))
                .click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text()='Add the station!']")));

    }

    @After
    public void closeDriver() throws Exception {
        driver.quit();
    }
}
