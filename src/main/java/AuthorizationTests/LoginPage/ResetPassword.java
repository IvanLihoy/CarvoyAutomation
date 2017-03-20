package AuthorizationTests.LoginPage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;


import java.util.Properties;
import javax.mail.*;

import static AuthorizationTests.LoginPage.My_Login_Tests.sleep;


public class ResetPassword {
    public static WebDriver webDriver;

    public ResetPassword(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String host = "pop.gmail.com";// change accordingly
    public static final String mailStoreType = "pop3s";
    public static final String username = "lihoy92ivan@gmail.com";// change accordingly
    public static final String password = "ivan54321";// change accordingly
    //private static final Logger log = Logger.getLogger(ResetPassword.class);


    public static void getResetLink() throws Exception {
       //String reference = null;
        Properties properties = new Properties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        Store store = emailSession.getStore(mailStoreType);
        store.connect(host, username, password);
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);
        Message[] messages = emailFolder.getMessages();
        int i = 0;
        for (Message message : messages) {
            //System.out.println("---------------------------------");
            i++;
            if (message.getSubject().contains("New login from Chrome on Windows 7")) {
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
                String messageBody = message.getContent().toString();
                Document document = Jsoup.parseBodyFragment(messageBody);
                Elements link = document.body().getElementsByAttributeValueStarting("href", "https://www.dropbox.com/");
                System.out.println("link: " + link.attr("href"));
//                reference = link.attr("href");
//                System.out.println(reference);
            }
        }
      // return reference;
    }

    public void openResetLink() throws Exception {
        getResetLink();
//        String url = getResetLink();
//        webDriver.get(url);
        sleep(10);
    }


   /* public void deleteResetMessage() throws Exception {
        Properties properties = new Properties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        Store store = emailSession.getStore(mailStoreType);
        store.connect(host, username, password);
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_WRITE);
        Message [] messages = emailFolder.getMessages();
        int i =0;
        for (Message message:messages){
            i++;
            System.out.println(message.getSubject());
            if (message.getSubject().contains("Registration successfull")){
                message.setFlag(Flags.Flag.DELETED, true);
                emailFolder.close(true);
                System.out.println("Message: Registration successfull - WAS DELETED!");
                log.info("Registration successfull - WAS DELETED!");
                break;

            }

        }

    }*/
}
