package tests;

import model.UserSettingsBuilder;
import model.UserSettings;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SetupUserTest extends BaseTest {

    @Test(description = "Testing of filling user setup settings")
    public void successNotificationIsVisibleAfterSavingUserSetupMenu() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        UserSettings userSettings = UserSettingsBuilder.get();
        userSettingsPage.inputUserInfo(userSettings);
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.successNotificationIsVisible(), "User not saved!");
    }

    @Test(description = "Testing of filling user setup settings - checkboxes (checkboxes must be unchecked before test)")
    public void successNotificationIsVisibleAfterSavingUserSetupMenuCheckboxes() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        userSettingsPage.inputUserCheckboxes();
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.isCheckboxSelected(), "Checkboxes are not selected!");
    }
}
