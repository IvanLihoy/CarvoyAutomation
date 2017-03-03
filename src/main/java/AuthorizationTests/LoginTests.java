package AuthorizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


/**
 * Created by Ivan on 03.03.2017.
 */
public class LoginTests {
    private static WebDriver driver;

        @BeforeMethod
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
        @AfterMethod
        public static void teardown(){
            driver.quit();
        }
        @Test()
        public static void PositiveLoginTest() {
            WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
            signin_button.click();
            sleep(3);
            WebElement login_field = driver.findElement(By.id("exampleInputEmail1"));
            login_field.sendKeys("v.lihoy+1@mail.ru");
            WebElement password_field = driver.findElement(By.id("exampleInputPassword1"));
            password_field.sendKeys("111111");
            WebElement sign_in_button = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/form[2]/button"));
            sign_in_button.click();
            sleep(3);
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div/div[1]")).isDisplayed());
            Assert.assertEquals("Carvoy", driver.getTitle());
            System.out.println("User is logged in");
        }
        @Test(dataProvider = "data-provider")
        public static void NegativeLoginTests(String email, String pass){
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
        }
        @DataProvider(name = "data-provider")
        public Object[][] dataProviderMethod(){
            Object[][] data = new Object[4][2];
            data[0][0] = "v.lihoy+2mail.ru";
            data[0][1] = "111111";
            data[1][0] = "v.lihoy+1@mail.ru";
            data[1][1] = "";
            data[2][0] = "";
            data[2][1] = "111111";
            data[3][0] = "";
            data[3][1] = "";
            return data;
        }

    }


