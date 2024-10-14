package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.AuthPage.SUBMIT_BUTTON;
import static pages.HomePage.*;

public class HomeTest extends BaseTest {

    @Test
    public void loginAndClosePopup() {  //new 14oct2024
        authPage.open();
        authPage.isPageOpened(SUBMIT_BUTTON);
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened(FIRST_STEPS_TEXT_LABEL);
        homePage.setWait();
        if (homePage.isPopupDisplayed(POPUP_PANEL)){
            driver.findElement(POPUP_PANEL_CLOSE_BUTTON).click();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_PANEL)));
    }

    @Test
    public void loginAndAddToBasket() {
        authPage.login();
        homePage.getItemAndClickAddToCartButton("Sauce Labs Backpack");
        homePage.clickBasketButton();
        driver.navigate().back();
        homePage.inventoryPageIsOpen();
    }

    @Test
    public void logoutTest() {
        authPage.login();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        homePage.logoutClick();
        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement expected = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
        Assert.assertTrue(expected.isDisplayed());
    }

    @Test
    public void getFirstItemNameAndPrice() {
        authPage.login();
        homePage.getFirstItemName();
        homePage.getFirstItemPrice();
        System.out.println("I'v got it!");
    }
}
