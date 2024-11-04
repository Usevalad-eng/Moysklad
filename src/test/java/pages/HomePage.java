package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
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
    @Step("check if page opened")
    public boolean isPageOpened() {
        log.info("--check if page opened");
        return isPageExist(FIRST_STEPS_TEXT_LABEL);
    }

    @Step("check if popup displayed")
    public boolean isPopupDisplayed() {
        try {
            return driver.findElement(POPUP_PANEL).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No popup panel element found");
        }
        log.info("--check if popup displayed");
        return false;
    }

    @Step("close popup")
    public void closePopupPanel() {
        driver.findElement(POPUP_PANEL_CLOSE_BUTTON).click();
        log.info("--close popup");
    }

    @Step("close popup")
    public void closePopupIfItIsDisplayed() {
        if (isPopupDisplayed()) {
            closePopupPanel();
            waitUntilPopupPanelIsInvisible();
            log.info("--close popup");
        }
    }

    @Step("exit")
    public void exit() {
        driver.findElement(ARROW_IMG).click();
        driver.findElement(EXIT_ITEM).click();
        log.info("--exit");
    }

    @Step("go to user setup")
    public void userSetup() {
        driver.findElement(ARROW_IMG).click();
        driver.findElement(USER_SETUP_ITEM).click();
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
        log.info("--go to user setup");
    }

    @Step("go to user setup and close")
    public void userSetupAndClose() {
        driver.findElement(ARROW_IMG).click();
        driver.findElement(USER_SETUP_ITEM).click();
        driver.findElement(CLOSE_BUTTON).click();
        log.info("--go to user setup and close");
    }

    public void userSetupSaveAndClose() {
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }

    @Step("wait until popup get invisible")
    public boolean waitUntilPopupPanelIsInvisible() {
        log.info("--wait until popup get invisible");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_PANEL));
    }

    @Override
    @Step("open page")
    public void open() {
        driver.get(URL + "/app/#homepage");
        log.info("--open page");
    }
}
