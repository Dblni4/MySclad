package pages;

import Models.UserInfo;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class UserSettingsPage extends BasePage {

    private static final By groupLabelValueByDefault = By.xpath("//div[text()='Значения по умолчанию']");
    private static final By userSaveLocator = By.xpath("//div[text()='Сотрудник сохранен']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void createUserInfo(UserInfo userInfo) {
        new Input(driver, "Имя").setValueInInput(userInfo.getName());
        new Input(driver, "Отчество").setValueInInput(userInfo.getSecondName());
        new Input(driver, "Фамилия").setValueInInput(userInfo.getSurName());
        new Input(driver, "Телефон").setValueInInput(userInfo.getPhone());
        new Input(driver, "Должность").setValueInInput(userInfo.getPost());
    }

    public void clickSaveButton() {
        new Button(driver).clickButtonByName("Сохранить");
    }

    @Override
    public boolean isPageOpened() {
        return isExist(groupLabelValueByDefault);
    }

    public void userSave() {
        String text = driver.findElement(userSaveLocator).getText();
        assertEquals(text, "Сотрудник сохранен", "Ответ неверный");
    }
}
