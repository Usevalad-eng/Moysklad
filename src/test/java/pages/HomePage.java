package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final By FIRST_STEPS_TEXT_LABEL = By.xpath("//h1[text()='Первые шаги в МоемСкладе']");
    public static final By POPUP_PANEL = By.xpath("//div[@class = 'lognex-popup-panel']");
    public static final By POPUP_PANEL_CLOSE_BUTTON = By.xpath("//div[@class = 'lognex-popup-panel']//button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(By element) {
        return isPageExist(element);
    }

    public boolean isPopupDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}
