package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuPage extends BasePage{

    protected static final By MENU_USERNAME = By.xpath("//div[@class = 'menu-username-new']");
    protected String menuBarOption = "//td[@class = 'gwt-MenuItem' and text() = '%s']";

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void selectMenuBarOption(String option){
        driver.findElement(MENU_USERNAME).click();
        driver.findElement(By.xpath(String.format(menuBarOption, option))).click();
    }
    @Override
    public void open() {
        driver.get(URL + "/app/#homepage");
    }

    @Override
    protected boolean isPageOpened() {
        return isPageExist(MENU_USERNAME);
    }
}
