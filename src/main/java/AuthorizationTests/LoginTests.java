package AuthorizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Ivan on 03.03.2017.
 */
public class LoginTests {
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
            //driver.quit();
        }

        //@Parameters({"loginEmail", "loginPassword"})
//        @Test()
//        public static void PositiveLoginTest(String email, String Password) {
//            WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
//            signin_button.click();
//            sleep(3);
//            WebElement login_field = driver.findElement(By.id("exampleInputEmail1"));
//            login_field.sendKeys("v.lihoy+1@mail.ru");
//            WebElement password_field = driver.findElement(By.id("exampleInputPassword1"));
//            password_field.sendKeys("111111");
//            WebElement sign_in_button = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/form[2]/button"));
//            sign_in_button.click();
//            sleep(3);
//            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div/div[1]")).isDisplayed());
//            Assert.assertEquals("Carvoy", driver.getTitle());
//            System.out.println("User is logged in");
//
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//            boolean exists = driver.findElements( By.id(".//*[@id='content']/div[2]/div[1]/div/div[1]") ).size() != 0;
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//        }
//        @Test(dataProvider = "data-provider")
//        public static void NegativeLoginTests(String email, String pass){
//            WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
//            signin_button.click();
//            sleep(3);
//            WebElement login_field = driver.findElement(By.id("exampleInputEmail1"));
//            login_field.sendKeys(email);
//            WebElement password_field = driver.findElement(By.id("exampleInputPassword1"));
//            password_field.sendKeys(pass);
//            WebElement sign_in_button = driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/form[2]/button"));
//            sign_in_button.click();
//            sleep(3);
//            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[1]/button")).isDisplayed());
//
//            boolean present;
//            try {
//                driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div/div/div[1]/button"));
//                present = true;
//            } catch (NoSuchElementException e) {
//                present = false;
//            }
//        }
//        @DataProvider(name = "data-provider")
//        public Object[][] dataProviderMethod(){
//            Object[][] data = new Object[4][2];
//            data[0][0] = "v.lihoy+2mail.ru";
//            data[0][1] = "111111";
//            data[1][0] = "v.lihoy+1@mail.ru";
//            data[1][1] = "";
//            data[2][0] = "";
//            data[2][1] = "111111";
//            data[3][0] = "";
//            data[3][1] = "";
//            return data;
//        }
        @Test
        public static void ForgotPasswordLinkPositiveTest(){
            WebElement signin_button = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a"));
            signin_button.click();
            sleep(3);
            WebElement forgot_password_link = driver.findElement(By.linkText("FORGOT PASSWORD?"));
            forgot_password_link.click();
            sleep(3);
            WebElement email_field = driver.findElement(By.id("exampleInputEmail11"));
            email_field.sendKeys("lihoy@clever-solution.com");
            WebElement submit_button = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/form/button"));
            submit_button.click();
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a")).isDisplayed());
        }
        @Test(dependsOnMethods={"ForgotPasswordLinkPositiveTest"})
        public static void ResetYourPassword(){
            driver.get("https://mail.yandex.ua/");
            WebElement username = driver.findElement(By.className("_nb-input-controller"));
            username.sendKeys("lihoy@clever-solution.com");
            WebElement password = driver.findElement(By.name("passwd"));
            password.sendKeys("UZy&CU2C");
            driver.findElement(By.xpath(".//*[@id='js']/body/div[1]/div[1]/div[1]/form/div[4]/span/button")).click();
            sleep(3);
            driver.findElement(By.xpath(".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[4]/div[1]/div/div/div[2]/div/div[1]")).click();
            sleep(2);

                              // Open link in new window
//            driver.findElement(By.xpath(".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[4]/div[1]/div/div[3]/div/div/p[3]/a")).click();
//            sleep(10);
//            WebElement link = driver.findElement(By.xpath(".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[4]/div[1]/div/div[3]/div/div/p[3]/a"));
//            Actions new_win = new Actions(driver);
//            new_win.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
//            sleep(6);
                            // Find element in new window
            driver.findElement(By.xpath(".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[4]/div[1]/div/div[3]/div/div/p[3]/a")).click();
            String parentHandle = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            WebElement pass = driver.findElement(By.xpath(".//*[@id='recoveryconfirmationform-password']"));
            pass.sendKeys("111111");
            WebElement re_pass = driver.findElement(By.xpath(".//*[@id='recoveryconfirmationform-repassword']"));
            re_pass.sendKeys("111111");
            driver.findElement(By.xpath(".//*[@id='w0']/fieldset/div[4]/button")).click();
            sleep(5);
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a/span[1]")).isDisplayed());
//            driver.close();
//            driver.switchTo().window(parentHandle);
        }
}


