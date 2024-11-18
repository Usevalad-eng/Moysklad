package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.AddGood;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class GoodEditPage extends BasePage{

    public GoodEditPage(WebDriver driver) {
        super(driver);
    }

    public static final By ITEM_NAME_INPUT = By.xpath("//div[text() = 'Наименование товара']");

    @Step("Write into input.")
    public void writeIntoInput(AddGood addGood){
        new Input(driver, "Артикул").write(addGood.getArticle());
        new Input(driver, "Код").write(addGood.getCode());
        log.info("write into input");
    }


    @Override
    @Step("Open page.")
    public void open() {
        driver.get(URL + "/app/#good/edit?new&type=Good");
        log.info("open page");
    }

    @Override
    @Step("Check if page opened.")
    protected boolean isPageOpened() {
        log.info("check if page opened");
        return  isPageExist(ITEM_NAME_INPUT);
    }
}
