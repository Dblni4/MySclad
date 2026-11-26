package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class Input {

    WebDriver driver;
    String label;
    String inputLocator = "//span[text()='%s']/../../..//input[contains(@class,'gwt-TextBox')]";

    public Input(WebDriver driver, String label) {
        this.label = label;
        this.driver = driver;
    }

    public void setValueInInput(String text) {
        System.out.println("В поле с лэйблом " + label + " введен текст: " + text);
        driver.findElement(By.xpath(format(inputLocator, this.label))).clear();
        driver.findElement(By.xpath(format(inputLocator, this.label))).sendKeys(text);
    }
}
