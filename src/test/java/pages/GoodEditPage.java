package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.Input.*;
import static pages.GoodPage.*;

public class GoodEditPage extends BasePage{

    public GoodEditPage(WebDriver driver) {
        super(driver);
    }

    public static final By ITEM_NAME_INPUT = By.xpath("//div[text() = 'Наименование товара']");

    public void writeIntoInput(){
        new Input(driver, "Наименование товара").write("Item1Test");
        new Input(driver, "Артикул").write("11111");
        new Input(driver, "Внешний код").write("1111114444");
        new Input(driver, "Код").clear();
        new Input(driver, "Код").write("22222");
    }

    public void testGoodWithData() {
        driver.findElement(GOOD_BUTTON).click();
        //driver.findElements(GOOD_FIELD).get(0).sendKeys("Good test");
        writeIntoInput();
        //wait
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_BUTTON).click();
    }

    @Override
    public void open() {
        driver.get(URL + "/app/#good/edit?new&type=Good");
    }

    @Override
    protected boolean isPageOpened() {
        return  isPageExist(ITEM_NAME_INPUT);
    }
}
