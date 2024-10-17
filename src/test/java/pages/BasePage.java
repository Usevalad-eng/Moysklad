package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public static final String URL = "https://online.moysklad.ru/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract boolean isPageOpened();

    protected boolean isPageExist(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException exception) {
            System.out.println("No such element");
            return false;
        }
    }
}

