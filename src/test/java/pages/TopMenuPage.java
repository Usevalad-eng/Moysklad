package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TopMenuPage extends BasePage{

    protected static final By MENU_USERNAME = By.xpath("//div[@class = 'menu-username-new']");
    protected String menuBarOption = "//td[@class = 'gwt-MenuItem' and text() = '%s']";

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("select menu bar option")
    public void selectMenuBarOption(String option){
        driver.findElement(MENU_USERNAME).click();
        driver.findElement(By.xpath(String.format(menuBarOption, option))).click();
        log.info("--select menu bar option");
    }
    @Override
    @Step("open page")
    public void open() {
        driver.get(URL + "/app/#homepage");
        log.info("--open page");
    }

    @Override
    @Step("check if page opened")
    protected boolean isPageOpened() {
        log.info("--check if page opened");
        return isPageExist(MENU_USERNAME);
    }
}
