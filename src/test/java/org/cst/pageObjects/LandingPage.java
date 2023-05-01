package org.cst.pageObjects;

import org.cst.baseUtil.AbstractUtilComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractUtilComponents {
    WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpButton;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginButton;
    public void goTo(String url) {
        webDriver.get(url);
        System.out.println(webDriver.getTitle());
    }

    public RegisterPage signUp() {
        signUpButton.click();
        return new RegisterPage(webDriver);
    }

    public LoginPage login() {
        loginButton.click();
        return new LoginPage(webDriver);
    }
}
