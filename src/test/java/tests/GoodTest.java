package tests;

import model.AddGood;
import model.AddGoodBuilder;
import org.testng.annotations.Test;

public class GoodTest extends BaseTest{

    @Test
    public void testGood() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.isPageOpened();
        goodPage.testGood();
    }

    @Test
    public void testGoodPlus() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.isPageOpened();
        goodPage.testGoodOne();
        AddGood addGood = AddGoodBuilder.get();
        goodEditPage.writeIntoInput(addGood);
        goodPage.testGoodTwo();
    }
}
