package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class HomeTest extends BaseTest {

    @Test(description = "Testing of possibility to enter user setup")
    public void testUserSetup() {
        authPage.open();
        //authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        homePage.closePopupIfItIsDisplayed();
        homePage.userSetupAndClose();  //todo - move to another page
        Assert.assertTrue(homePage.isPageOpened(), "Error, something went wrong!");
    }

    @Test(description = "Testing the possibility to exit from the app")
    public void testUserSetupAndExit() {
        authPage.open();
        //authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        homePage.closePopupIfItIsDisplayed();
        homePage.userSetup();   //todo - move to another page
        homePage.exit();
        Assert.assertTrue(authPage.isPageOpened(), "error");
    }

    @Test(description = "Testing of login and close popup if it is displayed")
    public void loginAndClosePopup() {
        authPage.open();
        //authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        /*if (homePage.isPopupDisplayed()) {
            homePage.closePopupPanel();
            Assert.assertTrue(homePage.waitUntilPopupPanelIsInvisible());
        }*/
        homePage.closePopupIfItIsDisplayed();
        Assert.assertTrue(homePage.isPageOpened());
    }
}
