package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest {

    public String loginAndPassFieldsAreEmptyMessage = "Чтобы войти, укажите имя пользователя";

    @Test
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        homePage.exit();
    }

    @Test
    public void userShouldNotBeAuthorisedWhenDataIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, loginAndPassFieldsAreEmptyMessage, "Password and username are required");
    }
}
