package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons {

    protected WebDriver driver;
    protected String label;
    public String buttonLocator = "//span[text() = '%s']";

    public Buttons(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickOn(){
        driver.findElement(By.xpath(String.format(buttonLocator, label))).click();
    }
}
