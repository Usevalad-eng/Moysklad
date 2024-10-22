package tests;

import org.testng.Assert;
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
        Assert.assertTrue(homePage.isPageOpened(), "You did't entered the app!");

    }

    @Test
    public void userShouldNotBeAuthorisedWhenDataIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, loginAndPassFieldsAreEmptyMessage, "Password and username are required!");
    }
}
