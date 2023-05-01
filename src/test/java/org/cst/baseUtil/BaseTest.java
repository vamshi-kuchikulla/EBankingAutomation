package org.cst.baseUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.cst.pageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver webDriver;
    public LandingPage landingPage;
    String baseUrl;

    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/application.properties");
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");
        baseUrl = properties.getProperty("baseUrl");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            webDriver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            webDriver = new FirefoxDriver(options);
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        return webDriver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        webDriver = initializeDriver();
        landingPage = new LandingPage(webDriver);
        landingPage.goTo(baseUrl);
        return landingPage;
    }

    @AfterMethod
    public void tearDown(){
      //  webDriver.quit();
    }
}
