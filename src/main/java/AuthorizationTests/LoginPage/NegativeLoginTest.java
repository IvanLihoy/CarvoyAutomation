package AuthorizationTests.LoginPage;

import AuthorizationTests.MainPages.BasePage;
import AuthorizationTests.MainPages.WebSite;
import Data.DataProviderClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by Ivan on 13.03.2017.
 */
public class NegativeLoginTest {
    private static WebDriver driver;

    public static BasePage basePage;
    public static WebSite webSite;

    @BeforeMethod(alwaysRun = true)
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("http://leaseforlease.clever-solution.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        basePage = new BasePage(driver);
        webSite = new WebSite(driver);
    }
    public static void sleep(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod(alwaysRun = true)
    public static void teardown(){
        driver.quit();
    }

    @Test(dataProvider ="loginData", dataProviderClass = DataProviderClass.class)
    public void negativeLoginTests(String email, String pass, String error){
        WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
        signin_button.click();
        sleep(3);
        WebElement login_field = driver.findElement(By.id("exampleInputEmail1"));
        login_field.sendKeys(email);
        WebElement password_field = driver.findElement(By.id("exampleInputPassword1"));
        password_field.sendKeys(pass);
        WebElement sign_in_button = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/form[2]/button"));
        sign_in_button.click();
        sleep(3);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[1]/button")).isDisplayed());
//        driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[1]/button")).click();
//        sleep(3);
//        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a")).isDisplayed());

        WebElement element = driver.findElement(By.xpath("//*/div/input[@data-tooltip='']"));
        element.getAttribute("data-tooltip");
        System.out.println(element);
        //Assert.assertEquals(driver.findElement(By.xpath("//*/div/input[@data-tooltip='']")).getText(), error);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void invalidLogin(String email, String pass, String error) throws Exception {
        webSite.negLogin(email, pass, error);
    }

}
