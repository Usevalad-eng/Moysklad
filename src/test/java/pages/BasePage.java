package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String URL = "https://online.moysklad.ru/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public abstract void open();

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

