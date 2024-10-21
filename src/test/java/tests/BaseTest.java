package tests;

import elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected AuthPage authPage;
    protected HomePage homePage;
    protected GoodPage goodPage;
    protected GoodEditPage goodEditPage;
    protected TopMenuPage topMenuPage;
    protected UserSettingsPage userSettingsPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        authPage = new AuthPage(driver);
        homePage = new HomePage(driver);
        goodPage = new GoodPage(driver);
        goodEditPage = new GoodEditPage(driver);
        topMenuPage = new TopMenuPage(driver);
        userSettingsPage = new UserSettingsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

