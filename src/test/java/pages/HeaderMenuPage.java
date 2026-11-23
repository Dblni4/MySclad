package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class HeaderMenuPage extends BasePage {

    private static final By headerAccountSettingsMenu = By.xpath("//table[@title='Аккаунт']");
    private static final String settingMenuHeaderLocator = "//div[@role='menubar']/descendant::td[text()='%s']";

    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    public void selectingAndClickPageFromTheSettingsInHeaderMenu(String buttonHeaderSettingName) {
        driver.findElement(headerAccountSettingsMenu).click();
        driver.findElement(By.xpath(format(settingMenuHeaderLocator, buttonHeaderSettingName))).click();

    }

    @Override
    public boolean isPageOpened() {
        return isExist(headerAccountSettingsMenu);
    }
}
