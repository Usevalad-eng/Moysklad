package tests;

import model.UserSettingsBuilder;
import model.UserSettings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetupUserTest extends BaseTest{

    @Test
    public void successNotificationIsVisibleAfterSavingUserSetupMenu() {
        authPage.open();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        UserSettings userSettingsWithLombok = UserSettingsBuilder.get();
        userSettingsPage.inputUserInfoWL(userSettingsWithLombok);
        userSettingsPage.clickSaveButton();
        Assert.assertTrue(userSettingsPage.successNotificationIsVisible(), "User not saved!");
        userSettingsPage.clickCloseButton();
    }
}
