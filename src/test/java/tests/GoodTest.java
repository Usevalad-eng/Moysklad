package tests;

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

    /*@Test     //todo
    public void testGoods() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.testGoods();
    }*/

    /*@Test //todo
    public void testGoodWithData() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        goodPage.open();
        goodPage.isPageOpened();
        goodEditPage.testGoodWithData();
    }*/
}
