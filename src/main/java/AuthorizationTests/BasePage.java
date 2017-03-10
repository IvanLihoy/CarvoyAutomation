package AuthorizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static final String USER_EMAIL = "v.lihoy+1@mail.ru";
    public static final String USER_PASS = "111111";
    public static final String BASE_URL = "http://leaseforlease.clever-solution.com/";

}