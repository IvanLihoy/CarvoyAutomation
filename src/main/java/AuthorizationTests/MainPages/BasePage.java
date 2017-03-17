package AuthorizationTests.MainPages;

import AuthorizationTests.MyWaits;
import Data.DataProviderClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static AuthorizationTests.LoginPage.My_Login_Tests.sleep;

/**
 * Created by Ivan on 10.03.2017.
 */
public class BasePage {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Positive login user
    public static final String USER_EMAIL = "v.lihoy+1@mail.ru";
    public static final String USER_PASS = "111111";
    public static final String BASE_URL = "http://leaseforlease.clever-solution.com/";
    public static final String Page_Title = "Carvoy";
    public static final String HOME_PAGE_URL = "http://leaseforlease.clever-solution.com/account/u/VA/lihoy-arlington-291/edit/requests";

    @FindBy(xpath = ".//*[@id='myCarousel']/div[2]/div/nav/div/div[2]/ul/li[3]/a") WebElement sign_in_icon;
    @FindBy(id = "exampleInputEmail1") WebElement login_field;
    @FindBy(id = "exampleInputPassword1") WebElement password_field;
    @FindBy(xpath = ".//*[@id='wrapper']/div[1]/div/div/div[2]/div/div/form[2]/button") WebElement signin_button;
    @FindBy(xpath = ".//*[@id='content']/div[2]/div[1]/div/div[1]") WebElement account_title;
    @FindBy(xpath = ".//*[@id='header-for-left-menu']/div/div/nav/div/div[2]/ul/li[2]/a")WebElement HomepageMenuDropDown;
    @FindBy(xpath = ".//*[@id='header-for-left-menu']/div/div/nav/div/div[2]/ul/li[2]/ul/li[6]/a") WebElement SignOutDropDown;
    @FindBy(xpath = ".//*[@id='header-for-left-menu']/div/div/nav/div/div[2]/ul/li[2]/a") WebElement move_mouse;

    public void OpenLoginPage(){
        webDriver.get(BASE_URL);
        sign_in_icon.click();
        wait.until(MyWaits.visibilityOfElement(login_field));
    }

    @Test()
    public void LoginUser() throws InterruptedException {
        login_field.sendKeys(USER_EMAIL);
        password_field.sendKeys(USER_PASS);
        signin_button.click();
        sleep(3);
        Assert.assertTrue(account_title.isDisplayed());
        Assert.assertEquals(Page_Title, webDriver.getTitle());
        Assert.assertTrue(webDriver.getCurrentUrl().contains(HOME_PAGE_URL));
    }

    public void VerifyLogin() throws InterruptedException{
        wait.until(MyWaits.visibilityOfElement(HomepageMenuDropDown));
        sleep(3);
        Actions builder = new Actions(webDriver);
        builder.moveToElement(move_mouse).click().build().perform();
        sleep(3);
        SignOutDropDown.click();
        sleep(3);
        wait.until(MyWaits.visibilityOfElement(sign_in_icon));
        Assert.assertTrue(sign_in_icon.isDisplayed());
    }

    //Negative Login User
    @FindBy(xpath = ".//*[@id='wrapper']/div[1]/div/div/div[1]/button") WebElement Close_button;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/div/div/div[2]/div/div/form[2]") WebElement error_message;

    public void OpenLoginPageNegativeTest(){
        webDriver.get(BASE_URL);
        sign_in_icon.click();
        wait.until(MyWaits.visibilityOfElement(login_field));
    }

    @Test(dataProvider ="data-provider", dataProviderClass = DataProviderClass.class)
    public void LoginUserNegative(String email, String pass) throws InterruptedException {
        login_field.sendKeys(email);
        password_field.sendKeys(pass);
        signin_button.click();
    }

    public void VerifyNegativeLogin(String errorMessage){
       Assert.assertTrue(Close_button.isDisplayed());
       Close_button.click();
       wait.until(MyWaits.visibilityOfElement(sign_in_icon));
       //Assert.assertEquals(errorMessage, error_message.getText());
    }

}