package AuthorizationTests.LoginPage;

import AuthorizationTests.MainPages.BasePage;
import AuthorizationTests.MainPages.WebSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 13.03.2017.
 */
public class LoginTest {
    private WebDriver driver;
    public static WebDriverWait wait;
    public BasePage basePage;
    public static WebSite website;


    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        website = new WebSite(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10 );
    }

    @AfterClass
    private void teardown(){
        driver.quit();
    }

    @Test
    public void test() throws Exception{
        website.PositiveLogin_Test();
    }
}
