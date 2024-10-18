package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    protected WebDriver driver;
    protected String label;
    public static final By ITEM_LOCATOR = By.xpath("//span[text() = '%s']/ancestor::tr[@class]//input");
    //xpath:               //span[text() = 'Артикул']/ancestor::tr[@class]//input

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text){
        driver.findElement(By.xpath(String.format(label,ITEM_LOCATOR))).sendKeys(text);
    }

    public void clear(){
        driver.findElement(By.xpath(String.format(label,ITEM_LOCATOR))).clear();
    }
}
