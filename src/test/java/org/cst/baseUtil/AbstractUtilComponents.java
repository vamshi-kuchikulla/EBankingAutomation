package org.cst.baseUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractUtilComponents {
    WebDriver webDriver;
    public AbstractUtilComponents(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void waitForElementVisibility(By findBy) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementVisibility(WebElement webElement) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementInvisibility(WebElement webElement) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
