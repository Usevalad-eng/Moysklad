package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.AuthPage.*;
import static pages.HomePage.*;

public class AuthTest extends BaseTest {

    public String passFieldIsEmptyMessage = "Чтобы войти, укажите имя пользователя";

    @Test
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened(SUBMIT_BUTTON);
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened(FIRST_STEPS_TEXT_LABEL);
    }

    @Test
    public void userShouldNotBeAuthorisedWhenDataIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, passFieldIsEmptyMessage, "Password and username are required");
    }
}
