package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By loginInoput = By.id("lable-login");
    public static final By passwordInput = By.id("lable-password");
    private static final By sigInMyScladLocator = By.xpath("//h1[text()='Вход в МойСклад']");
    private static final By clickLoginButtonLocator = By.id("submitButton");
    private static final By homePageIsDisplayed = By.xpath("//h1[text()='МойСклад для вашего будущего бизнеса']");
    private static final By errorMessageLocator = By.xpath("//div[@class='error-msg']");

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
    }

    public boolean homePageIsDisplayed() {
        return driver.findElement(homePageIsDisplayed).isDisplayed();
    }


    public String errorMessage() {
        return driver.findElement(errorMessageLocator).getText();
    }
}