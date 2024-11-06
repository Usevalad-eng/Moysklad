package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AuthTest extends BaseTest {

    public String loginAndPassFieldsAreEmptyMessage = "Чтобы войти, укажите имя пользователя";
    public String loginAndPassFieldsAreNotInRightFormat = "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.";
    public String loginAndPassFieldsAreNotMatch = "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.";
    @DataProvider(name = "negative tests")
    @Description("negative auth tests")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {"admin", "password", loginAndPassFieldsAreNotInRightFormat},
                {"admin@administrator", "password", loginAndPassFieldsAreNotMatch},
        };
    }

    @Test(description = "Negative auth tests: user should not be authorised using invalid data", dataProvider = "negative tests", groups = "slow")
    public void userShouldNotBeAuthorisedWhenInvalidData(String login, String password, String error) {
        authPage.open();
        authPage.inputLoginAndPassword(login, password);
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        Assert.assertEquals(errorMessage, error, "Error, invalid login or password!");
    }

    @Test(description = "User should be authorised using valid data")
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("admin@oycahox", "Q123456");
        authPage.clickLoginButton();
        homePage.isPageOpened();
        Assert.assertTrue(homePage.isPageOpened(), "Error, you didn't enter the app!");
    }

    @Test(description = "negative auth tests: user should not be authorised using invalid data", groups = "slow")
    public void userShouldNotBeAuthorisedWhenDataIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        Assert.assertEquals(errorMessage, loginAndPassFieldsAreEmptyMessage, "Password and username are required!");
    }
}
