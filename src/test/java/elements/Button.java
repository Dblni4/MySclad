package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class Button {
    WebDriver driver;
    String buttonLocator = "//div[@role='button']//span[text()='%s']";

    public Button(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonByName(String buttonName) {
        driver.findElement(By.xpath(format(buttonLocator, buttonName))).click();
    }
}
