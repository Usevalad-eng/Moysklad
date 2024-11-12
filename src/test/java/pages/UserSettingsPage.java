package pages;

import elements.Buttons;
import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.UserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class UserSettingsPage extends BasePage{

    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");
    public static final By SUCCESS_NOTIFICATION = By.xpath("//tr[@class = 'dialogMiddle']//div[text() = 'Сотрудник сохранен']");
    public static final By CHECKBOX_1 = By.id("gwt-uid-122");
    public static final By CHECKBOX_2 = By.id("gwt-uid-125");
    public static final By CHECKBOX_3 = By.id("gwt-uid-126");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("input user info")
    public void inputUserInfo(UserSettings userSettings){
        new Input(driver, "Имя").write(userSettings.getName());
        new Input(driver, "Отчество").write(userSettings.getPatronymic());
        new Input(driver, "Фамилия").write(userSettings.getLastname());
        new Input(driver, "Телефон").write(userSettings.getPhone());
        new Input(driver, "Должность").write(userSettings.getPosition());
        new DropDown(driver, "Покупатель").selectOption(userSettings.getCustomer());
        log.info("--input user info");
    }

    public void inputUserCheckboxes(){
        driver.findElement(CHECKBOX_1).click();
        driver.findElement(CHECKBOX_2).click();
        driver.findElement(CHECKBOX_3).click();
    }

    @Step("saving")
    public void clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
        log.info("--saving");
    }

    public void clickSaveButton_(){
        new Buttons(driver, "Сохранить").clickOn();
    }

    @Step("get success notification")
    public boolean successNotificationIsVisible() {
        log.info("--get success notification");
        return driver.findElement(SUCCESS_NOTIFICATION).isDisplayed();
    }

    public boolean successNotificationIsVisibleCheckboxes() {
        log.info("--get success notification");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_NOTIFICATION)).isDisplayed();
    }
    public boolean isCheckboxSelected(){
        if (driver.findElement(CHECKBOX_1).isSelected() || driver.findElement(CHECKBOX_2).isSelected() || driver.findElement(CHECKBOX_3).isSelected()){
            return true;
        }else {
            return false;
        }
    }

    public void clickCloseButton(){
        driver.findElement(CLOSE_BUTTON).click();
    }

    @Override
    @Step("open page")
    public void open() {
        driver.get(URL + "/app/#account");
        log.info("--open page");
    }

    @Override
    @Step("check if page opened")
    protected boolean isPageOpened() {
        log.info("--check if page opened");
        return isPageExist(CHANGE_PASSWORD_BUTTON);
    }
}
