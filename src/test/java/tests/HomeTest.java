package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void loginAndClosePopup() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        if (homePage.isPopupDisplayed()) {
            homePage.closePopupPanel();
        }
        Assert.assertTrue(homePage.waitUntilPopupPanelIsInvisible());
        homePage.exit();
        authPage.isPageOpened();
    }

    @Test
    public void testUserSetup() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        if (homePage.isPopupDisplayed()) {
            homePage.closePopupPanel();
        }
        Assert.assertTrue(homePage.waitUntilPopupPanelIsInvisible());
        homePage.userSetup();
        homePage.exit();
        authPage.isPageOpened();
    }
}
