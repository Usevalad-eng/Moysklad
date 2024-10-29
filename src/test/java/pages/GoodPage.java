package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodPage extends BasePage{

    public static final By GOODS_LABEL = By.xpath("//td/div[text() = 'Товары и услуги']");
    public static final By GOOD_BUTTON = By.xpath("//span[text() = 'Товар']");
    public static final By GOOD_FIELD = By.xpath("//input[@class = 'gwt-TextBox field b-validation-field']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL + "/app/#good");
    }

    @Override
    public boolean isPageOpened() {
        return isPageExist(GOODS_LABEL);
    }

    public void testGood() {
        driver.findElement(GOOD_BUTTON).click();
        driver.findElements(GOOD_FIELD).get(0).sendKeys("Good test");
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }

    public void testGoodStepOne() {
        driver.findElement(GOOD_BUTTON).click();
        driver.findElements(GOOD_FIELD).get(0).sendKeys("Good test");
    }

    public void testGoodStepTwo() {
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }
}
