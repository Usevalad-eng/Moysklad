package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthPage;
import pages.GoodPage;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    //protected WebDriverWait wait;
    protected AuthPage authPage;
    protected HomePage homePage;
    protected GoodPage goodPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        authPage = new AuthPage(driver);
        homePage = new HomePage(driver);
        goodPage = new GoodPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

