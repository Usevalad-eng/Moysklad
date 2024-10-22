package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    protected WebDriver driver;
    protected String label;
    public    String dropDownLocator = "//span[text() = '%s']/ancestor::tr[@class]//input";
    public    String optionLocator = "//div[text() = '%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option){
        driver.findElement(By.xpath(String.format(dropDownLocator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
