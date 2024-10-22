package tests;

import model.UserSettings;
import model.UserSettingsBuilder;
import model.UserSettingsWithLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetupUserTest extends BaseTest{

   UserSettings userSettings = new UserSettings("Name", "Patronymic", "LastName",
           "+3750000000", "Position");

    @Test
    public void userGetSetupUser() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        UserSettingsWithLombok userSettingsWithLombok = UserSettingsBuilder.get();
        userSettingsPage.inputUserInfoWL(userSettingsWithLombok);
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.successNotificationIsVisible(), "User not saved!");
        userSettingsPage.clickCloseButton();
    }

    @Test
    public void userGetSetupUserBasic() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        userSettingsPage.inputUserInfo("Name", "Patr.","LName");
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.successNotificationIsVisible(), "User not saved!");
        userSettingsPage.clickCloseButton();
    }

    @Test
    public void userGetSetupUserBasic_() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        userSettingsPage.inputUserInfo_(userSettings);
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.successNotificationIsVisible(), "User not saved!");
        userSettingsPage.clickCloseButton();
    }
}
