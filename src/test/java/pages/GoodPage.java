package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class GoodPage extends BasePage{

    public static final By GOODS_LABEL = By.xpath("//td/div[text() = 'Товары и услуги']");
    public static final By GOOD_BUTTON = By.xpath("//span[text() = 'Товар']");
    public static final By GOOD_FIELD = By.xpath("//input[@class = 'gwt-TextBox field b-validation-field']");
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    public static final By CLOSE_BUTTON = By.xpath("//span[text() = 'Закрыть']");
    public static final By GOOD_CREATED = By.xpath("//div[text() = 'Товар создан']");

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("open good page")
    public void open() {
        driver.get(URL + "/app/#good");
        log.info("--open good page");
    }

    @Override
    @Step("check if page opened")
    public boolean isPageOpened() {
        log.info("--check if page opened");
        return isPageExist(GOODS_LABEL);
    }

    @Step("check if page saved")
    public boolean isGoodPageSaved(){
        log.info("--check if page saved");
        return driver.findElement(GOOD_CREATED).isDisplayed();
    }

    public void testGood() {
        driver.findElement(GOOD_BUTTON).click();
        driver.findElements(GOOD_FIELD).get(0).sendKeys("Good item test");
        driver.findElements(GOOD_FIELD).get(1).sendKeys("Good item test");
        driver.findElements(GOOD_FIELD).get(3).sendKeys("Good item test");
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }

    @Step("create good item")
    public void testGoodStepOne() {
        driver.findElement(GOOD_BUTTON).click();
        driver.findElements(GOOD_FIELD).get(0).sendKeys("Good test");
        log.info("--create good item");
    }

    @Step("saving")
    public void testGoodStepTwo() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("--saving");
    }
}
