package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPage extends BasePage {

    public static final By USERNAME = By.xpath("//input[@name = 'j_username']");
    public static final By PASSWORD = By.xpath("//input[@name = 'j_password']");
    public static final By SUBMIT_BUTTON = By.id("submitButton");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public static final By CLOSE_ERROR_MESSAGE = By.xpath("//button[@class='error-button']");


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

    public void open() {
        driver.get(URL);
    }


    /*public boolean isPageOpened() {
        return isPageExist(LOGIN_BUTTON);
    }*/

    @Override
    public boolean isPageOpened(By element) {
        return isPageExist(element);
    }

    public void login() {
        driver.get(URL);
        driver.findElement(USERNAME).sendKeys("standard_user");
        driver.findElement(PASSWORD).sendKeys("secret_sauce");
        driver.findElement(SUBMIT_BUTTON).click();
        //Assert.assertTrue(driver.findElement(PRODUCT_LABEL).isDisplayed());
    }

    public void clickCloseErrorMessageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_ERROR_MESSAGE)).click();
    }

    public boolean errorMessageBlockIsClosed(){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(CLOSE_ERROR_MESSAGE));
    }
}
