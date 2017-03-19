package AuthorizationTests.MainPages;

import AuthorizationTests.LoginPage.ResetPassword;
import AuthorizationTests.MainPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



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
    public ResetPassword email() {
        return new ResetPassword(webDriver);
    }

    public void PositiveLogin_Test() throws InterruptedException {
        basePage().OpenLoginPage();
        basePage().LoginUser();
        basePage().VerifyLogin();
    }

    public void negLogin(String email, String pass, String messageError) throws Exception{
        basePage().OpenLoginPageNegativeTest();
        basePage().LoginUserNegative(email, pass);
        basePage().VerifyNegativeLogin(messageError);
    }

    //Reset Password
    public void resetPasswordUser() throws Exception {
        email().openResetLink();
    }

    //Delete Reset Message
//    public void deleteActivationMail() throws Exception{
//        email().deleteResetMessage();
//    }
}
