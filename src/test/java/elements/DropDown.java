package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown {

    protected WebDriver driver;
    protected String label;
    WebDriverWait wait;

    //public String dropDownLocator = "//span[text() = '%s']/ancestor::tr[@class]//input";
    public String dropDownLocator = "//span[text() = '%s']/ancestor::tr[@class]//div[@class = 'load-button tutorial-selector-image']";
    public String optionLocator = "//div[text() = '%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    /*public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(dropDownLocator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }*/

    public void selectOption(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownLocator, label)))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
