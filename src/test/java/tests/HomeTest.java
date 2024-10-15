package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.AuthPage.*;
import static pages.HomePage.*;

public class HomeTest extends BaseTest {

    @Test
    public void loginAndClosePopup() {
        authPage.open();
        authPage.isPageOpened(SUBMIT_BUTTON);
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened(FIRST_STEPS_TEXT_LABEL);
        homePage.setWait();
        if (homePage.isPopupDisplayed(POPUP_PANEL)) {
            driver.findElement(POPUP_PANEL_CLOSE_BUTTON).click();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_PANEL)));
    }
}
