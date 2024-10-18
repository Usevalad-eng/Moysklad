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
        new Input(driver, "Наименование товара").write("Item1_Test");
        new Input(driver, "Артикул").write("Article1_Test");
        new Input(driver, "Внешний код").write("OutCode1_Test");
        new Input(driver, "Код").clear();
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
