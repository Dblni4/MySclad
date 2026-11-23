package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class UserSettingsTest extends BaseTest {

    @Test
    public void successfulLoginAndCreationOfNewUser() {
        loginPage.loginToAccount(LOGIN, PASSWORD);
        headerMenuPage.selectingAndClickPageFromTheSettingsInHeaderMenu("Настройки пользователя");
        userSettingsPage.createUserInfo("goga", "gaga", "gggg","48755485", "director" );
        userSettingsPage.clickSaveButton();
        System.out.println();


    }
}
