package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest {

    public String loginAndPassFieldsAreEmptyMessage = "Чтобы войти, укажите имя пользователя";

    @Test(description = "User should be authorised using valid data")
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        Assert.assertTrue(homePage.isPageOpened(), "Error, you didn't enter the app!");
    }

    @Test(description = "User should not be authorised using valid data")
    public void userShouldNotBeAuthorisedWhenDataIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        Assert.assertEquals(errorMessage, loginAndPassFieldsAreEmptyMessage, "Password and username are required!");
    }
}
