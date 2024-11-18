package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TopMenuPage extends BasePage{

    protected static final By MENU_USERNAME = By.xpath("//div[@class = 'menu-username-new']");
    protected String menuBarOption = "//td[@class = 'gwt-MenuItem' and text() = '%s']";
    protected String topMenuOption = "//span[text() = '%s']/ancestor::td[@class = 'topMenuItem-new']//span[text() = '%s']";
    protected String menuOption = "//span[text() = '%s']/ancestor::div[@class = 'subMenuContainer-new']//span[text() = '%s']";

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select menu bar option.")
    public void selectMenuBarOption(String option){
        driver.findElement(MENU_USERNAME).click();
        driver.findElement(By.xpath(String.format(menuBarOption, option))).click();
        log.info("select menu bar option");
    }

    @Step("Select TopMenuOption.")
    public void selectTopMenuOption(String option1, String option2){
        driver.findElement(By.xpath(String.format(topMenuOption, option1, option2))).click();
        log.info("select menu option");
    }

    @Step("Select MenuOption.")
    public void selectMenuOption(String option1, String option2){
        driver.findElement(By.xpath(String.format(menuOption, option1, option2))).click();
        log.info("select menu option");
    }

    @Override
    @Step("Open page.")
    public void open() {
        driver.get(URL + "/app/#homepage");
        log.info("open page");
    }

    @Override
    @Step("Check if page opened.")
    protected boolean isPageOpened() {
        log.info("check if page opened");
        return isPageExist(MENU_USERNAME);
    }
}
