package tests;

import Models.UserInfo;
import Models.UserInfoFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UserSettingsTest extends BaseTest {

    @Test
    public void successfulLoginAndCreationOfNewUser() {
        loginPage.loginToAccount(LOGIN, PASSWORD);
        headerMenuPage.selectingAndClickPageFromTheSettingsInHeaderMenu("Настройки пользователя");
        UserInfo userInfo = UserInfoFactory.get();

        userSettingsPage.createUserInfo(userInfo);

        userSettingsPage.clickSaveButton();

        userSettingsPage.userSave();


    }
}
