package org.cst.pageObjects;

import org.cst.baseUtil.AbstractUtilComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class RegisterPage extends AbstractUtilComponents {
    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='Surname']")
    WebElement surName;

    @FindBy(xpath = "//input[@id='E_post']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Mobile']")
    WebElement mobile;

    @FindBy(xpath = "//input[@id='Username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='submit']")
    WebElement submit;

    @FindBy(xpath = "//label[@class='label-success']")
    WebElement successMessage;

    @FindBy(xpath = "//label[@class='label-danger']")
    WebElement failedMessage;

    public void registerApplication(Map<String, String> userDataMap) {
        firstName.sendKeys(userDataMap.get("firstName"));
        surName.sendKeys(userDataMap.get("surName"));
        email.sendKeys(userDataMap.get("email"));
        mobile.sendKeys(userDataMap.get("mobile"));
        userName.sendKeys(userDataMap.get("userName"));
        password.sendKeys(userDataMap.get("password"));
        confirmPassword.sendKeys(userDataMap.get("conformPassword"));
        submit.click();
        if (successMessage.isDisplayed()) {
            System.out.println(successMessage.getText());
        } else {
            System.out.println(failedMessage.getText());
        }
    }
}
