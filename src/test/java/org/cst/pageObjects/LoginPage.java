package org.cst.pageObjects;

import org.cst.baseUtil.AbstractUtilComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPage extends AbstractUtilComponents {
    WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//input[@id='Username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passWord;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//input[@type='reset']")
    WebElement reset;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboard;

    @Test
    public void userLogin(Map<String, String> loginDataMap) {
        reset.click();
        userName.sendKeys(loginDataMap.get("userName"));
        passWord.sendKeys(loginDataMap.get("password"));
        submit.click();
        waitForWebElementVisibility(dashboard);
    }
}
