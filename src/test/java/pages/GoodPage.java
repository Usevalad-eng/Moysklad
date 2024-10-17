package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.HomePage.*;

public class GoodPage extends BasePage{



    public static final By GOODS = By.xpath("//div[text() = 'Товары и услуги']");
    public static final By GOOD_BUTTON = By.xpath("//span[text() = 'Товар']");
    public static final By GOOD_FIELD = By.xpath("//input[@class = 'gwt-TextBox field b-validation-field']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");
    public static final By IMG_HOME = By.xpath("//img[@class = 'topMenuItem-img-new']");
    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL + "/app/#good");
    }

    @Override
    protected boolean isPageOpened() {
        return isPageExist(GOODS);
    }

    /*public void exit() {
        driver.findElement(ARROW_IMG).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(EXIT_ITEM));
        driver.findElement(EXIT_ITEM).click();
    }*/

    public void testGoods() {
        driver.findElement(GOOD_BUTTON).click();
        driver.findElements(GOOD_FIELD).get(0).sendKeys("Good test");
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }
}
