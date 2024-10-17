package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final By FIRST_STEPS_TEXT_LABEL = By.xpath("//h1[text()='Первые шаги в МоемСкладе']");
    public static final By POPUP_PANEL = By.xpath("//div[@class = 'lognex-popup-panel']");
    public static final By POPUP_PANEL_CLOSE_BUTTON = By.xpath("//div[@class = 'lognex-popup-panel']//button");
    public static final By ARROW_IMG = By.xpath("//img[@class = 'arrow-img']");
    public static final By EXIT_ITEM = By.xpath("//td[@id = 'gwt-uid-9']");
    public static final By USER_SETUP_ITEM = By.id("gwt-uid-4");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isPageExist(FIRST_STEPS_TEXT_LABEL);
    }

    public boolean isPopupDisplayed() {
        return driver.findElement(POPUP_PANEL).isDisplayed();
    }

    public void closePopupPanel() {
        driver.findElement(POPUP_PANEL_CLOSE_BUTTON).click();
    }

    public void exit() {
        driver.findElement(ARROW_IMG).click();
        driver.findElement(EXIT_ITEM).click();
    }

    public void userSetup() {
        driver.findElement(ARROW_IMG).click();
        driver.findElement(USER_SETUP_ITEM).click();
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }
}
