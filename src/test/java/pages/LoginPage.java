package pages;

import com.google.common.io.ByteSink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    public static final By loginInoput = By.xpath("//input[@ id='lable-login']");
    public static final By passwordInput = By.id("lable-password");
    private static final By sigInMyScladLocator = By.xpath("//h1[text()='Вход в МойСклад']");
    private static final By clickLoginButtonLocator = By.id("submitButton");
    private static final By homePageIsDisplayed = By.xpath("//h1[text()='МойСклад для вашего будущего бизнеса']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(sigInMyScladLocator);
    }

    public void clickLoginButton() {
        driver.findElement(clickLoginButtonLocator).click();
    }

    public void loginToAccount(String login, String password) {
        driver.get(BASE_URL);
        driver.findElement(loginInoput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        clickLoginButton();
        homePageIsDisplayed();
    }

    public boolean homePageIsDisplayed() {
       return driver.findElement(homePageIsDisplayed).isDisplayed();
    };
}
