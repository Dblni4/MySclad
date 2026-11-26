package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void authWithValidData() {
        loginPage.loginToAccount(LOGIN, PASSWORD);
        assertTrue(loginPage.homePageIsDisplayed());
    }

    @Test
    public void authWithNevalidLoginAndValidPassword() {
        loginPage.loginToAccount("false@Login", PASSWORD);
        assertEquals(loginPage.errorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.");
    }

    @Test
    public void authWithValidLoginAndNevalidPassword() {
        loginPage.loginToAccount(LOGIN, "falsePassword");
        assertEquals(loginPage.errorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.");
    }

    @Test
    public void authWithNeValidLoginAndNevalidPassword() {
        loginPage.loginToAccount("false@Login", "falsePassword");
        assertEquals(loginPage.errorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.");
    }

    @Test
    public void authWithEmptyLoginAndEmptyPassword() {
        loginPage.loginToAccount("", "");
        assertEquals(loginPage.errorMessage(),
                "Чтобы войти, укажите имя пользователя");
    }

    @Test
    public void authWithEmptyLoginAndValidPassword() {
        loginPage.loginToAccount("", PASSWORD);
        assertEquals(loginPage.errorMessage(),
                "Чтобы войти, укажите имя пользователя");
    }

    @Test
    public void authWithValidLoginAndEmptyPassword() {
        loginPage.loginToAccount(LOGIN, "");
        assertEquals(loginPage.errorMessage(),
                "Чтобы войти, укажите пароль");
    }

    @Test
    public void authWithSpacesInLoginAndValidPassword() {
        loginPage.loginToAccount("         ", PASSWORD);
        assertEquals(loginPage.errorMessage(),
                "Чтобы войти, укажите имя пользователя");
    }

    @Test
    public void authWithValidLoginAndSpacesInPassword() {
        loginPage.loginToAccount(LOGIN, "         ");
        assertEquals(loginPage.errorMessage(),
                "Чтобы войти, укажите пароль");
    }

    @Test
    public void authWithSpacesBeforeValidLoginAndValidPassword() {
        loginPage.loginToAccount("   " + LOGIN, "  " + PASSWORD);
        assertTrue(loginPage.homePageIsDisplayed());
    }

    @Test
    public void authWithSpacesAfterValidLoginAndValidPassword() {
        loginPage.loginToAccount(LOGIN + "   ", PASSWORD + "   ");
        assertTrue(loginPage.homePageIsDisplayed());
    }


}
