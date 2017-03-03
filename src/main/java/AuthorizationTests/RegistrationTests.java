package AuthorizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 03.03.2017.
 */
public class RegistrationTests {
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
    public static void PositiveRegistrationTest() {
        WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
        signin_button.click();
        sleep(3);
        WebElement signup_button = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/div[2]/a/b"));
        signup_button.click();
        WebElement first_name = driver.findElement(By.id("first-name"));
        first_name.sendKeys("first-name");
        WebElement last_name = driver.findElement(By.id("second-name"));
        last_name.sendKeys("second-name");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("lihoysingree.com");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("0999999999");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1111111");
        WebElement confirm_password = driver.findElement(By.id("password"));
        confirm_password.sendKeys("1111111");
        WebElement zip_code = driver.findElement(By.id("zip"));
        zip_code.sendKeys("2222");
        WebElement signup_button_click = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div[2]/form/button"));
        signup_button_click.click();
        sleep(8);
    }
}
