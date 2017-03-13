package AuthorizationTests.MainPages;

import AuthorizationTests.MainPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ivan on 13.03.2017.
 */
public class WebSite {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public WebSite(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public BasePage basePage(){
        return new BasePage(webDriver);
    }

    public void PositiveLogin_Test() throws InterruptedException {
        basePage().OpenLoginPage();
        basePage().LoginUser();
        basePage().VerifyLogin();
    }

}
