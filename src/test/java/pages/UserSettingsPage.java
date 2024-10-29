package pages;

import elements.Buttons;
import elements.DropDown;
import elements.Input;
import model.UserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage{

    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");
    public static final By SUCCESS_NOTIFICATION = By.xpath("//tr[@class = 'dialogMiddle']//div[text() = 'Сотрудник сохранен']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfoWL(UserSettings userSettings){
        new Input(driver, "Имя").write(userSettings.getName());
        new Input(driver, "Отчество").write(userSettings.getPatronymic());
        new Input(driver, "Фамилия").write(userSettings.getLastname());
        new Input(driver, "Телефон").write(userSettings.getPhone());
        new Input(driver, "Должность").write(userSettings.getPosition());
        //new DropDown(driver, "Покупатель").selectOption(userSettings.getCustomer());
    }

    public void clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
    }

    public void clickSaveButton_(){
        new Buttons(driver, "Сохранить").clickOn(); //todo
    }

    public boolean successNotificationIsVisible(){
        return driver.findElement(SUCCESS_NOTIFICATION).isDisplayed();
    }

    public void clickCloseButton(){
        driver.findElement(CLOSE_BUTTON).click();
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
