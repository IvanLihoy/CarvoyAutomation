package AuthorizationTests.LoginPage;

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

    @BeforeMethod(alwaysRun = true)
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("http://leaseforlease.clever-solution.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

    @Test(dataProvider ="data-provider", dataProviderClass = DataProviderClass.class)
    public void NegativeLoginTests(String email, String pass){
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
        driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[1]/button")).click();
        sleep(3);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a")).isDisplayed());
    }
}
