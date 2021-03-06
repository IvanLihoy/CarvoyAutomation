package Data;

import org.testng.annotations.DataProvider;

/**
 * Created by Ivan on 13.03.2017.
 */
public class DataProviderClass {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod(){
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

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"v.lihoy+2mail.ru" , "111111", "Invalid email or password"},
                {"v.lihoy+1@mail.ru", "", "Password cannot be blank."},
                {"" , "", "E-mail cannot be blank."},
                {"" , "111111", "E-mail cannot be blank."}
        };
    }
}
