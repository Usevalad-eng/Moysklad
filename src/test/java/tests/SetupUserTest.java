package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SetupUserTest extends BaseTest{

    @Test
    public void userGetSetupUser() {
        authPage.open();
        //authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        //homePage.isPageOpened();
        if (homePage.isPopupDisplayed()) {
            homePage.closePopupPanel();
        }
        Assert.assertTrue(homePage.waitUntilPopupPanelIsInvisible());
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        userSettingsPage.inputUserInfo("tName", "tPatr","tL","+375330000000","tP");
        homePage.userSetupSaveAndClose();  //del
    }
}
