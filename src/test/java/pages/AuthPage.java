package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AuthPage extends BasePage {
    public static final By USERNAME = By.xpath("//input[@name = 'j_username']");
    public static final By PASSWORD = By.xpath("//input[@name = 'j_password']");
    public static final By SUBMIT_BUTTON = By.id("submitButton");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='error-msg']");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void inputLoginAndPassword(String name, String password) {
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Override
    @Step("open page")
    public void open() {
        driver.get(URL);
        log.info("-->opening the page");
    }

    @Override
    public boolean isPageOpened() {
        return isPageExist(SUBMIT_BUTTON);
    }
}
