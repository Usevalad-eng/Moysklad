package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage{
    protected static final By MENU_LOGIN = By.xpath("//div/span[text() = 'Логин']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfo(String name, String patronymic, String lastname, String phone, String position){
        new Input(driver, "Имя").write(name);
        new Input(driver, "Отчество").write(patronymic);
        new Input(driver, "Фамилия").write(lastname);
        new Input(driver, "Телефон").write(phone);
        new Input(driver, "Должность").write(position);
    }

    @Override
    public void open() {
        driver.get(URL + "/app/#account");
    }

    @Override
    protected boolean isPageOpened() {
        return isPageExist(CHANGE_PASSWORD_BUTTON);
    }
}
