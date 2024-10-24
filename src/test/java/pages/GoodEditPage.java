package pages;

import elements.Input;
import model.AddGood;
import model.UserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.Input.*;
import static pages.GoodPage.*;

public class GoodEditPage extends BasePage{

    public GoodEditPage(WebDriver driver) {
        super(driver);
    }

    public static final By ITEM_NAME_INPUT = By.xpath("//div[text() = 'Наименование товара']");

    public void writeIntoInput(AddGood addGood){
        //new Input(driver, "Описание").write(addGood.getDescription());
        new Input(driver, "Артикул").write(addGood.getArticle());
        new Input(driver, "Код").write(addGood.getCode());
        // new Input(driver, "Наименование товара").write("ItemTest");
        //new Input(driver, "Артикул").write("11111");
        //new Input(driver, "Внешний код").write("4444");
        //new Input(driver, "Код").write("22222");
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
