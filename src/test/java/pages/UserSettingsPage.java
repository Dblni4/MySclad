package pages;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserSettingsPage extends BasePage {

    private static final By groupLabelValueByDefault = By.xpath("//div[text()='Значения по умолчанию']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void createUserInfo(String name, String secondName, String surName, String phone, String post) {
        new Input(driver, "Имя").setValueInInput(name);
        new Input(driver, "Отчество").setValueInInput(secondName);
        new Input(driver, "Фамилия").setValueInInput(surName);
        new Input(driver, "Телефон").setValueInInput(phone);
        new Input(driver, "Должность").setValueInInput(post);
    }

    public void clickSaveButton() {
        new Button(driver).clickButtonByName("Сохранить");
    }

    @Override
    public boolean isPageOpened() {
        return isExist(groupLabelValueByDefault);
    }
}
