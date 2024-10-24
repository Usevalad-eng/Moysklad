package pages;

import elements.Buttons;
import elements.DropDown;
import elements.Input;
import model.UserSettings;
import model.UserSettingsWithLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage{

    protected static final By MENU_LOGIN = By.xpath("//div/span[text() = 'Логин']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");
    public static final By SUCCESS_NOTIFICATION = By.xpath("//tr[@class = 'dialogMiddle']//div[text() = 'Сотрудник сохранен']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfo(String name, String patronymic, String lastname){
        new Input(driver, "Имя").write(name);
        new Input(driver, "Отчество").write(patronymic);
        new Input(driver, "Фамилия").write(lastname);
    }

    public void inputUserInfo_(UserSettings userSettings){
        new Input(driver, "Имя").write(userSettings.getName());
        new Input(driver, "Отчество").write(userSettings.getPatronymic());
        new Input(driver, "Фамилия").write(userSettings.getLastname());
        new Input(driver, "Телефон").write(userSettings.getPhone());
        new Input(driver, "Должность").write(userSettings.getPosition());
    }

    public void inputUserInfoWL(UserSettingsWithLombok userSettingsWithLombok){
        new Input(driver, "Имя").write(userSettingsWithLombok.getName());
        new Input(driver, "Отчество").write(userSettingsWithLombok.getPatronymic());
        new Input(driver, "Фамилия").write(userSettingsWithLombok.getLastname());
        new Input(driver, "Телефон").write(userSettingsWithLombok.getPhone());
        new Input(driver, "Должность").write(userSettingsWithLombok.getPosition());
        //new DropDown(driver, "Покупатель").selectOption(userSettingsWithLombok.getCustomer());  //must work
        //new DropDown(driver, "Покупатель").selectOption(0);
        //new DropDown(driver, "Покупатель").selectOption();
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
