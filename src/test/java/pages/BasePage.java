package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class BasePage {

    protected WebDriver driver;
    public static final String URL = "https://online.moysklad.ru/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setWait() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

    protected abstract boolean isPageOpened(By element);

    protected boolean isPageExist(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException exception) {
            System.out.println("No such element");
            return false;
        }
    }
}

