package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown {
    protected WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(null, Duration.ofSeconds(5));
    protected String label;
    public String dropDownLocator = "//span[text() = '%s']/ancestor::tr[@class]//input";

    public String optionLocator = "//div[text() = '%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void setWait(){
        new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

    public void selectOption(String option){    //must work
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionLocator, option))));
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/
        driver.findElement(By.xpath(String.format(dropDownLocator, label))).click();
        //setWait();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void selectOption(int index){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'additional-line']")));
        driver.findElement(By.xpath(String.format(dropDownLocator, label))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'additional-line']")));
        //setWait();
        //driver.findElements(By.xpath("//div[@class = 'additional-line']")).get(index).click();
        driver.findElements(By.xpath("//div[@class = 'popupContent']//tr//tr")).get(index);
    }

    public void selectOption(){
        driver.findElements(By.xpath("//div[@class = 'load-button tutorial-selector-image']")).get(2).click();
        driver.findElements(By.xpath("//div[@class = 'popupContent']//tr//tr")).get(0);
        //setWait();
    }
}
