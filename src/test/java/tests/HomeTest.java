package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class HomeTest extends BaseTest {

    @Test(description = "Testing of login and close popup")
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
    }

    @Test(description = "Testing of possibility to enter user setup")
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
    }

    @Test(description = "Testing the possibility to exit from the app")
    public void testUserSetupAndExit() {
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
