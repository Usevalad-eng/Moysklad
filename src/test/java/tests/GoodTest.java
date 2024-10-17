package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.GoodPage.IMG_HOME;
import static pages.HomePage.FIRST_STEPS_TEXT_LABEL;
import static pages.HomePage.POPUP_PANEL;

public class GoodTest extends BaseTest{

    @Test
    public void testName() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.testGoods();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(IMG_HOME)); //del
        //goodPage.exit();  //del
        //authPage.isPageOpened(); //del
    }
}
