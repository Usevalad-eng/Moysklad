package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.HomePage.*;

public class HomeTest extends BaseTest {

    @Test
    public void loginAndClosePopup() {
        authPage.open();
        //authPage.isPageOpened(SUBMIT_BUTTON);
        //authPage.isAuthPageOpened();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        //homePage.isPageOpened(FIRST_STEPS_TEXT_LABEL);
        //homePage.isHomePageOpened();
        homePage.isPageOpened();
        //homePage.setWait();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_IMG));
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_IMG)).isDisplayed());
        if (homePage.isPopupDisplayed()) {
            //driver.findElement(POPUP_PANEL_CLOSE_BUTTON).click();
            homePage.closePopupPanel();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_PANEL)));
        homePage.exit();
        authPage.isPageOpened();
    }

    @Test
    public void testName() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_IMG));
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_IMG)).isDisplayed());
        if (homePage.isPopupDisplayed()) {
            homePage.closePopupPanel();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_PANEL)));
        homePage.userSetup();
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_IMG)).isDisplayed());
        //Assert.assertTrue(homePage.waitHomePage_logo());
        //homePage.waitHomePage_logo();
        homePage.exit();
        authPage.isPageOpened();
    }
}
