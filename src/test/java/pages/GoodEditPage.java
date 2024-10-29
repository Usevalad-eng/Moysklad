package pages;

import elements.Input;
import model.AddGood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodEditPage extends BasePage{

    public GoodEditPage(WebDriver driver) {
        super(driver);
    }

    public static final By ITEM_NAME_INPUT = By.xpath("//div[text() = 'Наименование товара']");

    public void writeIntoInput(AddGood addGood){
        new Input(driver, "Артикул").write(addGood.getArticle());
        new Input(driver, "Код").write(addGood.getCode());
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
