package tests;

import model.AddGood;
import model.AddGoodBuilder;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class GoodTest extends BaseTest {

    @Test(description = "User can create empty good item")
    public void testGood() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.isPageOpened();
        goodPage.testGood();
        //todo add assert
    }

    @Test(description = "User can create  good item and some not empty fields within it")
    public void testGoods() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.isPageOpened();
        goodPage.testGoodStepOne();
        AddGood addGood = AddGoodBuilder.get();
        goodEditPage.writeIntoInput(addGood);
        goodPage.testGoodStepTwo();
        //todo add assert
    }
}
