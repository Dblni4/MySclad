package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.latest.emulation.model.UserAgentMetadata;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HeaderMenuPage;
import pages.LoginPage;
import pages.UserSettingsPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final String LOGIN = "fusequw@fexpost.com";
    protected final String PASSWORD = "Qwerty123";

    HeaderMenuPage headerMenuPage;
    UserSettingsPage userSettingsPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        headerMenuPage = new HeaderMenuPage(driver);
        userSettingsPage = new UserSettingsPage(driver);
        loginPage = new LoginPage(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
